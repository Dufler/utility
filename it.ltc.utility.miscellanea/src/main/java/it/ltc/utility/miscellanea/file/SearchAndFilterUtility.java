package it.ltc.utility.miscellanea.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SearchAndFilterUtility {
	
	private static final boolean recursive = false;
	
	public void searchAndFilterFilesInFolder(File folder, String[] matches) throws IOException {
		File[] listaFile = folder.listFiles();
		for (File file : listaFile) {
			if (file.isDirectory()) {
				if (recursive)
					searchAndFilterFilesInFolder(file, matches);
			} else {
				System.out.println("Esamino il file: " + file.getName());
				StringBuilder sb = new StringBuilder();
				FileReader input = new FileReader(file);
				BufferedReader reader = new BufferedReader(input);
				String line = reader.readLine();
				while (line != null) {
					for (String match : matches) {
						if (line.contains(match)) {
							sb.append(line);
							sb.append("\r\n");
							break;
						}
					}
					line = reader.readLine();
				}
				reader.close();
				//Scrivo quello che ho trovato nello stesso file
				FileWriter output = new FileWriter(file);
				BufferedWriter writer = new BufferedWriter(output);
				writer.write(sb.toString());
				writer.flush();
				writer.close();
			}
		}
	}

}
