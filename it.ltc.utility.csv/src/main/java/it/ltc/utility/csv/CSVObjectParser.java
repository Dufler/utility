package it.ltc.utility.csv;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import it.ltc.utility.csv.annotation.CampoCSV;

public class CSVObjectParser<T> {
	
	private static final Logger logger = Logger.getLogger(CSVObjectParser.class);
	
	protected final Class<T> c;
	protected final HashMap<CampoCSV, Field> mappaCampi;
	
	public CSVObjectParser(Class<T> c) {
		this.c = c;
		this.mappaCampi = CSVObjectMapper.mappaClasse(c);
	}
	
	protected Object estraiValore(CampoCSV annotazioneCampo, FileCSV csv, Field field) {
		Object value;
		String colonna = annotazioneCampo.name();
		String valore = csv.getStringa(colonna);
		if (valore == null && annotazioneCampo.useDefaultValueOnError())
			valore = annotazioneCampo.defaultValue();
		else if ((valore == null || valore.isEmpty()) && annotazioneCampo.useDefaultValueIfEmpty())
			valore = annotazioneCampo.defaultValue();
		
		Class<?> type = field.getType();
		if (type.equals(String.class)) {
			value = valore;
		} else if (type.equals(Boolean.class)) {
			value = csv.getBooleano(colonna);
		} else if (type.equals(Integer.class)) {
			value = csv.getIntero(colonna);
		} else if (type.equals(Double.class)) {
			value = csv.getNumerico(colonna); //getDecimale(valore, annotazioneCampo.decimals());
		} else if (type.equals(Date.class)) {
			value = csv.getData(colonna); //getData(valore, annotazioneCampo.dateFormat());
		} else {
			value = null;
		}
		
		return value;
	}
	
	public List<T> parsaOggetti(String filePath) throws Exception {
		File file = new File(filePath);
		return parsaOggetti(file);
	}
	
	public List<T> parsaOggetti(File file) throws Exception {
		FileCSV csv = FileCSV.leggiFile(file);
		List<T> list = new LinkedList<>();
		while (csv.prossimaRiga())
			list.add(parsaOggetto(csv)); 
		return list;
	}

	public T parsaOggetto(FileCSV csv) {		
		T object;
		try {
			//Istanzio un nuovo oggetto.
			object = c.newInstance();
			//Recupero i campi che sono stati annotati
			for (CampoCSV annotazioneCampo : mappaCampi.keySet()) {
				Field field = mappaCampi.get(annotazioneCampo);
				//Estraggo il valore dalla stringa in base alle indicazioni nella annotazione.
				Object value = estraiValore(annotazioneCampo, csv, field);
				//valorizzo il campo.
				field.set(object, value);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error(e.getMessage(), e);
			object = null;
		}
		return object;
	}

}
