package it.ltc.importazione;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import it.ltc.importazione.model.centergross.AziendaCentergross;
import it.ltc.importazione.model.white.AziendaWhite;

public class MainImportazioneCentergross {
	
	private static final String filePath = "C:/Users/Damiano/Documents/LTC/Commerciale/pdc/centergross.txt";
	private static final String fileOutputPath = "C:/Users/Damiano/Documents/LTC/Commerciale/pdc/output.txt";

	public static void main(String[] args) throws Exception {
		System.out.println("Avvio la procedura.");
		List<AziendaCentergross> aziende = new LinkedList<>();
		//Leggo
		File file = new File(filePath);
		FileReader reader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(reader);
		String line;
		try {
			do {
				String ragioneSociale = bReader.readLine().trim();
				String ambito = bReader.readLine().trim();
				String ubicazione = bReader.readLine().trim();
				//Controllo
				if (!ubicazione.startsWith("Blocco"))
					throw new RuntimeException("file sbagliato");
				line = bReader.readLine().trim();
				String contatti = line; 
				while (!line.isEmpty()) {
					line = bReader.readLine().trim();
					contatti += " " + line;
				}
				AziendaCentergross azienda = new AziendaCentergross(ragioneSociale, ambito, ubicazione, contatti);
				aziende.add(azienda);
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
		for (AziendaCentergross azienda : aziende) {
			writer.write(azienda.toString());
			writer.write("\r\n");
		}
		writer.flush();
		writer.close();
		System.out.println("Termine della procedura.");
	}

}
