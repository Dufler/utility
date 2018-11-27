package it.ltc.utility.microsoft.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import it.ltc.utility.csv.FileCSV;

public class XLStoCSV {
	
	private static final Logger logger = Logger.getLogger(XLStoCSV.class);
	
	public static final String DEFAULT_SEPARATOR = ";";
	public static final String DEFAULT_NEW_LINE = "\r\n";
	public static final String DEFAULT_NUMERIC_FORMAT = "#0.###";
	public static final char DEFAULT_NUMERIC_SEPARATOR = '.';
	
	public static FileCSV getCSV(File inputFile) {
		FileCSV csv = null;
		// Get the workbook object for XLS file
		try (HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile))) {
			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell;
			Row row;

			String[] nomiColonne;
			
			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			
			//Preparo le variabili necessarie
			HashMap<String, Integer> mappaColonne = new HashMap<>();
			String intestazione;
			ArrayList<String[]> righe = new ArrayList<>();
			
			//Prima riga, prendo i nomi delle colonne
			if (rowIterator.hasNext()) {
				
				StringBuilder sb = new StringBuilder();
				
				row = rowIterator.next();
				nomiColonne = new String[row.getPhysicalNumberOfCells()];
				Iterator<Cell> titleCellIterator = row.cellIterator();
				int titleIndex = 0;
				while (titleCellIterator.hasNext()) {
					cell = titleCellIterator.next();
					String nomeColonna = formatString(cell.getStringCellValue()).toUpperCase().trim();
					nomiColonne[titleIndex] = nomeColonna;
					
					sb.append(nomeColonna);
					sb.append(FileCSV.DEFAULT_CSV_SEPARATOR);
					mappaColonne.put(nomeColonna, titleIndex);
					
					titleIndex += 1;
				}
				
				sb.substring(0, sb.length() - 1); //tolgo l'ultima virgola.
				intestazione = sb.toString();
				
				//Proseguo su tutte le righe con i dati
				while (rowIterator.hasNext()) {
					row = rowIterator.next();
					String[] riga = new String[nomiColonne.length];
					// For each row, iterate through each columns
					for (int index = 0; index < nomiColonne.length; index++) {
						cell = row.getCell(index);
						if (cell == null) {
							//Sperimentale, serve a non saltare nessuna cella.
							riga[index] = "";
						} else switch (cell.getCellTypeEnum()) {
							case BOOLEAN: 
							{
								logger.debug("boolean?");
								riga[index] = Boolean.toString(cell.getBooleanCellValue());
							}
							break;
							case BLANK:
							{
								logger.debug("cella vuota?");
								riga[index] = "";
							}
							break;
							case NUMERIC: 
							{
								double d = cell.getNumericCellValue();
								riga[index] = Double.toString(d);
							} break;
							case STRING: 
							{
								String s = formatString(cell.getStringCellValue());
								riga[index] = s;
							} break;
							default:
							{
								//Sperimentale, serve a non saltare nessuna cella.
								String s = cell != null? cell.toString() : "cella null";
								riga[index] = s;
							} break;
						}
					}
					righe.add(riga);
				}				
				csv = new FileCSV(mappaColonne, intestazione, righe);
			} else {
				nomiColonne = null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csv;
	}
	
	public static void copyToCSV(File inputFile, File outputFile) {
		copyToCSV(inputFile, outputFile, DEFAULT_SEPARATOR, DEFAULT_NEW_LINE);
	}
	
	public static void copyToCSV(File inputFile, File outputFile, String separator, String newLine) {
		try (HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile))) {
			
			//Formattatori
			DecimalFormat df = new DecimalFormat(DEFAULT_NUMERIC_FORMAT);
			DecimalFormatSymbols dfs = new DecimalFormatSymbols();
			dfs.setDecimalSeparator(DEFAULT_NUMERIC_SEPARATOR);
			df.setDecimalFormatSymbols(dfs);
			
			StringBuilder data = new StringBuilder();
			
			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell;
			Row row;

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();
					switch (cell.getCellTypeEnum()) {
						case BOOLEAN: { data.append(cell.getBooleanCellValue()); } break;
						case NUMERIC: { data.append(df.format(cell.getNumericCellValue())); } break;
						case STRING: { data.append(formatString(cell.getStringCellValue())); } break;
						case BLANK: { data.append(""); } break;
						default: data.append(cell.toString()); break;
					}
					data.append(separator);
				}
				data.append(newLine);
			}

			//Vado in scrittura
			FileOutputStream fos = new FileOutputStream(outputFile);
			fos.write(data.toString().getBytes());
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String formatString(String s) {
		s = s.replace("\n", " ");
		return s;
	}
}
