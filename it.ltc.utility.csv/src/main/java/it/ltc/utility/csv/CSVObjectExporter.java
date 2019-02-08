package it.ltc.utility.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import it.ltc.utility.csv.annotation.CampoCSV;
import it.ltc.utility.csv.annotation.OrdinatoreCampi;

/**
 * Classe che esporta un insieme di oggetti in un file .csv
 * @author Damiano
 *
 * @param <T> La classe di oggetti da tradurre in formato .csv
 */
public class CSVObjectExporter<T> {
	
	private static final Logger logger = Logger.getLogger(CSVObjectExporter.class);
	
	public static final String DEFAULT_SEPARATOR = ";";
	public static final String DEFAULT_NEW_LINE = "\r\n";
	
	protected final String separator;
	protected final String newLine;
	
	protected final Class<T> c;
	protected final HashMap<CampoCSV, Field> mappaCampi;
	
	public CSVObjectExporter(Class<T> c) {
		this(DEFAULT_SEPARATOR, DEFAULT_NEW_LINE, c);
	}
	
	public CSVObjectExporter(String separator, String newLine, Class<T> c) {
		this.separator = separator;
		this.newLine = newLine;
		this.c = c;
		this.mappaCampi = CSVObjectMapper.mappaClasse(c);
	}
	
	public boolean esportaOggetti(String filePath, List<T> objects) {
		File file = new File(filePath);
		return esportaOggetti(file, objects);
	}
	
	public boolean esportaOggetti(File file, List<T> objects) {
		boolean export;
		try {
			StringBuilder sb = new StringBuilder();
			//Scrivo i nomi delle colonne, ordinandoli se possibile.
			List<CampoCSV> campi = getListaCampiOrdinata();
			String intestazione = getIntestazione(campi);
			sb.append(intestazione);
			//Scrivo una riga per ogni oggetto
			for (T object : objects) {
				String riga = getRiga(campi, object);
				sb.append(riga);
			}
			scriviSuFile(file, sb.toString());
			export = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			export = false;
		}
		return export;
	}
	
	public boolean esportaOggetto(String filePath, T object) {
		File file = new File(filePath);
		return esportaOggetto(file, object);
	}
	
	public boolean esportaOggetto(File file, T object) {
		boolean export;
		try {
			StringBuilder sb = new StringBuilder();
			//Scrivo i nomi delle colonne, ordinandoli se possibile.
			List<CampoCSV> campi = getListaCampiOrdinata();
			String intestazione = getIntestazione(campi);
			sb.append(intestazione);
			//Scrivo una riga per l'oggetto
			String riga = getRiga(campi, object);
			sb.append(riga);
			//Scrivo il file
			scriviSuFile(file, sb.toString());
			export = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			export = false;
		}
		return export;
	}
	
	protected List<CampoCSV> getListaCampiOrdinata() {
		List<CampoCSV> campi = new LinkedList<>();
		campi.addAll(mappaCampi.keySet());
		campi.sort(new OrdinatoreCampi());
		return campi;
	}
	
	protected String getIntestazione(List<CampoCSV> campi) {
		StringBuilder sb = new StringBuilder();
		for (CampoCSV campo : campi) {
			sb.append(campo.name());
			sb.append(separator);
		}
		sb.delete(sb.length() - separator.length(), sb.length());
		sb.append(newLine);
		return sb.toString();
	}
	
	protected String getRiga(List<CampoCSV> campi, T object) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (CampoCSV campo : campi) {
			Field field = mappaCampi.get(campo);
			if (!field.isAccessible()) field.setAccessible(true);
			Object value = field.get(object); 
			sb.append(value != null ? value : "");
			sb.append(separator);
//			Class<?> type = field.getType();
//			if (type.equals(String.class)) {
//				value = valore;
//			} else if (type.equals(Boolean.class)) {
//				value = csv.getBooleano(colonna);
//			} else if (type.equals(Integer.class)) {
//				value = csv.getIntero(colonna);
//			} else if (type.equals(Double.class)) {
//				value = csv.getNumerico(colonna); //getDecimale(valore, annotazioneCampo.decimals());
//			} else if (type.equals(Date.class)) {
//				value = csv.getData(colonna); //getData(valore, annotazioneCampo.dateFormat());
//			} else {
//				value = null;
//			}
		}
		sb.delete(sb.length() - separator.length(), sb.length());
		sb.append(newLine);
		return sb.toString();
	}
	
	protected void scriviSuFile(File file, String content) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
	}

}
