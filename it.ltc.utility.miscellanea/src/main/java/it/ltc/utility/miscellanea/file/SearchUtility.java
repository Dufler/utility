package it.ltc.utility.miscellanea.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class SearchUtility {
	
	private String folderPath;
	private String fileName;
	private final boolean recursive;
	private final boolean stopAtFirstMatch;
	private final boolean ignoreCase;
	
	private final List<String> matches;
	
	public SearchUtility() {
		this(false, true, true);
	}
	
	public SearchUtility(boolean recursive, boolean stopAtFirstMatch, boolean ignoreCase) {
		this.recursive = recursive;
		this.stopAtFirstMatch = stopAtFirstMatch;
		this.ignoreCase = ignoreCase;
		matches = new LinkedList<>();
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
		boolean found = false; //FIXME - Quando è ricorsivo non posso azzerarlo così.
		matches.clear();
		File[] listaFile = folder.listFiles();
		for (File file : listaFile) {
			if (file.isDirectory()) {
				if (recursive)
					found = searchInFolder(file, match);
			} else {
				System.out.println("Esamino il file: " + file.getName());
				int lineIndex = 1;
				FileReader reader = new FileReader(file);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				while (line != null) {
					if (ignoreCase ? StringUtils.containsIgnoreCase(line, match) : line.contains(match)) {
						System.out.println("Trovato!");
						found = true;
						fileName = file.getAbsolutePath();
						matches.add(file.getAbsolutePath() + ", line " + lineIndex);
						if (stopAtFirstMatch)
							break;
					}
					line = buffer.readLine();
					lineIndex++;
				}
				buffer.close();
				reader.close();
			}
			if (stopAtFirstMatch && found)
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

	public boolean isStopAtFirstMatch() {
		return stopAtFirstMatch;
	}

	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	public List<String> getMatches() {
		return matches;
	}

}
