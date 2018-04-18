package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.Orientation;
import it.ltc.utility.zpl.parameters.YesNo;

/**
 * Classe che mappa il comando ^BC che identifica Code128 codifica del codice a barre.
 * @author Antonio 24 ago 2017
 *
 */
public class Code128 {

	/**
	 * barOrientation identifica l'orientamento, assume uno dei valori definiti in ORIENTATION
	 */
	private final Orientation barOrientation;
	/**
	 * barHeight identifica l'altezza
	 */
	private final int barHeight;
	/**
	 * printLineBefore indica se il valore deve essere stampato sotto il codice a barre, assume un valore YESNO
	 */
	private final YesNo printLineBefore;
	/**
	 * printLineAbove indica se il valore deve essere stampato sopra il codice a barre, assume un valore YESNO
	 */
	private final YesNo printLineAbove;
	/**
	 * checkDigit opzionale, indica se deve essere effetTuato il controllo UCC, assume un valore YESNO
	 */
	//private final YesNo checkDigit;
	/**
	 * selectedMode opzionale, setta la tipologia di modalita
	 */
	//private final String selectedMode;
	
	/**
	 * Costruttore di default, alcuni parametri vengono impostati automaticamente:
	 *  
	 * @param barOrientation
	 * @param barHeight
	 * @param printLineBefore
	 * @param printLineAbove
	 */
	public Code128(Orientation barOrientation, int barHeight, YesNo printLineBefore, YesNo printLineAbove) {
		this.barOrientation = barOrientation;
		this.barHeight = barHeight;
		this.printLineBefore = printLineBefore;
		this.printLineAbove = printLineAbove;
		//this.checkDigit = YesNo.NO;
		//this.selectedMode = null;
	}
	
	/**
	 * Costruttore completo, è possibile specificare nel dettaglio tutti i parametri.
	 * @param barOrientation
	 * @param barHeight
	 * @param printLineBefore
	 * @param printLineAbove
	 * @param checkDigit
	 * @param selectedMode
	 */
	public Code128(Orientation barOrientation, int barHeight, YesNo printLineBefore, YesNo printLineAbove, YesNo checkDigit, String selectedMode) {
		this.barOrientation = barOrientation;
		this.barHeight = barHeight;
		this.printLineBefore = printLineBefore;
		this.printLineAbove = printLineAbove;
		//this.checkDigit = checkDigit;
		//this.selectedMode = selectedMode;
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^BC");
		value.append(barOrientation);
		value.append(",");
		value.append(barHeight);
		value.append(",");
		value.append(printLineBefore);
		value.append(",");
		value.append(printLineAbove);
//		value.append(",");
//		value.append(checkDigit);
//		value.append(",");
//		value.append(selectedMode);
		return value.toString();
	}
}
