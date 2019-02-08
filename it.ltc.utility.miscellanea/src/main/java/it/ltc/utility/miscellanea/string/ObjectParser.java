package it.ltc.utility.miscellanea.string;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import it.ltc.utility.miscellanea.file.FileUtility;
import it.ltc.utility.miscellanea.string.annotation.Campo;

public class ObjectParser<T> extends StringValueParser {
	
	private static final Logger logger = Logger.getLogger(ObjectParser.class);
	
	@SuppressWarnings("rawtypes")
	private static final HashMap<Class, HashMap<Field, Campo>> mappaClassi = new HashMap<>();
	
	protected final Class<T> c;
	protected final int lunghezzaMinima;
	protected final HashMap<Field, Campo> mappaCampi;
	
	public ObjectParser(Class<T> c, int lunghezzaMinima) {
		this.c = c;
		this.lunghezzaMinima = lunghezzaMinima;
		this.mappaCampi = mappaClasse();
	}
	
	protected HashMap<Field, Campo> mappaClasse() {
		if (!mappaClassi.containsKey(c)) {
			logger.debug("Eseguo il mappaggio per la classe " + c.getSimpleName());
			HashMap<Field, Campo> mappaCampi = new HashMap<>();
			for (Field field : c.getDeclaredFields()) {
				Campo annotazioneCampo = field.getAnnotation(Campo.class);
				if (annotazioneCampo != null) {
					logger.debug("Trovata annotazione per il campo " + field.getName());
					mappaCampi.put(field, annotazioneCampo);
				}
			}
			mappaClassi.put(c, mappaCampi);
		}
		return mappaClassi.get(c);
	}
	
	protected Object estraiValore(Campo annotazioneCampo, String line, Field field) {
		Object value;
		int s = annotazioneCampo.start();
		int e = s + annotazioneCampo.length();
		String valore = getStringa(line, s, e);
		if (valore == null && annotazioneCampo.useDefaultValueOnError())
			valore = annotazioneCampo.defaultValue();
		else if (valore.isEmpty() && annotazioneCampo.useDefaultValueIfEmpty())
			valore = annotazioneCampo.defaultValue();
		
		Class<?> type = field.getType();
		if (type.equals(String.class)) {
			value = valore;
		} else if (type.equals(Boolean.class)) {
			value = getBooleano(valore);
		} else if (type.equals(Integer.class)) {
			value = getIntero(valore);
		} else if (type.equals(Double.class)) {
			value = getDecimale(valore, annotazioneCampo.decimals());
		} else if (type.equals(Date.class)) {
			value = getData(valore, annotazioneCampo.dateFormat());
		} else {
			value = null;
		}
		
//		switch (annotazioneCampo.type()) {
//			case BOOLEANO : value = getBooleano(valore); break;
//			case DATA : value = getData(valore, annotazioneCampo.dateFormat()); break;
//			case NUMERICO_DECIMALE : value = getDecimale(valore, annotazioneCampo.decimals()); break;
//			case NUMERICO_INTERO : value = getIntero(valore); break;
//			case STRINGA : value = valore; break;
//			default : value = null;
//		}
		
		return value;
	}
	
	public List<T> parsaOggetto(String filePath) throws IOException {
		File file = new File(filePath);
		return parsaOggetto(file);
	}
	
	public List<T> parsaOggetto(File file) throws IOException {
		ArrayList<String> righe = FileUtility.readLines(file);
		String[] lines = new String[righe.size()];
		lines = righe.toArray(lines);
		List<T> list = parsaOggetto(lines); 
		return list;
	}

	public List<T> parsaOggetto(String[] lines) {		
		List<T> list = new LinkedList<>();
		//Istanzio il parser di stringhe
		//StringParser parser = new StringParser(lines, lunghezzaMinima);
		//while (parser.prossimaLinea()) {
		for (String line : lines) {
			try {
				//Istanzio un nuovo oggetto.
				T object = c.newInstance();
				//Recupero i campi che sono stati annotati
				for (Field field : mappaCampi.keySet()) {
					Campo annotazioneCampo = mappaCampi.get(field);
					//Estraggo il valore dalla stringa in base alle indicazioni nella annotazione.
					Object value = estraiValore(annotazioneCampo, line, field);
					//valorizzo il campo.
					field.set(object, value);
				}
				list.add(object);
			} catch (InstantiationException | IllegalAccessException e) {
				logger.error(e.getMessage(), e);
			}
		}		
		return list;
	}
	
}
