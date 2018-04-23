package it.ltc.utility.epl.elementi;

/**
 * Classe che mappa un elemento FontMinSize, utilizzato per definire le dimensioni minime di un TitoloRidimensionabile
 * @author Antonio 08 set 2017
 *
 */
public class FontMinSize {
	/**
	 * dimensione del font assumen un valore definito in FONTTYPE
	 */
	private final Integer size;
	/**
	 * moltiplicatore orizzontale
	 */
	private final Integer multiplierH;
	/**
	 * moltiplicatore verticale
	 */
	private final Integer multiplierV;
	
	public FontMinSize(Integer size, Integer multiH, Integer multiV) {
		this.size = size;
		this.multiplierH = multiH;
		this.multiplierV = multiV;
	}

	public Integer getSize() {
		return size;
	}

	public Integer getMultiplierH() {
		return multiplierH;
	}

	public Integer getMultiplierV() {
		return multiplierV;
	}
	
	
}