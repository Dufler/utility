package it.ltc.utility.zpl.etichette.prodotto;

import it.ltc.utility.zpl.elements.Barcode;
import it.ltc.utility.zpl.elements.Elemento;
import it.ltc.utility.zpl.parameters.Justify;
import it.ltc.utility.zpl.parameters.Orientation;
import it.ltc.utility.zpl.parameters.YesNo;

public class EtichettaProdotto_320x500 extends EtichettaProdotto {

	private static final int width = 406; //812;
	private static final int height = 300; //609;

	private final static Orientation orientation = Orientation.NORMAL;
	
	public EtichettaProdotto_320x500(InfoProdotto info) {
		super(height, width, orientation, info);
		
		//Barcode prodotto
		Elemento barcodeElement = new Barcode(25, 1, 60, 2, info.getBarcode(), 3.0, Justify.AUTO, orientation, YesNo.NO, YesNo.NO, false);
		//Elemento barcodeElement = new Barcode(25, 1, 60, 3, info.getBarcode(), 2.0, Justify.AUTO, orientation, YesNo.NO, YesNo.NO, false);
		addElemento(barcodeElement);
		
		//SKU
		addScalableTextElement(25, 95, 30, 45, "ART.");
		addBitmapTextElement(87, 95, 30, 300, info.getSku(), 1);
		
		//Colore
		addScalableTextElement(25, 135, 30, 60, "Colour:");
		addBitmapTextElement(115, 135, 30, 300, info.getColore(), 1);
		
		//Taglia
		addScalableTextElement(25, 175, 30, 50, "Size:");
		addBitmapTextElement(85, 175, 30, 300, info.getTaglia(), 1);
		
	}
	
	

}
