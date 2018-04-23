package it.ltc.utility.epl.elementi;

import it.ltc.utility.epl.comandi.BarcodeFiled;
import it.ltc.utility.epl.parametri.BARCODETYPE;
import it.ltc.utility.epl.parametri.READABLE;
import it.ltc.utility.epl.parametri.ROTATION;

/**
 * Classe che mappa l'elemento Barcode
 * @author Antonio 08 set 2017
 *
 */
public class Barcode extends Elemento {

	BarcodeFiled barcodeField = new BarcodeFiled();
	
	public Barcode(int x, int y, int h, int w, String data, ROTATION rotation, BARCODETYPE type) {
		super(x, y, h, w);
		
		barcodeField.horizontalStartPosition = x;
		barcodeField.verticalStartPosition = y;
		barcodeField.height = h;
		barcodeField.narrowBarWidth = w;
		barcodeField.wideBarWidth = w+1;
		barcodeField.rotation = rotation;
		barcodeField.barcodeSelection = type;
		barcodeField.humanReadable = READABLE.YES;
		barcodeField.data = data;
	}
	
	public Barcode(int x, int y, int h, int w, String data, ROTATION rotation, BARCODETYPE type, READABLE readable) {
		super(x, y, h, w);
		
		barcodeField.horizontalStartPosition = x;
		barcodeField.verticalStartPosition = y;
		barcodeField.height = h;
		barcodeField.narrowBarWidth = w;
		barcodeField.wideBarWidth = w+1;
		barcodeField.rotation = rotation;
		barcodeField.barcodeSelection = type;
		barcodeField.humanReadable = readable;
		barcodeField.data = data;
	}

	@Override
	public String toString() {
		return barcodeField.toString();
	}

}
