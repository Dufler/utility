package it.ltc.utility.mail;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

/**
 * Classe che offre delle utility per l'invio e la ricezione di email.
 * I valori di default contenuti sono quelli più utilizzati nell'ambito di L&TC.
 *
 * @author Damiano Bellucci - damiano.bellucci@gmail.com
 * @version 1.0
 *
 */
public class MailMan {
	
	private static final Logger logger = Logger.getLogger(MailMan.class);
	
//	private static final String DEFAULT_SEND_PORT = "25";
//	private static final String DEFAULT_POP_PORT = "110";
//	private static final String DEFAULT_IMAP_PORT = "143";
//	
//	private static final String DEFAULT_SEND_SERVER = "smtp.ltc-logistics.it";
//	private static final String DEFAULT_POP_SERVER = "pop3.ltc-logistics.it";
//	private static final String DEFAULT_IMAP_SERVER = "imap.ltc-logistics.it";
//	
//	private static final String DEFAULT_IMAP_HOST_PROPERTY = "mail.imap.host";
//	private static final String DEFAULT_IMAP_PORT_PROPERTY = "mail.imap.port";
//	private static final String DEFAULT_POP_HOST_PROPERTY = "mail.pop.host";
//	private static final String DEFAULT_POP_PORT_PROPERTY = "mail.pop.port";
	
//	private final String account;
//	private final String password;
//	private final String sendServer;
//	private final String sendPort;
//	private String receiveHostProperty;
//	private String receivePortProperty;
//	private String receiveServer;
//	private final String receivePort;
	private final Properties properties;
	private final Session session;
	private final MailAuthenticator auth;
	
	private final MailConfiguration config;
	
	public MailMan(MailConfiguration config) {
		this.config = config;
		this.properties = config.getProperties();
		this.auth = new MailAuthenticator(config.getAccount(), config.getPassword());
		this.session = Session.getDefaultInstance(properties, auth);
	}
	
//	/**
//	 * Crea un oggetto postino in grado di inviare e ricevere mail per l'indirizzo specificato.
//	 * @param mail l'account di posta elettronica da usare. Es. casella@dominio.it
//	 * @param pwd la password dell'account di posta specificato.
//	 * @param imap utilizza o meno IMAP, l'alternativa è POP3.
//	 */
//	public MailMan(String mail, String pwd, boolean imap) {
//		account = mail;
//		password = pwd;
//		sendServer = DEFAULT_SEND_SERVER;
//		sendPort = DEFAULT_SEND_PORT;
//		if (imap) {
//			receiveHostProperty = DEFAULT_IMAP_HOST_PROPERTY;
//			receivePortProperty = DEFAULT_IMAP_PORT_PROPERTY;
//			receiveServer = DEFAULT_IMAP_SERVER;
//			receivePort = DEFAULT_IMAP_PORT;
//		} else {
//			receiveHostProperty = DEFAULT_POP_HOST_PROPERTY;
//			receivePortProperty = DEFAULT_POP_PORT_PROPERTY;
//			receiveServer = DEFAULT_POP_SERVER;
//			receivePort = DEFAULT_POP_PORT;
//		}
//		properties = System.getProperties();
//		properties.setProperty("mail.user", account);
//		properties.setProperty("mail.password", password);
//		properties.setProperty("mail.smtp.auth", "true");
//		properties.setProperty("mail.smtp.host", sendServer);
//		properties.setProperty("mail.smtp.port", sendPort);
//		properties.setProperty(receiveHostProperty, receiveServer);
//		properties.setProperty(receivePortProperty, receivePort);
//		auth = new MailAuthenticator(account, password);
//		session = Session.getDefaultInstance(properties, auth);
//	}
//	
//	/**
//	 * Crea un oggetto postino in grado di inviare e ricevere mail su una casella google.
//	 * @param mail l'account di posta elettronica da usare. Es. casella@gmail.com
//	 * @param pwd la password dell'account di posta specificato.
//	 */
//	public MailMan(String mail, String pwd) {
//		account = mail;
//		password = pwd;
//		sendServer = "smtp.gmail.com";
//		sendPort = "587";
//		receiveHostProperty = DEFAULT_IMAP_HOST_PROPERTY;
//		receivePortProperty = DEFAULT_IMAP_PORT_PROPERTY;
//		receiveServer = "imap.gmail.com";
//		receivePort = "143";
//		properties = System.getProperties();
//		properties.setProperty("mail.user", account);
//		properties.setProperty("mail.password", password);
//		properties.setProperty("mail.smtp.auth", "true");
//		properties.setProperty("mail.smtp.starttls.enable", "true");
//		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//		properties.setProperty("mail.smtp.port", "587");
//		properties.setProperty(receiveHostProperty, receiveServer);
//		properties.setProperty(receivePortProperty, receivePort);
//		auth = new MailAuthenticator(account, password);
//		session = Session.getDefaultInstance(properties, auth);
//	}
//	
//	/**
//	 * Crea un oggetto postino in grado di inviare e ricevere mail per l'indirizzo specificato.
//	 * Vanno specificati tutti i parametri richiesti.
//	 * @param mail l'account di posta elettronica da usare. Es. casella@dominio.it
//	 * @param pwd la password dell'account di posta specificato.
//	 * @param senderS il server di posta per l'invio. Es. smtp.dominio.it
//	 * @param senderP la porta da utilizzare per l'invio.
//	 * @param receiverS il server di posta per la ricezione. Es. imap.dominio.it 
//	 * @param receiverP la porta da utilizzare per la ricezione
//	 */
//	public MailMan(String mail, String pwd, String senderS, String senderP, String receiverS, String receiverP) {
//		account = mail;
//		password = pwd;
//		sendServer = senderS;
//		sendPort = senderP;
//		receiveServer = receiverS;
//		receivePort = receiverP;
//		properties = System.getProperties();
//		properties.setProperty("mail.smtp.host", sendServer);
//		properties.setProperty("mail.user", account);
//		properties.setProperty("mail.password", password);
//		auth = new MailAuthenticator(account, password);
//		session = Session.getDefaultInstance(properties);
//	}
	
	/**
	 * Invia la mail specificata ai destinatari specificati
	 * @param destinatari la lista di stringhe che rappresentano gli indirizzi mail dei destinatari
	 * @param mail la mail da inviare
	 * @return l'esito dell'operazione
	 */
	public boolean invia(Set<String> destinatari, Email mail) {
		boolean invio;
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(config.getAccount()));
			for (String destinatario : destinatari) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			}
			 message.setSubject(mail.getOggetto());
			 if (mail.contieneAllegato()) {
				 BodyPart messageBodyPart = new MimeBodyPart();
				 messageBodyPart.setText(mail.getMessaggio());
				 Multipart multipart = new MimeMultipart();
				 multipart.addBodyPart(messageBodyPart);
				 List<File> allegati = mail.getAllegati();
				 for (File allegato : allegati) {
					 DataSource source = new FileDataSource(allegato);
					 BodyPart attachmentBodyPart = new MimeBodyPart();
					 attachmentBodyPart.setDataHandler(new DataHandler(source));
					 attachmentBodyPart.setFileName(allegato.getName());
					 multipart.addBodyPart(attachmentBodyPart);
				 }
				 message.setContent(multipart);
			 } else {
				 message.setText(mail.getMessaggio());
			 }			 
			 Transport.send(message);
			 invio = true;
		} catch (MessagingException e) {
			invio = false;
			logger.error(e.getMessage(), e);
		}
		return invio;
	}
	
	/**
	 * Restituisce tutte le mail nella cartella posta in arrivo
	 * @return un lista di oggetti Email
	 */
	public List<Email> ricevi() {
		LinkedList<Email> inbox = new LinkedList<Email>();
		return inbox;
	}

}
