package it.ltc.importazione.model.micam;

public class AziendaMicam {
	
	public static final String NOMI_CAMPI = "ragioneSociale;indirizzo;localita;provincia;regione;padiglione;stand";
	public static final String SEPARATOR = ";";
	
	private final String ragioneSociale;
	private final String indirizzo;
	private final String localita;
	private final String provincia;
	private final String regione;
	private final String padiglione;
	private final String stand;
	
	public AziendaMicam(String nome, String indirizzoCompleto, String nomeFile, String padiglioneMicam) {
		ragioneSociale = nome.trim();
		regione = nomeFile;
		int truncationIndex1 = indirizzoCompleto.lastIndexOf(',');
		int truncationIndex2 = indirizzoCompleto.lastIndexOf('(');
		int truncationIndex3 = indirizzoCompleto.lastIndexOf(')');
		int truncationIndex4 = padiglioneMicam.indexOf('-');
		indirizzo = indirizzoCompleto.substring(0, truncationIndex1).trim();
		localita = indirizzoCompleto.substring(truncationIndex1 + 1, truncationIndex2).trim();
		provincia = indirizzoCompleto.substring(truncationIndex2 + 1, truncationIndex3).trim();
		padiglione = padiglioneMicam.substring(0, truncationIndex4).trim();
		stand = padiglioneMicam.substring(truncationIndex4 + 1).trim();
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getLocalita() {
		return localita;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getRegione() {
		return regione;
	}

	public String getPadiglione() {
		return padiglione;
	}

	public String getStand() {
		return stand;
	}

	@Override
	public String toString() {
		return ragioneSociale + SEPARATOR + indirizzo + SEPARATOR + localita + SEPARATOR + provincia + SEPARATOR + regione + SEPARATOR + padiglione + SEPARATOR	+ stand;
	}

}
