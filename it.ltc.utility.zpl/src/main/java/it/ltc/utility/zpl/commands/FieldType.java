package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.Justify;

/**
 * Classe che mappa il comando ^FT, configura la posizione del campo in base alla posizione inziale dell'etichetta.
 * @author Antonio 24 ago 2017
 *
 */
public class FieldType {
	
	public final static int MIN_VALUE = 0;
	public final static int MAX_VALUE = 32000;
	public final static Justify DEFAULT_JUSTIFY = Justify.LEFT;
	
	/**
	 * xPosition identifica il valore rispetto all'asse x 
	 */
	private final int xPosition;
	/**
	 * yPosition identifica il valore rispetto all'asse y 
	 */
	private final int yPosition;
	/**
	 * zJustify identifica la tipologia di allineamento definita in JUSTIFY 
	 */
	private final Justify zJustify;
	
	/**
	 * Costruttore di default.
	 * Il parametro Justify viene impostato di default a LEFT.
	 * @param x posizionamento lungo l'asse X (in dots)
	 * @param y posizionamento lungo l'asse Y (in dots)
	 */
	public FieldType(int x, int y) {
		this.xPosition = checkValue(x);
		this.yPosition = checkValue(y);
		this.zJustify = DEFAULT_JUSTIFY;
	}
	
	/**
	 * Costruttore che permette di specificare tutti i parametri.
	 * Nel caso in cui si passi null come Justify allora viene impostato automaticamente di default a LEFT.
	 * @param x posizionamento lungo l'asse X (in dots)
	 * @param y posizionamento lungo l'asse Y (in dots)
	 * @param justify giustificazione dell'elemento.
	 */
	public FieldType(int x, int y, Justify justify) {
		this.xPosition = checkValue(x);
		this.yPosition = checkValue(y);
		if (justify == null)
			justify = DEFAULT_JUSTIFY;
		this.zJustify = justify;
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
		StringBuilder value = new StringBuilder("^FT");
		value.append(xPosition);
		value.append(",");
		value.append(yPosition);
		value.append(",");
		value.append(zJustify);
		return value.toString();
	}
	
}
