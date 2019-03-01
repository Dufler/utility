package it.ltc.utility.ftp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

public class SFTP {
	
	private static final Logger logger = Logger.getLogger(SFTP.class);
	
	private final static int PORT = 22;

	private final JSch jsch;
	private final String host;
	private final String username;
	private final String password;
	
	private Session session;
	
	public SFTP(String pathToHost, String user, String pwd) {
		jsch = new JSch();
		host = pathToHost;
		username = user;
		password = pwd;
	}
	
	public boolean connect() {
		boolean connesso = false;
		try {
			session = jsch.getSession(username, host, PORT);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();
			connesso = true;
		} catch (JSchException e) {
			session = null;
			logger.error(e.getMessage(), e);
		}
		return connesso;
	}
	
	public boolean disconnect() {
		boolean disconnesso = false;
		if (session != null) {
			session.disconnect();
			disconnesso = true;
		}		
		return disconnesso;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<String> getFileList(String path) {
		ArrayList<String> files = new ArrayList<String>();
		if (session == null) {
			connect();
		}
		try {
			Channel channel = session.openChannel("sftp");
		    channel.connect();
		    ChannelSftp sftpChannel = (ChannelSftp) channel;
		    Vector<LsEntry> names = sftpChannel.ls(path);
		    for (LsEntry entry : names) {
		    	SftpATTRS attributi = entry.getAttrs();
		    	if (!attributi.isDir())
		    		files.add(entry.getFilename());
		    }
		    sftpChannel.exit();
		} catch (JSchException | SftpException e) {
			logger.error(e.getMessage(), e);
		}
		return files;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getFolderList(String path) {
		ArrayList<String> files = new ArrayList<String>();
		if (session == null) {
			connect();
		}
		try {
			Channel channel = session.openChannel("sftp");
		    channel.connect();
		    ChannelSftp sftpChannel = (ChannelSftp) channel;
		    Vector<LsEntry> names = sftpChannel.ls(path);
		    for (LsEntry entry : names) {
		    	SftpATTRS attributi = entry.getAttrs();
		    	if (attributi.isDir())
		    		files.add(entry.getFilename());
		    }
		    sftpChannel.exit();
		} catch (JSchException | SftpException e) {
			logger.error(e.getMessage(), e);
		}
		return files;
	}
	
	public boolean download(String remotePath, String localPath) {
		boolean download = false;
		if (session == null) {
			connect();
		}
		try {
			Channel channel = session.openChannel("sftp");
		    channel.connect();
		    ChannelSftp sftpChannel = (ChannelSftp) channel;
		    sftpChannel.get(remotePath, localPath);
		    download = true;
		    sftpChannel.exit();
		} catch (JSchException | SftpException e) {
			logger.error(e.getMessage());
			//logger.error(e.getMessage(), e);
		}
		return download;
	}
	
	/**
	 * Consente l'upload di un file.
	 * @param remotePath il percorso che il file dovrà avere sul server SFTP
	 * @param localPath il percorso del file da uploadare
	 * @return un boolean che indica il successo dell'operazione
	 */
	public boolean upload(String localPath, String remotePath) {
		boolean upload = false;
		if (session == null) {
			connect();
		}
		try {
			Channel channel = session.openChannel("sftp");
		    channel.connect();
		    ChannelSftp sftpChannel = (ChannelSftp) channel;
		    sftpChannel.put(localPath, remotePath);
		    upload = true;
		    sftpChannel.exit();
		} catch (JSchException | SftpException e) {
			logger.error(e.getMessage(), e);
		}
		return upload;
	}
	
	public boolean rename(String remotePath, String newName) {
		boolean rename = false;
		if (session == null) {
			connect();
		}
		try {
			Channel channel = session.openChannel("sftp");
		    channel.connect();
		    ChannelSftp sftpChannel = (ChannelSftp) channel;
		    sftpChannel.rename(remotePath, newName);
		    rename = true;
		} catch (JSchException | SftpException e) {
			logger.error(e.getMessage(), e);
		}
		return rename;
	}
	
}
