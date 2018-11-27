package it.ltc.utility.miscellanea.string;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class StringValueParser {
	
	protected String getStringa(String line, int s, int e) {
		String value = line != null && line.length() >= e ? line.substring(s, e).trim() : null;
		return value;
	}
	
	protected Boolean getBooleano(String line, int s, int e) {
		return getBooleano(getStringa(line, s, e));
	}
	
	protected Boolean getBooleano(String s) {
		Boolean b;
		try {
			b = Boolean.parseBoolean(s.trim());
		} catch (Exception exception) {
			b = null;
		}
		return b;
	}
	
	protected Integer getIntero(String line, int s, int e) {
		return getIntero(getStringa(line, s, e));
	}
	
	/**
	 * Parsa l'intero contenuta nella stringa tra i due indici passati come argomento.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @return l'intero parsato oppure <code>null</code> in caso di problemi.
	 */
	protected Integer getIntero(String s) {
		Integer i;
		try {
			i = Integer.parseInt(s.trim());
		} catch (Exception exception) {
			i = null;
		}
		return i;
	}
	
	protected Double getDecimale(String line, int s, int e, int dp) {
		return getDecimale(getStringa(line, s, e), dp);
	}
	
	/**
	 * Parsa il double contenuto nella stringa tra i due indici passati come argomento.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @param dp il numero di decimali
	 * @return il double parsato oppure <code>null</code> in caso di problemi.
	 */
	protected Double getDecimale(String s, int dp) {
		Double d;
		try {
			d = Double.parseDouble(s.trim());
			d = d / Math.pow(10, dp);
		} catch (Exception exception) {
			d = null;
		}
		return d;
	}
	
	protected Date getData(String line, int s, int e, String dateFormat) {
		return getData(getStringa(line, s, e), dateFormat);
	}
	
	/**
	 * Parsa una data contenuta nella stringa tra i due indici passati come argomento.<br>
	 * La data è semplice e non ha data e ora.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @return La data parsata o <code>null</code> in caso di problemi.
	 */
	protected Date getData(String s, String dateFormat) {
		Date data;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			data = sdf.parse(s.trim());
		} catch (Exception exception) {
			data = null;
		}
		return data;
	}

}
