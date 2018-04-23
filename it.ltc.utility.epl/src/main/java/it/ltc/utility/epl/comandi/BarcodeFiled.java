package it.ltc.utility.epl.comandi;

import it.ltc.utility.epl.parametri.BARCODETYPE;
import it.ltc.utility.epl.parametri.READABLE;
import it.ltc.utility.epl.parametri.ROTATION;

/**
 * Classe che mappa il comando B, utilizzato per stampare un codice a barre
 * @author Antonio 08 set 2017
 *
 */
public class BarcodeFiled {
	/**
	 * posizione x intero
	 */
	public Integer horizontalStartPosition;
	/**
	 * posizione y intero
	 */
	public Integer verticalStartPosition;
	/**
	 * rotazione assume un valore definito in ROTATION
	 */
	public ROTATION rotation;
	/**
	 * tipologia di barcode assumen un valore definito in BARCODETYPE
	 */
	public BARCODETYPE barcodeSelection;
	/**
	 * distanza rispetto alla barre vicine intero
	 */
	public Integer narrowBarWidth;
	/**
	 * larghezza della barra intero
	 */
	public Integer wideBarWidth;
	/**
	 * altezza della barra
	 */
	public Integer height;
	/**
	 * definisce se stampare il contenuto de barcode assume un valore definito in REDEABLE 
	 */
	public READABLE humanReadable;
	/**
	 * contenuto del barcode
	 */
	public String data;

	@Override
	public String toString() {
		String value = "";
		value += "B" + horizontalStartPosition + "," + verticalStartPosition + "," +
		         rotation + "," + barcodeSelection + "," + narrowBarWidth + "," + wideBarWidth + "," +
		         height + "," + humanReadable + "," + "\"" + data + "\""; 
		return value;
	}
}
