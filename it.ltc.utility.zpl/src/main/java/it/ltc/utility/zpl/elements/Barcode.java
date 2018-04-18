package it.ltc.utility.zpl.elements;

import it.ltc.utility.zpl.commands.BarcodeField;
import it.ltc.utility.zpl.commands.Code128;
import it.ltc.utility.zpl.commands.FieldData;
import it.ltc.utility.zpl.commands.FieldType;
import it.ltc.utility.zpl.parameters.Justify;
import it.ltc.utility.zpl.parameters.Orientation;
import it.ltc.utility.zpl.parameters.YesNo;

/**
 * Classe che mappa un elemento di tipo Barcode. Include tutti i comandi
 * necessari per la stampa.
 * 
 * @author Antonio 24 ago 2017
 *
 */
public class Barcode extends Elemento {
	
	public final static Orientation DEFAULT_ORIENTATION = Orientation.ROTATED270;

	private final BarcodeField BY;
	private final FieldType FT;
	private final Code128 BC;
	private final FieldData FD;

	public Barcode(int x, int y, int h, int w, String value) {
		super(x, y, h, w);
		
		BY = new BarcodeField(h, w);
		FT = new FieldType(x, y);
		BC = new Code128(DEFAULT_ORIENTATION, h, YesNo.YES, YesNo.NO);
		FD = new FieldData(value, true, false);
	}
	
	public Barcode(int x, int y, int h, int w, String value, double barwide, Justify justify, Orientation orientation, YesNo printLineBefore, YesNo printLineAbove, boolean allNumeric) {
		super(x, y, h, w);
		
		BY = new BarcodeField(h, w, barwide);
		FT = new FieldType(x, y, justify);
		BC = new Code128(orientation, h, printLineBefore, printLineAbove);
		FD = new FieldData(value, true, allNumeric);
	}

	@Override
	public String toString() {
		String value = BY.toString() + FT.toString() + BC.toString() + CRLF + FD.toString();
		return value;

	}

}
