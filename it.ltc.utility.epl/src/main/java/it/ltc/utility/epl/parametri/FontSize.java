package it.ltc.utility.epl.parametri;

/**
 * Classe che mappa il FontSize 
 * @author Antonio 08 set 2017
 *
 */
public class FontSize {

	/**
	 * dimensione orizzontale del font
	 */
	private final int w;
	/**
	 * dimensione verticale del font
	 */
	private final int h;
	/**
	 * valore che identifica il font
	 */
	private final String value;
	
	/**
	 * Metodo che setta i valori w e h del font dato il parametro in ingresso
	 * @param value
	 */
	public FontSize(String value){
		this.value = value;
		if (value.equals("1")) {
			this.w = 8;
			this.h = 12;
		}
		else if (value.equals("2")) {
			this.w = 10;
			this.h = 16;
		}
		else if (value.equals("3")) {
			this.w = 12;
			this.h = 20;
		}
		else if (value.equals("4")) {
			this.w = 14;
			this.h = 24;
		}
		else if (value.equals("5")) {
			this.w = 32;
			this.h = 48;
		}
		else if (value.equals("6")) {
			this.w = 14;
			this.h = 19;
		}
		else if (value.equals("7")) {
			this.w = 14;
			this.h = 19;
		}
		else {
			this.w = 8;
			this.h = 12;
		}
	}
	
	public String getValue() {
		return this.value;
	}
	
	public Integer getH() {
		return this.h;
	}
	
	public Integer getW() {
		return this.w;
	}
	
	
	
	@Override
	public String toString() {
		return "Altezza, Larghezza: " + h + "," + w;
	}
}
