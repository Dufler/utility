package it.ltc.utility.ftp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;

/**
 * Classe che offre semplici funzionalità FTP.
 *
 * @author Damiano Bellucci - damiano.bellucci@gmail.com
 * @version 1.0
 *
 */
public class FTP {
	
	private static final Logger logger = Logger.getLogger("FTP");
	
	private final String host, username, password;
	
	private final FTPClient ftpClient;
	
	/**
	 * Costruisce un connettore FTP per l'upload o il download di file.
	 * @param path il sito FTP
	 * @param user il nume utente da utilizzare, lasciare vuoto o null per accessi anonimi
	 * @param pwd la password da utilizzare, lasciare vuoto o null per accessi anonimi
	 */
	public FTP(String path, String user, String pwd) {
		if (path.endsWith("/"))
			path = path.substring(0, path.length() - 1);
		host = path;
		username = user;
		password = pwd;
		ftpClient = new FTPClient();
		login();
	}
	
	private boolean login() {
		boolean login = true;
		if (!ftpClient.isConnected()) {
			try {
				ftpClient.connect(host);
				login = ftpClient.login(username, password);
			} catch (IOException e) {
				login = false;
				logger.error(e.getMessage(), e);
			}
		}
		return login;
	}
	
	private void logout() {
		if (ftpClient.isConnected()) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * Restituisce tutti i nomi dei file nel path relativo specificato
	 * @param remoteRelativePath il percorso relativo all'interno del server FTP
	 * @return una lista di stringhe che rappresentano i nomi dei file
	 */
	public List<String> getFiles(String remoteRelativePath) {
		LinkedList<String> contenuto = new LinkedList<String>();
		login();
		try {			
			FTPFile[] files = ftpClient.listFiles(remoteRelativePath);
			for (FTPFile file : files) {
				if (file.getType() == FTPFile.FILE_TYPE)
					contenuto.add(file.getName());
			}
		}  catch (IOException e) {
			logger.error(e.getMessage(), e);
        }
		logout();
		return contenuto;
	}
	
	/**
	 * Restituisce tutti i nomi delle sottocartelle nel path relativo specificato
	 * @param remoteRelativePath il percorso relativo all'interno del server FTP
	 * @return una lista di stringhe che rappresentano i nomi delle sottocartelle
	 */
	public List<String> getFolders(String remoteRelativePath) {
		LinkedList<String> contenuto = new LinkedList<String>();
		login();
		try {
			FTPFile[] files = ftpClient.listFiles(remoteRelativePath);
			for (FTPFile file : files) {
				if (file.getType() == FTPFile.DIRECTORY_TYPE)
					contenuto.add(file.getName());
			}
		}  catch (IOException e) {
			logger.error(e.getMessage(), e);
        }
		logout();
		return contenuto;
	}
	
	/**
	 * Esegue l'upload di un file locale sul percorso relativo specificato
	 * @param localPath il percorso in locale del file da 'uploadare'
	 * @param remoteRelativePath il percorso relativo (cartella + nome) che avrà il file sul sito FTP
	 * @return l'esito dell'operazione.
	 */
	public boolean upload(String localPath, String remoteRelativePath) {
		boolean upload = true;
		login();
		try {
			FileInputStream inputStream = new FileInputStream(localPath);
		    upload = ftpClient.storeFile(remoteRelativePath, inputStream);
		    inputStream.close();
		} catch (IOException e) {
			upload = false;
			logger.error(e.getMessage(), e);
        }
		logout();
		return upload;
	}
	
	/**
	 * Esegue il download di un file dal percorso relativo specificato sul percorso locale desiderato
	 * @param localPath il percorso locale dove verrà salvato il file
	 * @param remoteRelativePath il percorso della risorsa remota da scaricare
	 * @return l'esito dell'operazione
	 */
	public boolean download(String localPath, String remoteRelativePath) {
		boolean download = true;
		login();
		try {
			FileOutputStream outputStream = new FileOutputStream(localPath);
			download = ftpClient.retrieveFile(remoteRelativePath, outputStream);
		} catch (IOException e) {
			download = false;
			logger.error(e.getMessage(), e);
        }
		logout();
		return download;
	}
	
	public boolean rename(String from, String to) {
		boolean rename = true;
		login();
		try {
			ftpClient.rename(from, to);
		} catch (IOException e) {
			rename = false;
			logger.error(e.getMessage(), e);
        }
		logout();
		return rename;
		
	}
	
	/**
	 * Cancella il file specificato sul server FTP
	 * @param remoteRelativePath il percorso della risorsa remota da cancellare
	 * @return l'esito dell'operazione
	 */
	public boolean deleteFile(String remoteRelativePath) {
		boolean delete = true;
		login();
		try {
			delete = ftpClient.deleteFile(remoteRelativePath);
		} catch (IOException e) {
			delete = false;
			logger.error(e.getMessage(), e);
		}
		logout();
		return delete;
	}
	
	/**
	 * Crea una cartella con il percorso specificato sul server FTP
	 * @param remoteRelativePath il percorso in cui creare la cartella
	 * @return l'esito dell'operazione
	 */
	public boolean createFolder(String remoteRelativePath) {
		boolean create = true;
		login();
		try {
			create = ftpClient.makeDirectory(remoteRelativePath);
		} catch (IOException e) {
			create = false;
			logger.error(e.getMessage(), e);
		}
		logout();
		return create;
	}
	
	/**
	 * Cancella la cartella sul percorso specificato
	 * @param remoteRelativePath il percorso relativo della cartella da cancellare sul server FTP
	 * @return l'esito dell'operazione
	 */
	public boolean deleteFolder(String remoteRelativePath) {
		boolean delete = true;
		login();
		try {
			delete = ftpClient.removeDirectory(remoteRelativePath);
		} catch (IOException e) {
			delete = false;
			logger.error(e.getMessage(), e);
		}
		logout();
		return delete;
	}

}
