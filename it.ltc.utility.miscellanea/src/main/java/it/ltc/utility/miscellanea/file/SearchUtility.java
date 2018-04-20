package it.ltc.utility.miscellanea.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchUtility {
	
	private String folderPath;
	private String fileName;
	private boolean recursive;
	
	public SearchUtility(){
		recursive = false;
	}

	public boolean search(String match) throws IOException {
		boolean found = false;
		//Verifiche
		if (match == null || match.isEmpty())
			throw new IllegalArgumentException("Specifica una stringa!");
		if (folderPath == null || folderPath.isEmpty())
			throw new IllegalStateException("Specifica un percorso dove cercare!");
		File folder = new File(folderPath);
		if (folder.isDirectory()) {
			found = searchInFolder(folder, match);
		} else {
			throw new IllegalStateException("Specifica un percorso valido!");
		}
		return found;
	}
	
	public boolean searchInFolder(File folder, String match) throws IOException {
		boolean found = false;
		File[] listaFile = folder.listFiles();
		for (File file : listaFile) {
			if (file.isDirectory()) {
				if (recursive)
					found = searchInFolder(file, match);
			} else {
				System.out.println("Esamino il file: " + file.getName());
				FileReader reader = new FileReader(file);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				while (line != null) {
					if (line.contains(match)) {
						System.out.println("Trovato!");
						found = true;
						fileName = file.getAbsolutePath();
						break;
					}
					line = buffer.readLine();
				}
				buffer.close();
				reader.close();
			}
			if (found)
				break;
		}
		return found;
	}

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	public String getFileName() {
		return fileName;
	}
	
	public boolean isRecursive() {
		return recursive;
	}

	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}

}
