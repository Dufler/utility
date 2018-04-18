package it.ltc.utility.zpl.parameters;

/**
 * JUSTIFY definisce le tipologie di colore utilizzabili.
 * @author Antonio 24 ago 2017
 *
 */
public enum LineColor {

	BLACK("B"),
	WHITE("W");
	
	private final String value;
	private LineColor(String value){
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
