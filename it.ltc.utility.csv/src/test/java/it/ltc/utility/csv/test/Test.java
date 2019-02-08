package it.ltc.utility.csv.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.junit.Before;

import it.ltc.utility.csv.FileCSV;

public class Test {
	
	public static final String NEW_LINE = System.lineSeparator();
	public static final String TEST_PATH = System.getProperty("user.dir") + System.getProperty("path.separator");
	public static final String TEST_FILE_NAME = "test.csv";
	public static final String TEST_FILE_NAME_2 = "test2.csv";
	
	public static final String[] INDICI_COLONNE = {"0", "1", "2", "3"};
	
	public static final String INTESTAZIONE = "colonna0,colonna1,colonna2,colonna3";
	public static final String RIGA = "a,1.0,1,true";
	
	public static final String INTESTAZIONE_2 = "colonna0;colonna2;colonna1;colonna3";
	public static final String RIGA_2 = "a;1;1.0;true";

	File fileCSV;
	FileCSV csv;
	
	File fileCSV_2;
	FileCSV csv_2;
	
	@Before
	public void setUp() throws Exception {
		//File csv uno
		String testFilePath = TEST_PATH + TEST_FILE_NAME;
		fileCSV = new File(testFilePath);
		FileWriter writer = new FileWriter(fileCSV);
		writer.write(INTESTAZIONE + NEW_LINE + RIGA);
		writer.flush();
		writer.close();
		csv = FileCSV.leggiFile(fileCSV, true, ",", ",",  FileCSV.DEFAULT_DATE_FORMAT);
		//File csv due
		String testFilePath_2 = TEST_PATH + TEST_FILE_NAME;
		fileCSV_2 = new File(testFilePath_2);
		FileWriter writer_2 = new FileWriter(fileCSV_2);
		writer_2.write(INTESTAZIONE_2 + NEW_LINE + RIGA_2);
		writer_2.flush();
		writer_2.close();
		csv_2 = FileCSV.leggiFile(fileCSV_2, true, ";", ";", FileCSV.DEFAULT_DATE_FORMAT);
	}

	@org.junit.Test
	public void testGetMappaColonne() {
		//Test sulla mappa, per ogni colonna controllo il nome e l'indice. 
		for (String indiceColonna : INDICI_COLONNE) {
			String colonna = "colonna" + indiceColonna;
			assertEquals(csv.isColonnaPresente(colonna), true);
		}
	}

	@org.junit.Test
	public void testGetIntestazione() {
		String intestazione = csv.getIntestazione();
		assertEquals(intestazione, INTESTAZIONE);
	}

	@org.junit.Test
	public void testGetRighe() {
		List<String[]> righe = csv.getRighe();
		//Numero di righe
		assertEquals(righe.size(), 1);
		//Contenuto della riga.
		String[] riga = righe.get(0);
		String contenutoRiga = "";
		for (String campo : riga)
			contenutoRiga += campo +",";
		if (contenutoRiga.endsWith(","))
			contenutoRiga = contenutoRiga.substring(0, contenutoRiga.length() - 1);
		assertEquals(contenutoRiga, RIGA);
		//Test sulla corrispondenza del contenuto dei due files csv
		List<String[]> righe_2 = csv_2.getRighe();
		assertEquals(righe_2.size(), 1);
		String[] riga_2 = righe_2.get(0);
		for (String indiceColonna : INDICI_COLONNE) {
			String colonna = "colonna" + indiceColonna;
			Integer indice = csv.getIndiceColonna(colonna);
			Integer indice_2 = csv_2.getIndiceColonna(colonna);
			assertEquals(riga[indice], riga_2[indice_2]);
		}
	}

}
