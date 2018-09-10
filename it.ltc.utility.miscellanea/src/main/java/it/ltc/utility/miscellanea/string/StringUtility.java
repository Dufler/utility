package it.ltc.utility.miscellanea.string;

/**
 * 
 *
 * @author Damiano Bellucci - damiano.bellucci@gmail.com
 * @version 1.1
 *
 */
public class StringUtility {
	
	public static final String DEFAULT_NUMERIC_PADDING = "0";
	public static final String DEFAULT_STRING_PADDING = " ";
	
	//Dove inserire il padding: true = davanti, false = dietro.
	public static final boolean DEFAULT_NUMERIC_ORDER = true;
	public static final boolean DEFAULT_STRING_ORDER = false;
	
	private final String numericPadding;
	private final String stringPadding;
	private final boolean numericPaddingOrder;
	private final boolean stringPaddingOrder;
	
	/**
	 * Costruttore vanilla con i valori di default.
	 * - padding numerico con 0 a sinistra
	 * - padding stringhe con " " a destra
	 */
	public StringUtility() {
		numericPadding = DEFAULT_NUMERIC_PADDING;
		stringPadding = DEFAULT_STRING_PADDING;
		numericPaddingOrder = DEFAULT_NUMERIC_ORDER;
		stringPaddingOrder = DEFAULT_STRING_ORDER;
	}
	
	/**
	 * Costruttore a cui specificare i parametri di formattazione delle stringhe.
	 * @param nPadding Stringa di esattamente un carattere per il padding di numeri.
	 * @param sPadding Stringa di esattamente un carattere per il padding delle stringhe.
	 * @param nOrder ordinamento del padding per i numeri. True = padding avanti, false = padding dietro.
	 * @param sOrder ordinamento del padding per le stringhe. True = padding avanti, false = padding dietro.
	 * @throws IllegalArgumentException se il padding specificato è più lungo di un carattere.
	 */
	public StringUtility(String nPadding, String sPadding, boolean nOrder, boolean sOrder) throws IllegalArgumentException {
		if (nPadding == null || sPadding == null) {
			throw new IllegalArgumentException("Il padding non può essere null.");
		} else if (nPadding.length() != 1 || sPadding.length() != 1) {
			throw new IllegalArgumentException("Il padding deve avere esattamente un carattere.");
		}
		numericPadding = nPadding;
		stringPadding = sPadding;
		numericPaddingOrder = nOrder;
		stringPaddingOrder = sOrder;
	}
	
	/**
	 * Metodo wrapper che utilizza lo spazio come carattere di padding
	 * @param n
	 * @param length
	 * @return una stringa che codifica l'intero specificato aggiungendo spazi alla sua sinistra
	 */
	public String getFormattedString(int n, int length) {
		return getFormattedString(n, length, numericPadding);
	}
	
	/**
	 * Restituisce una stringa a partire dall'intero specificato della lunghezza voluta aggiungendo padding, se necessario.
	 * @param n l'intero da convertire a stringa
	 * @param length la lunghezza finale della stringa desiderata
	 * @param padding il carattere di padding da usare
	 * @return una stringa che codifica l'intero specificato
	 * @throws IllegalArgumentException se il padding specificato è più lungo di un carattere.
	 */
	public String getFormattedString(int n, int length, String padding) throws IllegalArgumentException {
		if (padding.length() != 1)
			throw new IllegalArgumentException("Il padding specificato deve avere esattamente un carattere.");
		StringBuilder result = new StringBuilder();
		result.append(n);
		for (int index = result.length(); index < length; index++) {
			if (numericPaddingOrder)
				result.insert(0, padding);
			else
				result.append(padding);
		}
		return result.toString();
	}
	
	/**
	 * Metodo wrapper che restituisce una stringa della lunghezza voluta aggiungendo spazi alla sua destra.
	 * @param s la stringa di input
	 * @param length la lunghezza desiderata
	 * @return una stringa della lunghezza voluta
	 */
	public String getFormattedString(String s, int length) {
		return getFormattedString(s, length, stringPadding, stringPaddingOrder);
	}
	
	/**
	 * Metodo che restituisce una stringa della lunghezza voluta aggiungendo padding alla sua destra
	 * @param s la stringa di input
	 * @param length la lunghezza desiderata
	 * @param padding il carattere di padding da utilizzare
	 * @return una stringa della lunghezza voluta con eventuali caratteri di padding.
	 * @throws IllegalArgumentException il padding deve essere di un carattere
	 */
	public String getFormattedString(String s, int length, String padding, boolean stringPaddingOrder) throws IllegalArgumentException {
		if (padding.length() != 1)
			throw new IllegalArgumentException("Il padding specificato deve avere esattamente un carattere.");
		if (s == null)
			s = "";
		StringBuilder sb = new StringBuilder(s);
		for (int index = s.length(); index < length; index++) {
			if (stringPaddingOrder)
				sb.insert(0, padding);
			else
				sb.append(padding);
		}			
		if (s.length() > length)
			sb.substring(0, length);
		return sb.toString();
	}
//	public String getFormattedString(String s, int length, String padding, boolean stringPaddingOrder) throws IllegalArgumentException {
//		if (padding.length() != 1)
//			throw new IllegalArgumentException("Il padding specificato deve avere esattamente un carattere.");
//		if (s == null)
//			s = "";
//		for (int index = s.length(); index < length; index++) {
//			if (stringPaddingOrder)
//				s = padding + s;
//			else
//				s += padding;
//		}			
//		if (s.length() > length)
//			s = s.substring(0, length);
//		return s;
//	}
	
	/**
	 * Metodo wrapper che utilizza lo spazio come carattere di padding
	 * @param d
	 * @param length
	 * @param decimal
	 * @return una stringa che codifica il numero specificato aggiungendo spazi alla sua sinistra
	 */
	public String getFormattedString(double d, int length, int decimal) {
		return getFormattedString(d, length, decimal, numericPadding);
	}
	
	/**
	 * Restituisce una stringa a partire dall'numero specificato della lunghezza voluta aggiungendo padding, se necessario.
	 * @param d il numero da convertire a stringa
	 * @param length la lunghezza finale della stringa desiderata
	 * @param decimal la lunghezza dei decimali, si applica il troncamento se necessario
	 * @param padding il carattere di padding da usare
	 * @return una stringa che codifica il numero specificato
	 * @throws IllegalArgumentException il padding deve essere di un carattere
	 */
	public String getFormattedString(double d, int length, int decimal, String padding) throws IllegalArgumentException {
		if (padding.length() != 1)
			throw new IllegalArgumentException("Il padding specificato deve avere esattamente un carattere.");
		String result = Double.toString(d);
		int separatorIndex = result.indexOf(".");
		String subStringRight = result.substring(separatorIndex+1);
		String subStringLeft = result.substring(0, separatorIndex);
		
		
		int lenRight = subStringRight.length();
		if (lenRight < decimal){
			for(int p=0; p<decimal-lenRight; p++){
				subStringRight = subStringRight + padding;
			}
		}
		else{
			subStringRight = subStringRight.substring(0, decimal);
		}
			
		int lenLeft = subStringLeft.length();
		if (lenLeft <= length - decimal){
			for(int p=0; p<length - (lenLeft + decimal); p++){
				subStringLeft = padding + subStringLeft;
			}
		}
		else{
			throw new IllegalArgumentException("Lunghezza del numero in input superiore alla formattazione desiderata.");
		}
		
		result = subStringLeft + subStringRight;
			
		return result;
	}	

}
