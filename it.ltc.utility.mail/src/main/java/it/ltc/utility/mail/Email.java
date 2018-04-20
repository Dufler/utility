package it.ltc.utility.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che modella una mail da inviare
 *
 * @author Damiano Bellucci - damiano.bellucci@gmail.com
 * @version 1.0
 *
 */
public class Email {
	
	private static final String ERRORE_ALLEGATO = "Impossibile inviare il file specificato, controlla che esista e che non sia una directory.";
	
	private String oggetto;
	private String messaggio;
	private List<File> allegati;
	
	/**
	 * Costruttore per la mail.
	 * @param subject l'oggetto della mail.
	 * @param body il corpo della mail.
	 */
	public Email(String subject, String body) {
		if (subject == null)
			subject = "";
		oggetto = subject;
		if (body == null)
			body = "";
		messaggio = body;
		allegati = new ArrayList<File>();
	}
	
	/**
	 * Costruttore per la mail.
	 * @param subject l'oggetto della mail.
	 * @param body il corpo della mail.
	 * @param pathAllegato il percorso in locale del file da inviare come allegato.
	 */
	public Email(String subject, String body, List<File> listaAllegati) {
		if (subject == null)
			subject = "";
		oggetto = subject;
		if (body == null)
			body = "";
		messaggio = body;
		if (listaAllegati == null)
			throw new IllegalArgumentException(ERRORE_ALLEGATO);
		allegati = listaAllegati;
		for (File allegato : listaAllegati) {
			if (allegato == null || !allegato.isFile()) {
				throw new IllegalArgumentException(ERRORE_ALLEGATO);
			}
		}
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public List<File> getAllegati() {
		return allegati;
	}

	public void setAllegato(File allegato) {
		if (allegato != null && allegato.isFile())
			allegati.add(allegato);
		else
			throw new IllegalArgumentException(ERRORE_ALLEGATO);
	}
	
	/**
	 * Determina se la mail ha un allegato o meno.
	 * @return true se la mail contiene un allegato, false altrimenti.
	 */
	public boolean contieneAllegato() {
		boolean allega = false;
		if (allegati != null && !allegati.isEmpty())
			allega = true;
		return allega;
	}

}
