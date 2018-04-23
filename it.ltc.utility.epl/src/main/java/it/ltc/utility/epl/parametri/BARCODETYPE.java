package it.ltc.utility.epl.parametri;

/**
 * BARCODETYPE definisca le tipologia di barcode utilizzabili.
 * @author Antonio 08 set 2017
 *
 */
public enum BARCODETYPE {
	CODE39_STD("3"),
	CODE39_CKD("3C"),
	CODE128_AUTO("1"),
	CODE128_MODEA("1A"),
	CODE128_MODEB("1B"),
	CODE128_MODEC("1C"),
	EAN13("E30"),
	EAN13_2ADDON("E32"),
	EAN13_5ADDON("E35");
	
	private final String value;
	private BARCODETYPE(String value){
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
