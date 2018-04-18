package it.ltc.utility.zpl.etichette.ltc;

/**
 * Classe che mappa un prodotto su DB a prodotto per etichetta.
 * @author Damiano
 *
 */
public class ProdottoEtichetta {

	private String codiceArticolo;
	private String taglia;
	private String descrizione;
	private int quantita;
	
	/**
	 * Costruttore vanilla.
	 * @param codiceArticolo
	 * @param taglia
	 * @param descrizione
	 * @param quantita
	 */
	public ProdottoEtichetta(String codiceArticolo, String taglia, String descrizione, int quantita) {
		this.codiceArticolo = codiceArticolo;
		this.taglia = taglia;
		this.descrizione = descrizione;
		this.quantita = quantita;
	}

	public String getCodiceArticolo() {
		return codiceArticolo;
	}
	
	public void setCodiceArticolo(String codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}
	
	public String getTaglia() {
		return taglia;
	}
	
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
}
