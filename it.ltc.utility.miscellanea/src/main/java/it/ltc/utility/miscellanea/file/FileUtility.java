package it.ltc.utility.miscellanea.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Questa classe contiene utility per la manipolazione di files.
 * 
 * @author Damiano Bellucci - damiano.bellucci@gmail.com
 * @version 1.1
 *
 */
public class FileUtility {
	
	public static ArrayList<String> readLines(File file) throws IOException {
		ArrayList<String> lines = new ArrayList<>();
		if (file.isFile()) {
			FileReader inputStream = new FileReader(file);
			BufferedReader reader = new BufferedReader(inputStream);
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		}
		return lines;
	}
	
	/**
	 * Legge un file dal percorso specificato.
	 * @param path il percorso del file in locale.
	 * @return una stringa che rappresenta il contenuto del file.
	 * @throws IOException nel caso in cui ci siano stati problemi in lettura.
	 */
	public static String readFile(String path) throws IOException {
		String file = new String(getFile(path));
		return file;
	}
	
	/**
	 * Legge un file dal percorso specificato.
	 * @param path il percorso del file in locale.
	 * @return un array di byte che rappresenta il file o null in caso che il percorso specificato non sia un file.
	 * @throws IOException nel caso in cui ci siano stati problemi in lettura.
	 */
	public static byte[] getFile(String path) throws IOException {
		byte[] file = null;
		File f = new File(path);
		if (f.isFile()) {
			FileInputStream inputStream = new FileInputStream(path);
			file = new byte[inputStream.available()];
			int length = inputStream.read(file);
			if (length == -1) {
				System.out.println("Errore nella lettura del file.");
			}
			inputStream.close();
		}		
		return file;
	}
	
	/**
	 * Metodo utilizzabile per scrivere un file in locale
	 * @param path il percorso dove salvare il file
	 * @param file il contenuto del file sotto forma di stringa
	 * @return l'esito dell'operazione
	 */
	public static boolean writeFile(String path, String file) {
		byte[] bytes = file.getBytes();
		boolean success = writeFile(path, bytes);
		return success;
	}

	/**
	 * Metodo utilizzabile per scrivere un file in locale
	 * @param path il percorso dove salvare il file
	 * @param file il contenuto del file sotto forma di array di byte
	 * @return l'esito dell'operazione
	 */
	public static boolean writeFile(String path, byte[] file) {
		boolean success = true;
		try {
			FileOutputStream out = new FileOutputStream(path);
			out.write(file);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			success = false;
			System.out.println("Nome file riservato: " + e.getMessage());
		} catch (IOException e) {
			success = false;
			System.out.println("Errore in scrittura: " + e.getMessage());
		}
		return success;
	}
}
