package it.ltc.utility.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Classe wrapper usata per l'autenticazione
 *
 * @author Damiano Bellucci - damiano.bellucci@gmail.com
 * @version 1.0
 *
 */
public class MailAuthenticator extends Authenticator {
	
	private final String account;
	private final String password;
	
	public MailAuthenticator(String user, String pwd) {
		account = user;
		password = pwd;
	}
	
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(account, password);
	}

}
