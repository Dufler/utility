package it.ltc.utility.zpl.parameters;

/**
 * EXTENSION definisce le estensioni dei file che posso essere caricati. 
 * @author Antonio 23 ago 2017
 *
 */
public enum Extension {
    
    FONT(".FNT"),
	TRUETYPEFONT(".TTF"),
	TRUETYPEEXTENSION(".TTE");
	
	private final String value;
	private Extension(String value){
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
