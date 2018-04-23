package it.ltc.utility.epl.parametri;

/**
 * REVERSE definisce i valori utilizzabili per settare una scritta in modalità reverse.
 * @author Antonio 08 set 2017
 *
 */
public enum REVERSE {
	/**
	 * valore di default
	 */
	NORMAL("N"),
	/**
	 * modalita reverse
	 */
	REVERSEIMAGE("R");
	
	private final String value;
	private REVERSE(String value){
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
