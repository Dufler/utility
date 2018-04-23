package it.ltc.utility.epl.etichette;

import java.util.ArrayList;
import java.util.List;

import it.ltc.utility.epl.elementi.Elemento;

/**
 * Classe astratta che mappa un Etichetta.
 * Contiente i comandi di di testata e chiusua dell'etichetta.
 * @author Antonio 24 ago 2017
 *
 */
public abstract class Etichetta {
	public final List<Elemento> elementi;
	private final int h;
	private final int w;
	
	public static String CRLF = "\r\n";
	
	protected final static String header = "N" + CRLF + "D12" + CRLF;
	
	protected final static String footer = "P1" + CRLF ;
	
	public Etichetta(int h, int  w) {
		elementi = new ArrayList<>();
		this.h = h;
		this.w = w;
	}
	
	/**
	 * Aggiunge un elemento alla lista di elementi. 
	 * Se le dimensioni h o w dell'elemento eccedono quelle dell'etichetta viene generata una IllegalArgumentException.
	 * @param elem
	 * @throws IllegalArgumentException
	 */
	public void addElemento(Elemento elem) throws IllegalArgumentException {
		if (elem.getH() > h)
			throw new IllegalArgumentException("La larghezza dell'elemento specificato è superiore a quella dell'etichetta!");
		if (elem.getW() > w)
			throw new IllegalArgumentException("L'altezza dell'elemento specificato è superiore a quella dell'etichetta!");
		
		elementi.add(elem);
	}
	
	
	public int getH() {
		return h;
	}

	public int getW() {
		return w;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(header);
		
		for(Elemento elem : elementi) {
			sb.append(elem.toString() + CRLF);
		}
		
		sb.append(footer);
		
		return sb.toString();
	}
}
