package it.ltc.utility.epl.elementi;

/**
 * Classe astratta identifica un Elemento cioè un insieme di comandi per realizzare una particolare stampa.
 * @author Antonio 24 ago 2017
 *
 */
public abstract class Elemento {
	public final static String CRLF = "\r\n";
	
	/**
	 * x,y,h,w identificano rispettivamente 
	 * x: valore sull'asse x
	 * y: valore sull'asse y
	 * h: l'atezza
	 * w: la larghezza
	 */
	protected final int x,y,h,w;
	
	public Elemento(int x, int y, int h, int w) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getH() {
		return h;
	}
	public int getW() {
		return w;
	}

}
