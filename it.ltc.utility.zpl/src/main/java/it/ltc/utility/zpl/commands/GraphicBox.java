package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.LineColor;

/**
 * Classe che mappa il comando ^GB, permette di disegnare box e linee.
 * @author Antonio 24 ago 2017
 *
 */
public class GraphicBox {
	
	public final static int MIN_VALUE = 1;
	public final static int MAX_VALUE = 32000;
	
	public final static int MIN_ROUNDING = 0;
	public final static int MAX_ROUNDING = 8;
	
	public final static int DEFAULT_THICKNESS = 1;
	
	public final static LineColor DEFAULT_COLOR = LineColor.BLACK;
	

	/**
	 * boxWidth identifica la larghezza
	 */
	private final int boxWidth;
	
	/**
	 * boxHeight identifica l'altezza
	 */
	private final int boxHeight;
	
	/**
	 * borderThickness identifica lo spessore del bordo
	 */
	private final int borderThickness;
	
	/**
	 * lineColor identifica il colore, assume un dei valori definiti in <code>LineColor</code>.
	 */
	private final LineColor lineColor;
	
	/**
	 * degree identifica il grado di arrotondamento degli angoli 0 to 8
	 */
	private final int roundingDegree;
	
	/**
	 * Costruttore di default.
	 * Thickness viene impostata di default a 1.
	 * Rounding Degree viene impostato di default a 0. (Angoli di 90° non stondati)
	 * Il colore viene impostato di default a nero.
	 * - Damiano
	 * @param boxWidth la larghezza del box.
	 * @param boxHeight l'altezza del box.
	 */
	public GraphicBox(int boxWidth, int boxHeight) {
		this.borderThickness = DEFAULT_THICKNESS;
		this.lineColor = DEFAULT_COLOR;
		this.roundingDegree = MIN_ROUNDING;
		this.boxWidth = checkValue(boxWidth);
		this.boxHeight = checkValue(boxHeight);
	}
	
	/**
	 * Costruttore che permette di specificare tutti i parametri.
	 * @param boxWidth la larghezza del box.
	 * @param boxHeight l'altezza del box.
	 * @param borderThickness lo spessore dei bordi del box.
	 * @param roundingDegree la curvatura degli angoli del box.
	 * @param lineColor il colore delle linee del box.
	 */
	public GraphicBox(int boxWidth, int boxHeight, int borderThickness, int roundingDegree, LineColor lineColor) {
		this.borderThickness = checkThickness(borderThickness);
		if (lineColor == null)
			lineColor = DEFAULT_COLOR;
		this.lineColor = lineColor;
		this.roundingDegree = checkRoundingDegree(roundingDegree);
		this.boxWidth = checkValue(boxWidth);
		this.boxHeight = checkValue(boxHeight);
	}

	private int checkThickness(int thickness) {
		if (thickness < MIN_VALUE)
			thickness = MIN_VALUE;
		else if (thickness > MAX_VALUE)
			thickness = MAX_VALUE;
		return thickness;
	}
	
	private int checkValue(int value) {
		if (value < borderThickness)
			value = borderThickness;
		else if (value > MAX_VALUE)
			value = MAX_VALUE;
		return value;
	}
	
	private int checkRoundingDegree(int degree) {
		if (degree < MIN_ROUNDING)
			degree = MIN_ROUNDING;
		else if (degree > MAX_ROUNDING)
			degree = MAX_ROUNDING;
		return degree;
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^GB");
		value.append(boxWidth);
		value.append(",");
		value.append(boxHeight);
		value.append(","); 
		value.append(borderThickness);
		value.append(",");
		value.append(lineColor);	  
		value.append(",");
		value.append(roundingDegree);
		return value.toString();
	}
}
