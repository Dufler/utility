package it.ltc.importazione;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import it.ltc.importazione.model.white.AziendaWhite;

public class MainImportazioneWhite {
	
	private static final String filePath = "C:/Users/Damiano/Desktop/white2017/white.txt";
	private static final String fileOutputPath = "C:/Users/Damiano/Desktop/white2017/output.txt";

	public static void main(String[] args) throws Exception {
		System.out.println("Avvio la procedura.");
		List<AziendaWhite> aziende = new LinkedList<>();
		//Leggo
		File file = new File(filePath);
		FileReader reader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(reader);
		String line;
		try {
			do {
				line = bReader.readLine(); //ragione sociale
				String ragioneSociale = line;
				if (ragioneSociale == null || ragioneSociale.isEmpty())
					throw new RuntimeException("non c'è la ragione sociale.");
				line = bReader.readLine(); //riga vuota
				line = bReader.readLine(); //sito web
				String sitoWeb = line;
				line = bReader.readLine(); //padiglione
				String padiglione = line;
				if (padiglione == null || padiglione.isEmpty())
					throw new RuntimeException("non c'è il padiglione.");
				line = bReader.readLine(); //tipologie
				String tipologie = line;
				AziendaWhite azienda = new AziendaWhite(ragioneSociale, sitoWeb, padiglione, tipologie);
				aziende.add(azienda);
				line = bReader.readLine(); //riga vuota
				line = bReader.readLine(); //riga vuota
			} while (line != null);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			bReader.close();
		}
		//Scrivo
		File output = new File(fileOutputPath);
		FileWriter writer = new FileWriter(output);
		writer.write(AziendaWhite.NOMI_CAMPI);
		writer.write("\r\n");
		for (AziendaWhite azienda : aziende) {
			writer.write(azienda.toString());
			writer.write("\r\n");
		}
		writer.flush();
		writer.close();
		System.out.println("Termine della procedura.");
	}

}
