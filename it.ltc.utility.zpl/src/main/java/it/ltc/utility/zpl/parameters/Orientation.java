package it.ltc.utility.zpl.parameters;

/**
 * ORIENTATION definisce le tipologie di orientamento utilizzate nella formattazione del testo.
 * @author Antonio 22 ago 2017
 *
 */
public enum Orientation {

	NORMAL("N"),
	ROTATED90("R"),
	ROTATED180("I"),
	ROTATED270("B");
	
	private final String value;
	private Orientation(String value){
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
