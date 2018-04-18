package it.ltc.utility.zpl.etichette;

import java.util.ArrayList;
import java.util.List;

import it.ltc.utility.zpl.elements.Elemento;
import it.ltc.utility.zpl.elements.TitoloBitmapped;
import it.ltc.utility.zpl.elements.TitoloScalable;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe astratta che mappa un Etichetta.
 * Contiente i comandi di di testata e chiusua dell'etichetta.
 * @author Antonio 24 ago 2017
 *
 */
public abstract class Etichetta {
	
	protected final List<Elemento> elementi;
	
	protected final int h;
	protected final int w;
	protected final Orientation orientation;
	
	public final static String CRLF = "\r\n";
	
	protected final static String header = "CT~~CD,~CC^~CT~" + CRLF +
			"^XA~TA000~JSN^LT0^MNM^MTT^PON^PMN^LH0,0^JMA^PR5,5~SD10^JUS^LRN^CI0^XZ" + CRLF +
			"^XA" + CRLF +
			"^MMT" + CRLF ;
	
	protected final static String footer = "^PQ1,0,1,Y^XZ" + CRLF ;
	
	public Etichetta(int h, int  w, Orientation orientation) {
		this.elementi = new ArrayList<>();
		this.h = h;
		this.w = w;
		this.orientation = orientation;
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
	
	public void addBitmapTextElement(int x, int y, int h, int w, String value, int mm) {
		TitoloBitmapped text = new TitoloBitmapped(x, y, h, w, value, 1, orientation);
		addElemento(text);
	}
	
	public void addScalableTextElement(int x, int y, int h, int w, String value) {
		TitoloScalable text = new TitoloScalable(x, y, h, w, value, orientation);
		addElemento(text);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(header);
		sb.append("^PW" + w + CRLF);
		sb.append("^LL" + h + CRLF);
		sb.append("^LS0" + CRLF); 
		
		for(Elemento elem : elementi) {
			sb.append(elem.toString() + CRLF);
		}
		
		sb.append(footer);
		
		return sb.toString();
	}
}
