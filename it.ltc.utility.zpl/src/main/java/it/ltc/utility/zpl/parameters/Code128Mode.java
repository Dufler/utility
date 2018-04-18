package it.ltc.utility.zpl.parameters;

/**
 * CODE128_MODE definisce le modalità che possono 
 * essere assegnate alla codifica 128 per i barcode. 
 * @author Antonio 23 ago 2017
 *
 */
public enum Code128Mode {

    NOMODE("N"),
	UCC("U"),
	AUTO("A"),
	UCC_EAN("D");
	
	private final String value;
	private Code128Mode(String value){
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
