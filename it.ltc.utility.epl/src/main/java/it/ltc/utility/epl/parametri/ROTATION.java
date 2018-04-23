package it.ltc.utility.epl.parametri;

/**
 * ROTATION definisce i valori utilizzabili nei comandi che prevedono la rotazione.
 * @author Antonio 08 set 2017
 *
 */
public enum ROTATION {

	NORMAL("0"),
	ROTATED90("1"),
	ROTATED180("2"),
	ROTATED270("3");
	
	private final String value;
	private ROTATION(String value){
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
