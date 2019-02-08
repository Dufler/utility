package it.ltc.utility.csv;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.apache.log4j.Logger;

import it.ltc.utility.csv.annotation.CampoCSV;

public class CSVObjectMapper {
	
	private static final Logger logger = Logger.getLogger(CSVObjectMapper.class);
	
	@SuppressWarnings("rawtypes")
	private static final HashMap<Class, HashMap<CampoCSV, Field>> mappaClassi = new HashMap<>();
	
	@SuppressWarnings("rawtypes")
	protected static HashMap<CampoCSV, Field> mappaClasse(Class c) {
		if (!mappaClassi.containsKey(c)) {
			logger.debug("Eseguo il mappaggio per la classe " + c.getSimpleName());
			HashMap<CampoCSV, Field> mappaCampi = new HashMap<>();
			for (Field field : c.getDeclaredFields()) { 
				CampoCSV annotazioneCampo = field.getAnnotation(CampoCSV.class);
				if (annotazioneCampo != null) {
					logger.debug("Trovata annotazione per il campo " + field.getName());
					mappaCampi.put(annotazioneCampo, field);
				}
			}
			mappaClassi.put(c, mappaCampi);
		}
		return mappaClassi.get(c);
	}

}
