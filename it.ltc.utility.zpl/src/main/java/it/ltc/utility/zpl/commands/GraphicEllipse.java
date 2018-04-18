package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.LineColor;

/**
 * Classe che mappa il comando ^GE, permette di disegnare un ellisse.
 * @author Antonio 24 ago 2017
 *
 */
public class GraphicEllipse {
	
	public final static LineColor DEFAULT_COLOR = LineColor.BLACK;
	
	public final static int MIN_THCKNESS = 2;
	public final static int MIN_VALUE = 3;
	public final static int MAX_VALUE = 4095;
	
	/**
	 * ellipseWidth identifica la larghezza
	 */
	private final int ellipseWidth;
	
	/**
	 * ellipseheight identifica l'altezza
	 */
	private final int ellipseHeight;
	
	/**
	 * borderThickness identifica lo spessore del bordo
	 */
	private final int borderThickness;
	
	/**
	 * lineColor identifica il colore della linea, assume uno dei valori definiti in LINECOLOR
	 */
	private final LineColor lineColor;
	
	/**
	 * Costruttore semplicizzato per ottenere cerchi.
	 * Lo spessore delle linee viene impostato di default a 2.
	 * Il colore delle linee viene impostato di default nero.
	 * @param radius il raggio del cerchio.
	 */
	public GraphicEllipse(int radius) {
		this.borderThickness = MIN_THCKNESS;
		this.ellipseWidth = checkValue(radius);
		this.ellipseHeight = checkValue(radius);
		this.lineColor = DEFAULT_COLOR;
	}
	
	/**
	 * Costruttore di default per ellissi.
	 * Lo spessore delle linee viene impostato di default a 2.
	 * Il colore delle linee viene impostato di default nero.
	 * @param ellipseWidth la larghezza dell'ellissi.
	 * @param ellipseHeight l'altezza dell'ellissi.
	 */
	public GraphicEllipse(int ellipseWidth, int ellipseHeight) {
		this.borderThickness = MIN_THCKNESS;
		this.ellipseWidth = checkValue(ellipseWidth);
		this.ellipseHeight = checkValue(ellipseHeight);
		this.lineColor = DEFAULT_COLOR;
	}	
	
	/**
	 * Costruttore che permette di specificare tutti i parametri.
	 * @param ellipseWidth la larghezza dell'ellissi.
	 * @param ellipseHeight l'altezza dell'ellissi.
	 * @param borderThickness lo spessore della linea.
	 * @param lineColor il colore della linea.
	 */
	public GraphicEllipse(int ellipseWidth, int ellipseHeight, int borderThickness, LineColor lineColor) {
		this.borderThickness = checkThickness(borderThickness);
		this.ellipseWidth = checkValue(ellipseWidth);
		this.ellipseHeight = checkValue(ellipseHeight);
		if (lineColor == null)
			lineColor = DEFAULT_COLOR;
		this.lineColor = lineColor;
	}

	private int checkThickness(int thickness) {
		if (thickness < MIN_THCKNESS)
			thickness = MIN_THCKNESS;
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


	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^GE");
		value.append(ellipseWidth);
		value.append(",");
		value.append(ellipseHeight);
		value.append(","); 
		value.append(borderThickness);
		value.append(",");
		value.append(lineColor);
		return value.toString();
	}
}
