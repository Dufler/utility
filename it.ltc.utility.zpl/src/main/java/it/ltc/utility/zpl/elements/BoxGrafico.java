package it.ltc.utility.zpl.elements;

import it.ltc.utility.zpl.commands.FieldOrigin;
import it.ltc.utility.zpl.commands.FieldSeparetor;
import it.ltc.utility.zpl.commands.GraphicBox;
import it.ltc.utility.zpl.parameters.LineColor;

/**
 * Classe che crea un riquadro dalle coordinate, dimensioni e spessore specificati.
 * @author Damiano
 *
 */
public class BoxGrafico extends Elemento {

	private final FieldOrigin origin;
	private final GraphicBox box;
	private final FieldSeparetor separator;
	
	/**
	 * Costruttore di default.
	 * @param x il posizionamento lungo l'asse X del vertice in alto a sinistra.
	 * @param y il posizionamento lungo l'asse Y del vertice in alto a sinistra.
	 * @param h l'altezza del riquadro.
	 * @param w la larghezza del riquadro.
	 * @param thickness lo spessore delle linee.
	 */
	public BoxGrafico(int x, int y, int h, int w, int thickness) {
		super(x, y, h, w);
		
		origin = new FieldOrigin(x, y, null);
		box = new GraphicBox(w, h, thickness, 0, LineColor.BLACK);
		separator = new FieldSeparetor();
	}
	
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		value.append(origin);
		value.append(box);
		value.append(separator);
		return value.toString();
	}
	
}
