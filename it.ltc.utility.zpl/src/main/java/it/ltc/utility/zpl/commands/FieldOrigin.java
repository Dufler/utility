package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.Justify;

/**
 * Classe che mappa il comando ^FO.
 * Configura l'origine del campo in base alla posizione inziale dell'etichetta indipendentemente della rotazione.
 * @author Antonio 24 ago 2017
 *
 */
public class FieldOrigin {
	
	public final static int MIN_VALUE = 0;
	public final static int MAX_VALUE = 32000;

	/**
	 * xPosition identifica il valore rispetto all'asse x.
	 * <edit>Il range di valori possibili in dots è 0 - 32000.</edit>
	 */
	private final int xPosition;
	
	/**
	 * yPosition identifica il valore rispetto all'asse y.
	 * <edit>Il range di valori possibili in dots è 0 - 32000.</edit>
	 */
	private final int yPosition;
	
	/**
	 * zJustify identifica la tipologia di allineamento definita in JUSTIFY 
	 */
	private final Justify zJustify;
	
	public FieldOrigin(int xPosition, int yPosition, Justify zJustify) {
		this.xPosition = checkValue(xPosition);
		this.yPosition = checkValue(yPosition);
		this.zJustify = zJustify;
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
		StringBuilder value = new StringBuilder("^FO");
		value.append(xPosition);
		value.append(",");
		value.append(yPosition);
		if (zJustify != null) {
			value.append(",");
			value.append(zJustify);
		}
		return value.toString();
	}
}
