package it.ltc.utility.zpl.commands;

/**
 * Classe che mappa il comando ^FH utilizzato per interpretare valori esadecimali.
 * <edit>
 * Va sempre usato prima del comando ^FD <code>FieldData</code>.
 * - Damiano
 * </edit>
 * @author Antonio 24 ago 2017
 *
 */
public class FieldHexadecimal {

	@Override
	public String toString() {
		return "^FH\\";
	}
	
}
