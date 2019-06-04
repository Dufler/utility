package it.ltc.legacy.refactoring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class MainRefactoring {
	
	public static final String rootFolderPath = "C:/Users/Damiano/Desktop/sorgente/cucinelligest/";
	
	public static final String matchToFind = "^\\s*Dim \\S+ As New ADODB.Recordset.*";
	
	public static final String encoding = "ISO-8859-1";
	
	public static final List<String> fileModificati = new LinkedList<>();

	public static void main(String[] args) {
		File rootFolder = new File(rootFolderPath);
		scansionaCartella(rootFolder);
		report();
	}
	
	private static void report() {
		System.out.println("Lista dei file modificati:");
		for (String fileName : fileModificati) {
			System.out.println(fileName);
		}
	}
	
	private static void scansionaCartella(File folder) {
		System.out.println("Scansiono la cartella: '" + folder.getName() + "'");
		for(File file : folder.listFiles()) {
			if (file.isDirectory()) {
				scansionaCartella(file);
			} else if (file.exists()) {
				try {
					refactoring(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void refactoring(File file) throws Exception {
		String fileName = file.getName();
		if (fileName.endsWith(".frm") || fileName.endsWith(".cls") || fileName.endsWith(".bas")) {
			addUseClient(file);
		}
	}
	
	private static void addUseClient(File file) throws Exception {
		String fileName = file.getName();
		System.out.println("Eseguo il refactoring per il file: '" + fileName + "'");
		//Leggo il file, riga per per riga
		boolean replacement = false;
		StringBuilder sb = new StringBuilder();
		FileInputStream reader = new FileInputStream(file);
		InputStreamReader in = new InputStreamReader(reader, encoding);
		BufferedReader bReader = new BufferedReader(in);
		String line = bReader.readLine();
		while (line != null) {
			//Se nella riga incontro un match allora eseguo una replace altrimenti la lascio così come è
			if (line.matches(matchToFind)) {
				String[] words = line.split("\\s+");
				int index = 0;
				for (int i = 0; i < words.length && index == 0; i++) {
					if ("Dim".equals(words[i]))
						index = i + 1;
				}
				String element = words[index];
				String addition = element + ".CursorLocation = adUseClient";
				line += "\r\n" + addition;
				replacement = true;
			}
			sb.append(line + "\r\n");
			line = bReader.readLine();
		}
		bReader.close();			
		//Se ho fatto cambiamenti ci ricopio dentro la nuova versione.
		if (replacement) {
			String fileContent = sb.toString();
			FileOutputStream writer = new FileOutputStream(file);
			OutputStreamWriter out = new OutputStreamWriter(writer, encoding);
			BufferedWriter bWriter = new BufferedWriter(out);
			bWriter.write(fileContent);
			bWriter.flush();
			bWriter.close();
			fileModificati.add(fileName);
			System.out.println("Sono state fatte modifiche sul file '" + fileName + "'");
		}
	}

}
