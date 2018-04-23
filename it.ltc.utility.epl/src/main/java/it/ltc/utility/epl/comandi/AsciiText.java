package it.ltc.utility.epl.comandi;

import it.ltc.utility.epl.parametri.FONTTYPE;
import it.ltc.utility.epl.parametri.REVERSE;
import it.ltc.utility.epl.parametri.ROTATION;

/**
 * Calsse che mapp il comando A, utilizzato per la scrittura di un testo
 * @author Antonio 08 set 2017
 *
 */
public class AsciiText {

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
	 * tipo di font da utilizzare assume un valore definito in FONTYPE
	 */
	public FONTTYPE fontSelection;
	/**
	 * moltiplicatore orizzontale
	 */
	public Integer horizontalMultiplier;
	/**
	 * moltiplicatore verticale
	 */
	public Integer verticalMultiplier;
	/**
	 * reverse assume un valore definito in REVERSE
	 */
	public REVERSE reverseImage;
	/**
	 * contiente il testo da scrivere
	 */
	public String data;
	
	@Override
	public String toString() {
		String value = "";
		value += "A" + horizontalStartPosition + "," + verticalStartPosition + "," +
		        rotation + "," + fontSelection + "," + horizontalMultiplier + "," +
				verticalMultiplier + "," + reverseImage + "," + "\"" + data + "\"";
				
		return value;
	}
	
	
}
