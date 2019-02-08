package it.ltc.utility.configuration;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localizer {
	
//	private static final Logger logger = Logger.getLogger(Localizer.class);
	
//	private final String path;
//	private final Locale locale;
	private final ResourceBundle bundle;
	
	public Localizer(String path, Locale locale) {
		bundle = ResourceBundle.getBundle(path, locale);
//		try {
//			bundle = ResourceBundle.getBundle(path, locale);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
	}
	
	public String getText(String key) {
		return bundle.getString(key);
	}
	
	public String getText(String key, Object... parameters) {
		String message = bundle.getString(key);
		return String.format(message, parameters);
	}

}
