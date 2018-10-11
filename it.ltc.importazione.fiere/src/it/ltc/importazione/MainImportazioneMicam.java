package it.ltc.importazione;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import it.ltc.importazione.model.micam.AziendaMicam;

public class MainImportazioneMicam {
	
	private static final String folderPath = "C:/Users/Damiano/Documents/LTC/Commerciale/micam/";

	public static void main(String[] args) throws Exception {
		System.out.println("Avvio la procedura.");
		List<AziendaMicam> aziende = new LinkedList<AziendaMicam>();
		File folder = new File(folderPath);
		for (File file : folder.listFiles()) {
			if (file.isFile() && file.getName().endsWith(".txt")) {
				String regione = file.getName().substring(0, 3);
				FileReader reader = new FileReader(file);
				BufferedReader bReader = new BufferedReader(reader);
				String line;
				try {
					do {
						
						line = bReader.readLine();
						if (line == null) break;
						
						String rigaNome = line;  //ragione sociale
						if (rigaNome.isEmpty())
							throw new RuntimeException("non c'è la ragione sociale.");
						
						line = bReader.readLine(); //padiglione
						String padiglione = line;
						if (padiglione == null || padiglione.isEmpty())
							throw new RuntimeException("non c'è il padiglione.");
						
						line = bReader.readLine(); //indirizzo
						String indirizzo = line;
						if (indirizzo == null || indirizzo.isEmpty())
							throw new RuntimeException("non c'è l'indirizzo.");
						
						line = bReader.readLine(); //vai alla scheda...
						if (line == null || !line.trim().contains("SCHEDA"))
							throw new RuntimeException("non c'è la separazione.");
						
						AziendaMicam azienda = new AziendaMicam(rigaNome, indirizzo, regione, padiglione);
						aziende.add(azienda);
					} while (line != null);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				bReader.close();
			} else {
				System.out.println("Trovato file/cartella non conforme.");
			}
		}
		File output = new File(folderPath + "output.csv");
		FileWriter writer = new FileWriter(output);
		writer.write(AziendaMicam.NOMI_CAMPI);
		writer.write("\r\n");
		for (AziendaMicam azienda : aziende) {
			writer.write(azienda.toString());
			writer.write("\r\n");
		}
		writer.flush();
		writer.close();
		System.out.println("Termine della procedura.");
	}

}
