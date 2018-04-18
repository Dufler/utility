package it.ltc.utility.zpl.elements;

import it.ltc.utility.zpl.parameters.Font;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe astratta identifica che estende Elemento identifica un Titolo generico.
 * @author Antonio 24 ago 2017
 *
 */
public class Titolo extends Testo {
	
	public Titolo(int x, int y, int h, int w, String testo) {
		super(x, y, h, w, testo, Font.A, 2, Orientation.NORMAL);
	}

}
