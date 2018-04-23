package it.ltc.epl.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import it.ltc.utility.epl.etichette.EtichettaColloinLTC_10x12;
import it.ltc.utility.epl.etichette.EtichettaImballoPackingList_10x12;
import it.ltc.utility.epl.etichette.EtichettaImballo_10x12;
import it.ltc.utility.epl.etichette.ProdottoEtichetta;



public class testEtichettaEPL {

	private static void Stampa(String label) throws IOException {
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter("filename.txt"));
		    writer.write(label);
		}
		catch ( IOException e)
		{
		}
		writer.close();
		
		ProcessBuilder builder = new ProcessBuilder(
	            "cmd.exe", "/c", "copy /B filename.txt \\\\192.168.0.49\\tpl2844");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
		
	}
	
	
	private static String getEtichettaEPL_10x12() {
		
		EtichettaImballo_10x12 label = new EtichettaImballo_10x12(800,960);
		
		label.ragsocCliente = "COMEST COMEST COMEST COMEST COMEST 1234567890123456789";
		label.indirizzoCliente = "VIA LE MANI DAL NASO, 29";
		label.capcittaprovCliente = "06100 PERUGIA PG";
		
		label.ragsocMittente = "L&TC SRL";
		label.capcittaprovMittente = "06100 PERUGIA PG";
		label.opzionaliCliente = "123456789";
		
		label.ragsocDestinatario = "COMEST COMEST COMEST COMEST COMEST 1234567890123456789 1234567890123456789 1234567890123456789";
		label.indirizzoDestinatario = "VIA S. CALINDRI";
		label.capcittaprovDestinatario = "06100 PERUGIA PG";
		label.nazioneDestinatario = "ITALIA";
		label.corriere = "TNT";
		label.numeroOrdine = "12345678900";
		label.peso = "10";
		
		label.note = "PROVA NOTE";
		
		label.numeroCollo = "123456789";
		label.progressivoCollo = "C99";
			
		label.EtichettaImballo_10x12Init();
		
		return label.toString();
	}
	
	
	private static String getPackingListEPL_10x12() {
		EtichettaImballoPackingList_10x12 label = new EtichettaImballoPackingList_10x12(800,  960);
		
		label.numeroOrdine = "12345678900";
		label.numeroCollo = "123456789";
		
		label.totalePezzi = "10";
		
		label.articoli = new ArrayList<ProdottoEtichetta>();
		ProdottoEtichetta prodotto1 = new ProdottoEtichetta();
		ProdottoEtichetta prodotto2 = new ProdottoEtichetta();
		ProdottoEtichetta prodotto3 = new ProdottoEtichetta();
		ProdottoEtichetta prodotto4 = new ProdottoEtichetta();
		
		prodotto1.codiceArticolo = "ARRRRPRG0001";
		prodotto2.codiceArticolo = "ARRRRPRG0002";
		prodotto3.codiceArticolo = "ARRRRPRG0002";
		prodotto4.codiceArticolo = "ARRRRPRG0002";
		
		prodotto1.taglia = "XS";
		prodotto2.taglia = "S";
		prodotto3.taglia = "M";
		prodotto4.taglia = "L";
		
		prodotto1.colore = "BLUE";
		prodotto2.colore = "RED";
		prodotto3.colore = "YELLOW";
		prodotto4.colore = "GREEN";
		
		prodotto1.descrizione = "FRIGORIFERO CONGELATORE SPAZIALE 1";
		prodotto2.descrizione = "FRIGORIFERO CONGELATORE SPAZIALE 2";
		prodotto3.descrizione = "FRIGORIFERO CONGELATORE SPAZIALE 3";
		prodotto4.descrizione = "FRIGORIFERO CONGELATORE SPAZIALE 4";
		
		prodotto1.quantita = "2";
		prodotto2.quantita = "2";
		prodotto3.quantita = "3";
		prodotto4.quantita = "3";
		
		prodotto1.barcode = "8000000000001";
		prodotto2.barcode = "8000000000002";
		prodotto3.barcode = "8000000000003";
		prodotto4.barcode = "8000000000004";
		
		label.articoli.add(prodotto1);
		label.articoli.add(prodotto2);
		label.articoli.add(prodotto3);
		label.articoli.add(prodotto4);

		label.EtichettaImballoPackingList_10x12Init(true);
		
		
		return label.toString();
	}
	
	public static String getEtichettaColliINLTC() {
		
		EtichettaColloinLTC_10x12 label = new EtichettaColloinLTC_10x12(800, 960);
		
		label.cliente = "COMEST SAS";
		label.packing = "DDT 12345";
		
		label.numCollo = "123456789";
		
		label.articoli = new ArrayList<>();
		
		ProdottoEtichetta prodotto1 = new ProdottoEtichetta();
		ProdottoEtichetta prodotto2 = new ProdottoEtichetta();
		ProdottoEtichetta prodotto3 = new ProdottoEtichetta();
		ProdottoEtichetta prodotto4 = new ProdottoEtichetta();
		
		prodotto1.codiceArticolo = "ARRRRPRG0001";
		prodotto2.codiceArticolo = "ARRRRPRG0002";
		prodotto3.codiceArticolo = "ARRRRPRG0002";
		prodotto4.codiceArticolo = "ARRRRPRG0002";
		
		prodotto1.taglia = "XS";
		prodotto2.taglia = "S";
		prodotto3.taglia = "M";
		prodotto4.taglia = "L";
		
		prodotto1.colore = "BLUE";
		prodotto2.colore = "RED";
		prodotto3.colore = "YELLOW";
		prodotto4.colore = "GREEN";
		
		prodotto1.descrizione = "FRIGORIFERO CONGELATORE SPAZIALE 1";
		prodotto2.descrizione = "FRIGORIFERO CONGELATORE SPAZIALE 2";
		prodotto3.descrizione = "FRIGORIFERO CONGELATORE SPAZIALE 3";
		prodotto4.descrizione = "FRIGORIFERO CONGELATORE SPAZIALE 4";
		
		prodotto1.quantita = "2";
		prodotto2.quantita = "2";
		prodotto3.quantita = "3";
		prodotto4.quantita = "3";
		
		prodotto1.barcode = "8000000000001";
		prodotto2.barcode = "8000000000002";
		prodotto3.barcode = "8000000000003";
		prodotto4.barcode = "8000000000004";
		
		label.articoli.add(prodotto1);
		label.articoli.add(prodotto2);
		label.articoli.add(prodotto3);
		label.articoli.add(prodotto4);

		label.ubicazionepProposta = "PROVA UBICAZIONE";
		label.quantitaTot = "10";
		
		label.EtichettaColloinLTC_10x12Init();
		
		
		return label.toString();
	}
	
	
	public static void main(String[] args) {
		String etichettaEPL = getEtichettaEPL_10x12();
		System.out.println("######### START ETICHETTA #########");
		System.out.println(etichettaEPL);
		System.out.println("######### END ETICHETTA #########");
		
		
		String etichettaPackingEPL = getPackingListEPL_10x12();
		System.out.println("######### START ETICHETTA #########");
		System.out.println(etichettaPackingEPL);
		System.out.println("######### END ETICHETTA #########");
		
		String etichettaColloInEPL = getEtichettaColliINLTC();
		System.out.println("######### START ETICHETTA #########");
		System.out.println(etichettaColloInEPL);
		System.out.println("######### END ETICHETTA #########");
		
		try {
			//Stampa(etichettaEPL);
			Stampa(etichettaColloInEPL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
