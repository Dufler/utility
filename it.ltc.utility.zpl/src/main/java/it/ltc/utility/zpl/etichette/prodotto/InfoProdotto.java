package it.ltc.utility.zpl.etichette.prodotto;

/**
 * Contiene tutte le info sul prodotto necessarie a stampare l'etichetta.
 * @author Damiano
 *
 */
public class InfoProdotto {
	
	private final String barcode;
	private final String sku;
	private final String taglia;
	private final String colore;
	private final String descrizione;
	
	public InfoProdotto(String barcode, String sku, String taglia, String colore, String descrizione) {
		this.barcode = barcode;
		this.sku = sku;
		this.taglia = taglia;
		this.colore = colore;
		this.descrizione = descrizione;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getSku() {
		return sku;
	}

	public String getTaglia() {
		return taglia;
	}

	public String getColore() {
		return colore;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
