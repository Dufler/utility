package it.ltc.utility.epl.elementi;

import it.ltc.utility.epl.parametri.REVERSE;
import it.ltc.utility.epl.parametri.ROTATION;

/**
 * Classe che mappa l'elemnto titolo
 * @author Antonio 08 set 2017
 *
 */
public class Titotlo extends Elemento {

	/**
	 * testo identifica il testo da stampare
	 */
	protected String testo;
	/**
	 * orientation identifica il tipo di orientamento, assume uno dei valori definiti in ORIENTATION
	 */
	protected ROTATION orientation;
	/**
	 * size identifica la dimensione de font
	 */
	protected Integer size;
	/**
	 * reverse identifica se lastampa deve essere effettuata in reverse mode
	 */
	protected REVERSE reverse;
	
	
	public Titotlo(int x, int y, int h, int w, int size, String testo) {
		super(x, y, h, w);
		
		this.size = size;
		this.testo = testo;
		this.reverse = REVERSE.NORMAL;
	}

}
