package it.ltc.importazione.model.white;

public class AziendaWhite {
	
	public static final String NOMI_CAMPI = "ragioneSociale,sitoWeb,padiglione,genere";
	public static final String SEPARATOR = "\t";
	
	private final String ragioneSociale;
	private final String sitoWeb;
	private final String padiglione;
	private final String genere;
	
	public AziendaWhite(String ragioneSociale, String sitoWeb, String padiglione, String genere) {
		this.ragioneSociale = ragioneSociale.trim();
		this.sitoWeb = sitoWeb.trim();
		this.padiglione = padiglione.trim();
		this.genere = genere.trim();
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public String getSitoWeb() {
		return sitoWeb;
	}

	public String getPadiglione() {
		return padiglione;
	}

	public String getGenere() {
		return genere;
	}

	@Override
	public String toString() {
		return ragioneSociale + SEPARATOR + sitoWeb + SEPARATOR + padiglione + SEPARATOR + genere;
	}

}
