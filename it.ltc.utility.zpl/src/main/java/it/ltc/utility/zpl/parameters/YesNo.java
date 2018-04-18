package it.ltc.utility.zpl.parameters;

/**
 * YESNO definisce i valori utilizzati dove necessario per definire 
 * attivazione o disattiviazione di proprietà nella formattazione del testo.
 * @author Antonio 22 ago 2017
 *
 */
public enum YesNo {
	
	YES("Y"),
	NO("N");
	
	private final String value;
	private YesNo(String value){
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
