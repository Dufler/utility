package it.ltc.utility.zpl.parameters;


/**
 * JUSTIFY definisce le tipologie di allinenamento utilizzate nella formattazione del testo.
 * @author Antonio 22 ago 2017
 *
 */
public enum Justify {

	LEFT(0),
	RIGHT(1),
	AUTO(2);
	
	private final int value;
	private Justify(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
