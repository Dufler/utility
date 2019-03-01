package it.ltc.utility.microsoft.converter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.format.CellFormat;

public class FileExcel {
//
//	private final WritableWorkbook fileExcel;
//	private final HashMap<String, WritableSheet> fogliExcel;
//	
//	//Test
//	private CellFormat formatoTitolo;
//	private CellFormat formatoSottoTitolo;
//	private CellFormat formatoTesto;
//	private CellFormat formatoIntero;
//	private CellFormat formatoDecimale;
//	private CellFormat formatoPercentuale;
//	private CellFormat formatoData;
//	private CellFormat formatoValutaDueCifreDecimali;
//	private CellFormat formatoValutaTreCifreDecimali;
//	
//	private FileExcel(File file) throws IOException {
//		fileExcel = Workbook.createWorkbook(file);
//		fogliExcel = new HashMap<String, WritableSheet>();
//	}
//	
//	/**
//	 * Genera un'instanza con il nome e path specificati. Se fallisce restituisce un null.
//	 * @param file il nome del file completo del path.
//	 * @return la nuova instanza. null in caso di errori.
//	 */
//	public static FileExcel getFileExcel(String file) {
//		FileExcel fileExcel = null;
//		try {
//			fileExcel = new FileExcel(new File(file));
//		} catch(IOException e) {
//			//Problemi di generazione
//			e.printStackTrace();
//		}
//		return fileExcel;
//	}
//	
//	/**
//	 * Salve le modifiche effettuate sul foglio di lavoro e lo chiude.
//	 * @return l'esito dell'operazione.
//	 */
//	public boolean salvaEChiudi()  {
//		boolean successo = true;
//		try {
//			fileExcel.write();
//			fileExcel.close();
//		} catch (IOException | WriteException e) {
//			successo = false;
//			e.printStackTrace();
//		} 
//		return successo;
//	}
//	
//	/**
//	 * Restituisce il foglio con il nome indicato se già esiste, altrimenti ne crea uno con quel nome.
//	 * @param nome il nome del foglio.
//	 * @return il foglio con il nome specificato.
//	 */
//	public void creaFoglio(String nome) {
//		if (!fogliExcel.containsKey(nome))  {
//			WritableSheet foglio = fileExcel.createSheet(nome, fogliExcel.size());
//			fogliExcel.put(nome, foglio);
//		}
//		//return fogliExcel.get(nome);
//	}
//	
//	private boolean aggiungiCella(WritableSheet sheet, WritableCell cell) {
//		boolean aggiungi = true;
//		try {
//			sheet.addCell(cell);
//		} catch (WriteException e) {
//			aggiungi = false;
//			e.printStackTrace();
//		}
//		return aggiungi;
//	}
//	
//	private CellFormat getFormatoTitolo() {
//		if (formatoTitolo == null) {
//			WritableFont arial16font = new WritableFont(WritableFont.ARIAL, 16);
//			formatoTitolo = new WritableCellFormat(arial16font);
//		}
//		
//		return formatoTitolo;
//	}
//	
//	private CellFormat getFormatoSottoTitolo() {
//		if (formatoSottoTitolo == null) {
//			WritableFont arial12font = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
//			formatoSottoTitolo = new WritableCellFormat(arial12font);
//		}
//		return formatoSottoTitolo;
//	}
//	
//	private CellFormat getFormatoTesto() {
//		if (formatoTesto == null) {
//			WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
//			formatoTesto = new WritableCellFormat(arial10font);
//		}
//		return formatoTesto;
//	}
//	
//	private CellFormat getFormatoIntero() {
//		if (formatoIntero == null) {
//			formatoIntero = new WritableCellFormat (NumberFormats.INTEGER);
//		}
//		return formatoIntero;
//	}
//	
//	private CellFormat getFormatoNumero() {
//		if (formatoDecimale == null) {
//			formatoDecimale = new WritableCellFormat (NumberFormats.FLOAT);
//		}
//		return formatoDecimale;
//	}
//	
//	private CellFormat getFormatoPercentuale() {
//		if (formatoPercentuale == null) {
//			formatoPercentuale = new WritableCellFormat (NumberFormats.PERCENT_FLOAT);
//		}
//		return formatoPercentuale;
//	}
//	
//	private CellFormat getFormatoValutaDueCifre() {
//		if (formatoValutaDueCifreDecimali == null) {
//			NumberFormat formatoEuro = new NumberFormat("\u20AC" + " ###,##0.00", NumberFormat.COMPLEX_FORMAT);
//			formatoValutaDueCifreDecimali = new WritableCellFormat (formatoEuro);
//		}
//		return formatoValutaDueCifreDecimali;
//	}
//	
//	private CellFormat getFormatoValutaTreCifre() {
//		if (formatoValutaTreCifreDecimali == null) {
//			NumberFormat formatoEuro = new NumberFormat("\u20AC" + " ###,##0.000", NumberFormat.COMPLEX_FORMAT);
//			formatoValutaTreCifreDecimali = new WritableCellFormat (formatoEuro);
//		}
//		return formatoValutaTreCifreDecimali;
//	}
//	
//	private CellFormat getFormatoData() {
//		if (formatoData == null) {
//			DateFormat customDateFormat = new DateFormat("dd/MMM/yyyy");
//			formatoData = new WritableCellFormat (customDateFormat);
//		}
//		return formatoData; 
//	}
//
//	public boolean aggiungiTitolo(String foglio, int colonna, int riga, String titolo) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			Label label = new Label(colonna, riga, titolo);
//			label.setCellFormat(getFormatoTitolo());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//	
//	public boolean aggiungiSottoTitolo(String foglio, int colonna, int riga, String sottoTitolo) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			Label label = new Label(colonna, riga, sottoTitolo);
//			label.setCellFormat(getFormatoSottoTitolo());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//	
//	public boolean aggiungiTesto(String foglio, int colonna, int riga, String testo) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			Label label = new Label(colonna, riga, testo);
//			label.setCellFormat(getFormatoTesto());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//	
//	public boolean aggiungiInteger(String foglio, int colonna, int riga, Integer valore) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			Number label = new Number(colonna, riga, valore);
//			label.setCellFormat(getFormatoIntero());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//	
//	public boolean aggiungiDouble(String foglio, int colonna, int riga, Double valore) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			Number label = new Number(colonna, riga, valore);
//			label.setCellFormat(getFormatoNumero());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//	
//	public boolean aggiungiPercentuale(String foglio, int colonna, int riga, Double valore) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			Number label = new Number(colonna, riga, valore);
//			label.setCellFormat(getFormatoPercentuale());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//	
//	public boolean aggiungiValutaDueCifre(String foglio, int colonna, int riga, Double valore) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			Number label = new Number(colonna, riga, valore);
//			label.setCellFormat(getFormatoValutaDueCifre());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//	
//	public boolean aggiungiValutaTreCifre(String foglio, int colonna, int riga, Double valore) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			Number label = new Number(colonna, riga, valore);
//			label.setCellFormat(getFormatoValutaTreCifre());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//	
//	public boolean aggiungiData(String foglio, int colonna, int riga, Date data) {
//		boolean aggiungi = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			DateTime label = new DateTime(colonna, riga, data);
//			label.setCellFormat(getFormatoData());
//			aggiungi = aggiungiCella(sheet, label);
//		}
//		return aggiungi;
//	}
//
//	public boolean eliminaColonna(String foglio, int colonna) {
//		boolean remove = false;
//		WritableSheet sheet = fogliExcel.get(foglio);
//		if (sheet != null) {
//			sheet.removeColumn(colonna);
//			remove = true;
//		}
//		return remove;
//	}
	
}