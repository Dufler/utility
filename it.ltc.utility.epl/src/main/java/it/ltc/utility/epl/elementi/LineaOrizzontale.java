package it.ltc.utility.epl.elementi;

import it.ltc.utility.epl.comandi.LineDrawExclusiveOR;

public class LineaOrizzontale extends Elemento {

	LineDrawExclusiveOR linea = new LineDrawExclusiveOR();
	
	public LineaOrizzontale(int x, int y, int h, int w) {
		super(x, y, h, w);
		
		linea.horizontalLength = w;
		linea.horizontalPosition = x;
		linea.verticalPosition = y;
		linea.verticalLength = h;
	}

	@Override
	public String toString() {
		return linea.toString();
	}
	
	
	

}
