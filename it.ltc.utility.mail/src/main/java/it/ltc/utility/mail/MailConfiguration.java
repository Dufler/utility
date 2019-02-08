package it.ltc.utility.mail;

import java.util.Properties;

/**
 * Classe che contiene le informazioni necessarie a configurare il postino.
 * @author Damiano
 *
 */
public class MailConfiguration {
	
	private static final String DEFAULT_SEND_PORT = "25";
	private static final String DEFAULT_POP_PORT = "110";
	private static final String DEFAULT_IMAP_PORT = "143";
	
	private static final String DEFAULT_SEND_SERVER = "smtp.ltc-logistics.it";
	private static final String DEFAULT_POP_SERVER = "pop3.ltc-logistics.it";
	private static final String DEFAULT_IMAP_SERVER = "imap.ltc-logistics.it";
	
	private static final String DEFAULT_IMAP_HOST_PROPERTY = "mail.imap.host";
	private static final String DEFAULT_IMAP_PORT_PROPERTY = "mail.imap.port";
	private static final String DEFAULT_POP_HOST_PROPERTY = "mail.pop.host";
	private static final String DEFAULT_POP_PORT_PROPERTY = "mail.pop.port";
	
	private final String account;
	private final String password;
	private final String sendServer;
	private final String sendPort;
	private final String receiveHostProperty;
	private final String receivePortProperty;
	private final String receiveServer;
	private final String receivePort;
	
	public static MailConfiguration getArubaPopConfiguration(String account, String password) {
		MailConfiguration config = new MailConfiguration(account, password, DEFAULT_SEND_SERVER, DEFAULT_SEND_PORT, DEFAULT_IMAP_HOST_PROPERTY, DEFAULT_IMAP_PORT_PROPERTY, DEFAULT_IMAP_SERVER, DEFAULT_IMAP_PORT);
		return config;
	}
	
	public static MailConfiguration getArubaImapConfiguration(String account, String password) {
		MailConfiguration config = new MailConfiguration(account, password, DEFAULT_SEND_SERVER, DEFAULT_SEND_PORT, DEFAULT_POP_HOST_PROPERTY, DEFAULT_POP_PORT_PROPERTY, DEFAULT_POP_SERVER, DEFAULT_POP_PORT);
		return config;
	}
	
	public static MailConfiguration getGmailImapConfiguration(String account, String password) {
		MailConfiguration config = new MailConfiguration(account, password, "smtp.gmail.com", "587", DEFAULT_IMAP_HOST_PROPERTY, DEFAULT_IMAP_PORT_PROPERTY, "imap.gmail.com", "143");
		return config;
	}
	
	public MailConfiguration(String account, String password, String sendServer, String sendPort, String receiveHostProperty, String receivePortProperty, String receiveServer, String receivePort) {
		this.account = account;
		this.password = password;
		this.sendServer = sendServer;
		this.sendPort = sendPort;
		this.receiveHostProperty = receiveHostProperty;
		this.receivePortProperty = receivePortProperty;
		this.receiveServer = receiveServer;
		this.receivePort = receivePort;
	}
	
	public Properties getProperties() {
		Properties properties = new Properties(); //System.getProperties();
		properties.setProperty("mail.user", account);
		properties.setProperty("mail.password", password);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.host", sendServer);
		properties.setProperty("mail.smtp.port", sendPort);
		properties.setProperty(receiveHostProperty, receiveServer);
		properties.setProperty(receivePortProperty, receivePort);
		return properties;
	}

	public String getReceiveHostProperty() {
		return receiveHostProperty;
	}

	public String getReceivePortProperty() {
		return receivePortProperty;
	}

	public String getReceiveServer() {
		return receiveServer;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public String getSendServer() {
		return sendServer;
	}

	public String getSendPort() {
		return sendPort;
	}

	public String getReceivePort() {
		return receivePort;
	}	

}
