package it.ltc.utility.zpl.elements;

import it.ltc.utility.zpl.parameters.Font;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe che mappa la tipologia di titolo Bitmapped. Utilizza il font A,
 * dimensione base 9x5. La larghezza del font è fissa. Utilizzato per campi dove
 * la lunghezza del testo può variare.
 * 
 * @author Antonio 24 ago 2017
 *
 */
public class TitoloBitmapped extends Testo {

	/**
	 * Costruttore di default.
	 * @param x la posizione lungo l'asse X.
	 * @param y la posizione lungo l'asse Y.
	 * @param h l'altezza del titolo.
	 * @param w la lunghezza del titolo.
	 * @param testo il testo da mostrare
	 * @param mm il moltiplicatore minimo da utilizzare.
	 */
	public TitoloBitmapped(int x, int y, int h, int w, String testo, int mm, Orientation orientation) {
		super(x, y, h, w, testo, Font.A, 1, orientation);
	}

}
