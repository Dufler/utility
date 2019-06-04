package it.ltc.utility.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Classe che parsa il file di configurazione in fase di creazione dell'istanza e la rende disponibile per recuperare le info necessarie.
 * @author Damiano
 *
 */
public abstract class ConfigurationParser {
	
	private static final Logger logger = Logger.getLogger(ConfigurationParser.class);
	
	protected final String configPath;
	protected final Configuration configuration;
	
	public ConfigurationParser(String configPath) {
		this.configPath = configPath;
		this.configuration = loadConfiguration(configPath);
	}
	
	private final Configuration loadConfiguration(String configPath) {
		Configuration configuration;
		try {
			InputStream stream = ConfigurationParser.class.getResourceAsStream(configPath);
			logger.debug("Stream configurazione letto: " + stream);
			configuration = new Configuration(stream, false);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "Impossibile caricare i files di configurazione.";
			throw new RuntimeException(errorMessage);
		}
		return configuration;
	}
	
	/**
	 * Restituisce la lista di indirizzi mail corrispondenti alla chiave specificata.
	 * 
	 * @return una lista di indirizzi mail a cui verranno spedite le notifiche.
	 */
	protected Set<String> getStringList(String key, String splitter) {
		Set<String> destinatari = new HashSet<String>();
		String indirizzi = configuration.get(key);
		for (String indirizzo : indirizzi.split(splitter))
			destinatari.add(indirizzo);
		return destinatari;
	}

}
