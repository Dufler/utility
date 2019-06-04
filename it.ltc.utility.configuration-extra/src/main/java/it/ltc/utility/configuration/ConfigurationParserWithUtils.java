package it.ltc.utility.configuration;

import java.util.Set;

import it.ltc.utility.ftp.FTP;
import it.ltc.utility.ftp.SFTP;
import it.ltc.utility.mail.MailConfiguration;
import it.ltc.utility.mail.MailMan;

/**
 * Classe che parsa il file di configurazione e rende disponibili molte utility.
 * @author Damiano
 *
 */
public abstract class ConfigurationParserWithUtils extends ConfigurationParser {
	
	public ConfigurationParserWithUtils(String configPath) {
		super(configPath);
	}

	/**
	 * Restituisce il postino.
	 * 
	 * @return un MailMan gia' configurato.
	 */
	public MailMan getMailMan() {
		MailMan mm = getMailManAruba("email_mittente_indirizzo", "email_mittente_password");
		return mm;
	}
	
	protected MailMan getMailManAruba(String keyMailAddress, String keyMailPassword) {
		String mailUser = configuration.get(keyMailAddress);
		String mailPassword = configuration.get(keyMailPassword);
		MailConfiguration config = MailConfiguration.getArubaPopConfiguration(mailUser, mailPassword);
		MailMan mm = new MailMan(config);
		return mm;
	}
	
	/**
	 * Restituisce la lista di indirizzi dei destinatari.
	 * 
	 * @return una lista di indirizzi mail a cui verranno spedite le notifiche.
	 */
	public Set<String> getIndirizziDestinatari() {
		Set<String> destinatari = getStringList("email_destinatari_indirizzi", ",");
		return destinatari;
	}

	/**
	 * Restituisce la lista di indirizzi dei destinatari.
	 * 
	 * @return una lista di indirizzi mail a cui verranno spedite le notifiche.
	 */
	public Set<String> getIndirizziResponsabili() {
		Set<String> destinatari = getStringList("email_destinatari_responsabili_indirizzi", ",");
		return destinatari;
	}
	
	public Set<String> getIndirizziDestinatariErrori() {
		Set<String> destinatari = getStringList("email_destinatari_indirizzi_errori", ",");
		return destinatari;
	}
	
	/**
	 * Restituisce un client FTP.
	 * 
	 * @return un client FTP gia' configurato.
	 */
	public FTP getFTPClient() {
		FTP client = getFTPClient("ftp_host", "ftp_user", "ftp_password");
		return client;
	}
	
	protected FTP getFTPClient(String keyHost, String keyUser, String keyPassword) {
		String ftpHost = configuration.get(keyHost);
		String ftpUser = configuration.get(keyUser);
		String ftpPassword = configuration.get(keyPassword);
		FTP client = new FTP(ftpHost, ftpUser, ftpPassword);
		return client;
	}
	
	/**
	 * Restituisce un client SFTP. (versione sicura del protocollo FTP)
	 * 
	 * @return un client FTP gia' configurato.
	 */
	public SFTP getSFTPClient() {
		SFTP client = getSFTPClient("sftp_host", "sftp_user", "sftp_password");
		return client;
	}
	
	protected SFTP getSFTPClient(String keyHost, String keyUser, String keyPassword) {
		String ftpHost = configuration.get(keyHost);
		String ftpUser = configuration.get(keyUser);
		String ftpPassword = configuration.get(keyPassword);
		SFTP client = new SFTP(ftpHost, ftpUser, ftpPassword);
		return client;
	}

}
