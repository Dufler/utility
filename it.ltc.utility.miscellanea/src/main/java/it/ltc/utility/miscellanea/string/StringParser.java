package it.ltc.utility.miscellanea.string;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Classe usata per ottenere valori da stringhe.
 * @author Damiano
 *
 */
public class StringParser extends StringValueParser {
	
	public static final String PATTERN_DATA_COMPLETA = "yyyyMMddhhmmss";
	public static final String PATTERN_DATA_SEMPLICE = "yyyyMMdd";
	public static final String TIMEZONE = "UTC";
	
	protected final SimpleDateFormat sdfDataCompleta;
	protected final SimpleDateFormat sdfDataSemplice;
	
	protected final int minimalLenght;
	protected final String[] lines;
	protected String line;
	protected int index;
	
	public StringParser(String[] righe, int lunghezzaMinima) {
		this(righe, lunghezzaMinima, PATTERN_DATA_SEMPLICE, PATTERN_DATA_COMPLETA);
	}
	
	public StringParser(String[] righe, int lunghezzaMinima, String patternDataSemplice, String patternDataCompleta) {
		minimalLenght = lunghezzaMinima;
		lines = righe;
		sdfDataSemplice = new SimpleDateFormat(patternDataSemplice);
		sdfDataSemplice.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
		sdfDataCompleta = new SimpleDateFormat(patternDataCompleta);
		sdfDataCompleta.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
		index = -1;
		prossimaLinea();
	}
	
	/**
	 * Avanza il lettore alla prossima linea.<br>
	 * Restituisce true se va tutto bene oppure false se non c'è una prossima riga.
	 */
	public boolean prossimaLinea() {
		index++;
		boolean next = index < lines.length;
		if (next)
			line = checkLunghezza(lines[index], minimalLenght);
		return next;
	}	
	
	/**
	 * Controlla che la lunghezza della linea sia almeno quella minima specificata.
	 * @param s la stringa che rappresenta la linea.
	 * @param l la lunghezza minima.
	 * @return la stessa stringa ricevuta come parametro a cui vengono eventualmente aggiunti spazi alla fine affinchè raggiunga la lunghezza minima.
	 */
	protected String checkLunghezza(String s, int l) {
		while (s.length() < l) {
			s = s + " ";
		}
		return s;
	}
	
	/**
	 * Parsa la stringa contenuta tra i due indici passati come argomento.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @return la stringa parsata oppure <code>null</code> in caso di problemi.
	 */
	public String getStringa(int s, int e) {
		return getStringa(line, s, e);
	}
	
	/**
	 * Parsa il booleano contenuto nella stringa tra i due indici passati come argomento.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @return il booleano parsato oppure <code>null</code> in caso di problemi.
	 */
	public Boolean getBooleano(int s, int e) {
		return getBooleano(line, s, e);
	}
	
	/**
	 * Parsa l'intero contenuta nella stringa tra i due indici passati come argomento.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @return l'intero parsato oppure <code>null</code> in caso di problemi.
	 */
	public Integer getIntero(int s, int e) {
		return getIntero(line, s, e);
	}
	
	/**
	 * Parsa il double contenuto nella stringa tra i due indici passati come argomento.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @param dp il numero di decimali
	 * @return il double parsato oppure <code>null</code> in caso di problemi.
	 */
	public Double getDecimale(int s, int e, int dp) {
		return getDecimale(line, s, e, dp);
	}
	
	/**
	 * Parsa una data contenuta nella stringa tra i due indici passati come argomento.<br>
	 * La data è semplice e non ha data e ora.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @return La data parsata o <code>null</code> in caso di problemi.
	 */
	public Date getData(int s, int e, String dateFormat) {
		return getData(dateFormat, s, e, dateFormat);
	}

	/**
	 * Parsa una data contenuta nella stringa tra i due indici passati come argomento.<br>
	 * La data è semplice e non ha data e ora.
	 * @param s l'indice di partenza.
	 * @param e l'indica di fine.
	 * @return La data parsata o <code>null</code> in caso di problemi.
	 */
	public Date getDataSoloGiorno(int s, int e) {
		Date data;
		try {
			data = sdfDataSemplice.parse(line.substring(s, e).trim());
		} catch (Exception exception) {
			data = null;
		}
		return data;
	}
	
	/**
	 * Parsa una data contenuta nella stringa tra i due indici passati come argomento.
	 * @param sd l'indice di partenza della data.
	 * @param ed l'indica di fine della data.
	 * @param sh l'indice di partenza dell'ora.
	 * @param eh l'indica di fine dell'ora.
	 * @return La data parsata o <code>null</code> in caso di problemi.
	 */
	public Date getDataEOra(int sd, int ed, int sh, int eh) {
		Date dataeora;
		try {
			String data = line.substring(sd, ed).trim();
			String ora = line.substring(sh, eh).trim();
			while (ora.length() < eh - sh)
				ora = ora + "0";
			dataeora = sdfDataCompleta.parse(data + ora);
		} catch (Exception exception) {
			dataeora = null;
		}
		return dataeora;
	}

}
