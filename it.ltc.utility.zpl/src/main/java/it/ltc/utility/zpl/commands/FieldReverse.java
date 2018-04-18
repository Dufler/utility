package it.ltc.utility.zpl.commands;

/**
 * Classe che mappa il comando ^FR, utilizzato per effettuare la stampa nella modalità reverse.
 * <edit>
 * Nella modalità reverse viene invertito il colore della stampa (bianco -> nero, nero -> bianco).
 * Viene inserito prima del comando da invertire.
 * Es. <code>^FR^FDtext^FS</code>
 * - Damiano
 * </edit>
 * @author Antonio 24 ago 2017
 *
 */
public class FieldReverse {
	
	@Override
	public String toString() {
		return "^FR";
	}
	
}
