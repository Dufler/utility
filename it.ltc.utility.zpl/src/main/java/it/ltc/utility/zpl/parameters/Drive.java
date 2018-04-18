package it.ltc.utility.zpl.parameters;

/**
 * DRIVE definisce le unità da cui è possibile 
 * caricare file contenenti font di caratteri.
 * @author Antonio 23 ago 2017
 *
 */
public enum Drive {
    
    R("R:"),
	E("E:"),
	B("B:"),
	A("A:");
	
	private final String value;
	private Drive(String value){
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
