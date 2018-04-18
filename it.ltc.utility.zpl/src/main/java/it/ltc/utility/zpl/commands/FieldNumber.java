package it.ltc.utility.zpl.commands;

/**
 * Classe che mappa il comando ^FN, permette di numerare un campo.
 * <edit>
 * Il parametro opzionale <code>a</code> può essere usato nella KDU unit per essere richiamato facilmente.
 * - Damiano
 * </edit>
 * @author Antonio 24 ago 2017
 *
 */
public class FieldNumber {
	
	public final static int MIN_VALUE = 0;
	public final static int MAX_VALUE = 9999;
	
	/**
	 * number identifica il numero che viene attribuito al campo.
	 * <edit>il range di valori consentito è 0 - 9999, il default è 0.</edit>
	 */
	private final int number;
	
	private final String a;
	
	/**
	 * Costruttore di default.
	 * Il parametro <code>a</code> viene settato a null e non verrà usato.
	 * @param number la numerazione da attribuire al campo.
	 */
	public FieldNumber(int number) {
		this.number = checkValue(number);
		this.a = null;
	}
	
	/**
	 * Costruttore che permette di specificare il parametro opzionale a.
	 * @param number la numerazione da attribuire al campo.
	 * @param a il nome da attribuire al campo.
	 */
	public FieldNumber(int number, String a) {
		this.number = checkValue(number);
		this.a = a;
	}
	
	private int checkValue(int number) {
		if (number < MIN_VALUE)
			number = MIN_VALUE;
		else if (number > MAX_VALUE)
			number = MAX_VALUE;
		return number;
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^FN");
		value.append(number);
		if (a != null)
			value.append("\"a\"");
		return value.toString();
	}
}
