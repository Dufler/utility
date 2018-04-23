package it.ltc.utility.epl.parametri;

/**
 * REDEABLE definisce i valori utilizzabili per settare il codice a barre come leggibile.
 * @author Antonio 08 set 2017
 *
 */
public enum READABLE {

	/**
	 * valore di default
	 */
	YES("B"),
	/**
	 * barcode non leggibile
	 */
	NO("N");
	
	private final String value;
	private READABLE(String value){
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
