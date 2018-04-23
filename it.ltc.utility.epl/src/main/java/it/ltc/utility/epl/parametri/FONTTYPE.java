package it.ltc.utility.epl.parametri;

/**
 * FONTTYPE definisce i valori utilizzabile come font.
 * @author Antonio 08 set 2017
 *
 */
public enum FONTTYPE {
	
	/**
	 * value 1
	 */
	DIM_8x12("1"),
	/**
	 * value 2
	 */
	DIM_10x16("2"),
	/**
	 * value 3
	 */
	DIM_12x20("3"),
	/**
	 * value 4
	 */
	DIM_14x24("4"),
	/**
	 * value 5
	 */
	DIM_32x48("5"),
	/**
	 * value 6
	 */
	NUMONLY_DIM_14x19_6("6"),
	/**
	 * value 7
	 */
	NUMONLY_DIM_14x19_7("7");
	
	private String value;
	private FONTTYPE(String value){
		this.value = value;
	}
	
	public void setValue(String value) {
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
