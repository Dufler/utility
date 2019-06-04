package it.ltc.utility.zpl.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import it.ltc.utility.zpl.etichette.ltc.EtichettaColloInLTC_10x7;
import it.ltc.utility.zpl.etichette.ltc.ProdottoEtichetta;
import it.ltc.utility.zpl.etichette.prodotto.EtichettaProdotto_320x500;
import it.ltc.utility.zpl.etichette.prodotto.InfoProdotto;

public class TestEtichette {

	public static void stampaTramiteWS(String etichetta) throws IOException {
		String url = "http://ws.services.ltc-logistics.it/stampa/ws/stampa/192.168.0.97";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "text/plain");

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(etichetta);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		StringBuffer response = new StringBuffer();
		
		if (responseCode == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} else {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}
		

		//print result
		System.out.println(response.toString());
		
	}
	
	public static void stampaDiretta(String etichetta) throws Exception {
		String host = "192.168.0.97";
		int port = 9100;
		Socket socket = new Socket(host, port);
		socket.setSoTimeout(1000);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println(etichetta);
		out.flush();
		socket.close();
	}
	
//	public static String getEtichettaTNT_10x7() {
//		
//		EtichettaTNT_10x7 tntLabel = new EtichettaTNT_10x7(609,812);
//		tntLabel.barcode = "750000268378017060004056";
//		tntLabel.nrColli = "1";
//		tntLabel.peso = null;
//		tntLabel.mittente = "SOCIETA ELETTRONICA IN COMEST  SAS";
//		tntLabel.destinatario = "LEONARDO BASILE";
//		tntLabel.indirizzoDest = "VIA MASSIMO D'AZEGLIO 10/24510 PIPPO";
//		tntLabel.localitaDest = "PALAZZOLO SULL'OGLIO";
//		
//		tntLabel.codFilialePartenza = "PG";
//		tntLabel.dataPartenza = "18/08/2017";
//		tntLabel.letteraVettura = "RL50707200";
//		
//		tntLabel.numSegnaCollo = "00001";
//		tntLabel.codFilialeArrivo = "BS";
//		tntLabel.filialeArrivo = "BRESCIA";
//		tntLabel.rifMittente = "171314151";
//		
//		tntLabel.speciale = "";
//		tntLabel.servizioPremium = "";
//		tntLabel.hub = "07";
//		tntLabel.micorZona = "P05";
//		
//		tntLabel.destinatario2 = "LEONARDO BASILE";
//		tntLabel.commento = "TEST ANTONIO";
//		
//		tntLabel.EtichettaTNT_10x7Init();
//		
//		return tntLabel.toString();
//	}
	
	
	public static void stampaEtichettaLTC() throws Exception {
		
		String cliente = "COMEST SAS";
		String packing = "DDT 345678";
		String barcode = "PG123456789";
		String ubicazione = "PROVAUBICAZIONE EEEEE";
		String numeroCollo = "123456789";
		ProdottoEtichetta[] prodotti = new ProdottoEtichetta[6];
		
		prodotti[0] = new ProdottoEtichetta("MDCAERO121", "XS", "VENTILATORE DA TAVOLO BLACK", 2);
		prodotti[1] = new ProdottoEtichetta("MDCAERO122", "S", "VENTILATORE DA TAVOLO BLUE", 3);
		prodotti[2] = new ProdottoEtichetta("MDCAERO123", "M", "VENTILATORE DA TAVOLO RED", 4);
		prodotti[3] = new ProdottoEtichetta("MDCAERO124", "L", "VENTILATORE DA TAVOLO YELLOW", 5);
		prodotti[4] = new ProdottoEtichetta("MDCAERO125", "XL", "VENTILATORE DA TAVOLO GREEN", 6);
		prodotti[5] = new ProdottoEtichetta("MDCAERO126", "UNI", "VENTILATORE DA TAVOLO VIOLET", 7);
		
		EtichettaColloInLTC_10x7 label = new EtichettaColloInLTC_10x7(cliente, packing, barcode, ubicazione, numeroCollo, prodotti, null);
		
		System.out.println("######### START ETICHETTA #########");
		System.out.println(label);
		System.out.println("######### END ETICHETTA #########");
		stampaTramiteWS(label.toString());
	}
	
	public static void stampaEtichettaProdotto_320x500(InfoProdotto info) throws Exception {
		//InfoProdotto info = new InfoProdotto("CS1818WM", "CS1818W", "M", "White", "");
		EtichettaProdotto_320x500 etichetta = new EtichettaProdotto_320x500(info);
		String label = etichetta.toString();
		//System.out.println(label);
		stampaDiretta(label);
		Thread.sleep(1200);
		//System.out.println("Stampato");
	}
	
	public static void printQuantity(String sku, String colour, String size, int quantity) throws Exception {
		InfoProdotto info = new InfoProdotto(sku + size, sku, size, colour, "");
		for (int i = 0; i < quantity; i++) {
			stampaEtichettaProdotto_320x500(info);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		stampaEtichettaLTC();
		//stampaEtichettaProdotto_320x500();
		List<String[]> productsQuantities = readFile();
		for (String[] productQuantity : productsQuantities) {
			String sku = productQuantity[0];
			String colour = productQuantity[1];
			int xsQuantity = Integer.parseInt(productQuantity[2]);
			printQuantity(sku, colour, "XS", xsQuantity);
			int smQuantity = Integer.parseInt(productQuantity[3]);
			printQuantity(sku, colour, "SM", smQuantity);
			int mdQuantity = Integer.parseInt(productQuantity[4]);
			printQuantity(sku, colour, "MD", mdQuantity);
			int lgQuantity = Integer.parseInt(productQuantity[5]);
			printQuantity(sku, colour, "LG", lgQuantity);
			System.out.println("Stampato: " + sku);
		}
		
	}
	
	private static List<String[]> readFile() throws Exception {
		List<String[]> content = new LinkedList<>();
		FileReader in = new FileReader("C:/Users/Damiano/Desktop/quantities.txt");
		BufferedReader reader = new BufferedReader(in);
		String line = reader.readLine();
		while (line != null) {
			String[] info = line.split("\\s+");
			content.add(info);
			line = reader.readLine();
		}
		reader.close();
		return content;
	}

}
