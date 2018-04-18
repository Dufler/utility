package it.ltc.utility.zpl.elements;

/**
 * Classe che mappa l'elemento specifico Logo TNT.
 * Include tutti i comandi necessari per la stampa.
 * @author Antonio 24 ago 2017
 *
 */
public class LogoTNT extends Elemento {
	
	private final Ellisse ellisse1;
	private final Ellisse ellisse2;
	private final Ellisse ellisse3;
	
	private final Testo lettera1;
	private final Testo lettera2;
	private final Testo lettera3;
	
	public LogoTNT(int x, int y, int h, int w) {
		super(x, y, h, w);
		
		int ticknessDefalut = 4; 
		int tickness = (ticknessDefalut * h) / 43; // 4 : 43 = t : h
		int ellisseDist = h - (tickness -1);
		
		ellisse1 = new Ellisse(x, y, h, h, tickness);
		ellisse2 = new Ellisse(x, y+(ellisseDist), h, h, tickness);
		ellisse3 = new Ellisse(x, y+(2*ellisseDist), h, h, tickness);
		
		// 32 : x = 46 : xtesto
		// 57 : y = 68 : ytesto
		int xTesto = (x*46)/32;
		int yTesto = (y*68)/57;
		int size = (h * 34) / 46; //34 : 46 = x : h
		lettera1 = new Testo(xTesto, yTesto, size, size, "T");
		lettera2 = new Testo(xTesto, yTesto + (h), size, size, "N");
		lettera3 = new Testo(xTesto, yTesto + (2*h), size, size, "T");
	}
	
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		value.append(ellisse1);
		value.append(ellisse2);
		value.append(ellisse3);
		value.append(lettera1);
		value.append(lettera2);
		value.append(lettera3);
		return value.toString();
	}
	
//	/**
//	 * Metodo che permette di formattare il logo in base ai paramentri passati in input.
//	 * @return la stringa che identifica il logo.
//	 */
//	private String LogoTNTFormat()
//	{
//		int ticknessDefalut = 4; 
//		int tickness = (ticknessDefalut * h) / 43; // 4 : 43 = t : h
//		int ellisseDist = h - (tickness -1);
//		
//		Ellisse ellisse1 = new Ellisse(x, y, h, h, tickness);
//		Ellisse ellisse2 = new Ellisse(x, y+(ellisseDist), h, h, tickness);
//		Ellisse ellisse3 = new Ellisse(x, y+(2*ellisseDist), h, h, tickness);
//		
//		// 32 : x = 46 : xtesto
//		// 57 : y = 68 : ytesto
//		int xTesto = (x*46)/32;
//		int yTesto = (y*68)/57;
//		int size = (h * 34) / 46; //34 : 46 = x : h
//		Testo lettera1 = new Testo(xTesto, yTesto, size, size, "T");
//		Testo lettera2 = new Testo(xTesto, yTesto + (h), size, size, "N");
//		Testo lettera3 = new Testo(xTesto, yTesto + (2*h), size, size, "T");
//		
//		return ellisse1.toString() + ellisse2.toString() + ellisse3.toString() + lettera1.toString() + lettera2.toString() + lettera3.toString();
//	}
	
//	@Override
//	public String toString() {
////		String value = "^FO32,57^GE46,46,4^FS" + CRLF +
////					   "^FO32,100^GE46,46,4^FS" + CRLF +
////					   "^FO32,143^GE46,46,4^FS" + CRLF +
////					   "^FT68,92^A0B,34,48^FDT^FS" + CRLF +
////					   "^FT68,138^A0B,34,48^FDN^FS" + CRLF +
////					   "^FT68,179^A0B,34,45^FDT^FS";
//		
//		String value = LogoTNTFormat();
//
//		return value;
//	}
}
