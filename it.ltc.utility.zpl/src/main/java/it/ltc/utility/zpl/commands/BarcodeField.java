package it.ltc.utility.zpl.commands;

/**
 * Classe che mappa il comando ^BY necessario per definire le dimensioni del codice a barre.
 * 
 * <edit>
 * I parametri sono tutti necessari e non possono assumere valori nulli. Li ho cambiati per questo motivo.
 * - Damiano
 * </edit>
 * 
 * @author Antonio 24 ago 2017
 *
 */
public class BarcodeField {

	/**
	 * barHeight identifica l'altezza
	 */
	private final int barHeight;
	
	/**
	 * barWidth identifica la larghezza
	 */
	private final int barWidth;
	
	/**
	 * barWide identifica il rapporto tra una barra e la successiva [2.0 - 3.0] unit 0.1, default 3.0
	 */
	private final double barWide;
	
	/**
	 * <edit>Costruttore di default.
	 * barWide viene impostato al valore di default 3.0</edit>
	 * @param barWidth identifica la larghezza
	 * @param barWide identifica il rapporto tra una barra e la successiva [2.0 - 3.0] unit 0.1, default 3.0
	 * @param barHeight identifica l'altezza
	 */
	public BarcodeField(int h, int w) {
		this.barHeight = h;
		this.barWidth = w;
		this.barWide = 3.0;
	}

	/**
	 *  <edit>Costruttore che permette di specificare anche il parametro wide.</edit>
	 * @param barWidth identifica la larghezza
	 * @param barWide identifica il rapporto tra una barra e la successiva [2.0 - 3.0] unit 0.1, default 3.0
	 * @param barHeight identifica l'altezza
	 */
	public BarcodeField(int h, int w, double wide) {
		this.barHeight = h;
		this.barWidth = w;
		this.barWide = wide;
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("^BY");
		value.append(barWidth);
		value.append(",");
		value.append(barWide);
		value.append(",");
		value.append(barHeight);
		return value.toString();
	}
	
}
