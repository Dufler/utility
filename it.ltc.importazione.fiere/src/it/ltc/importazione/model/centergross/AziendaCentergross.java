package it.ltc.importazione.model.centergross;

public class AziendaCentergross {
	
	public static final String NOMI_CAMPI = "ragioneSociale,ambito,ubicazione,contatti";
	public static final String SEPARATOR = "\t";
	
	private final String ragioneSociale;
	private final String ambito;
	private final String ubicazione;
	private final String contatti;
	
	public AziendaCentergross(String ragioneSociale, String ambito, String ubicazione, String contatti) {
		this.ragioneSociale = ragioneSociale;
		this.ambito = ambito;
		this.ubicazione = ubicazione;
		this.contatti = contatti;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public String getAmbito() {
		return ambito;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public String getContatti() {
		return contatti;
	}

	@Override
	public String toString() {
		return ragioneSociale + SEPARATOR + ambito + SEPARATOR + ubicazione + SEPARATOR + contatti;
	}
	

}
