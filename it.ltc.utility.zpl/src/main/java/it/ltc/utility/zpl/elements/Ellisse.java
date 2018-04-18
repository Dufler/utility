package it.ltc.utility.zpl.elements;

import it.ltc.utility.zpl.commands.FieldOrigin;
import it.ltc.utility.zpl.commands.FieldSeparetor;
import it.ltc.utility.zpl.commands.GraphicEllipse;
import it.ltc.utility.zpl.parameters.LineColor;

public class Ellisse extends Elemento {

	FieldOrigin origin;
	GraphicEllipse ellisse;
	FieldSeparetor separator;
	
	public Ellisse(int x, int y, int h, int w, int tickness){
		super(x, y, h, w);
		origin = new FieldOrigin(x, y, null);
		ellisse = new GraphicEllipse(w, h, tickness, LineColor.BLACK);
		separator = new FieldSeparetor();
	}
	
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		value.append(origin);
		value.append(ellisse);
		value.append(separator);
		value.append(CRLF);
		return value.toString();
	}
	
}
