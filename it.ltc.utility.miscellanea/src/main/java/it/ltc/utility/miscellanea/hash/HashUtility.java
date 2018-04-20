package it.ltc.utility.miscellanea.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtility {
	
	public static final String SHA_256 = "SHA-256";
	public static final String SHA_512 = "SHA-512";
	
	private static String strategy = SHA_256;
	
	private static MessageDigest md;
	
	public static String getHash(String s) {
		String hash;
		//NULL Check
		if (s == null)
			s = "";
		try {
			md = MessageDigest.getInstance(strategy);
			md.update(s.getBytes());
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
			hash = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			hash = null;
			e.printStackTrace();
		}
		return hash;
	}
	
	public void setStrategy(String type) {
		strategy = type;
	}

}
