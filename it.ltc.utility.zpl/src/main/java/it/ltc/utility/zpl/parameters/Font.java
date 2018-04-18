package it.ltc.utility.zpl.parameters;

/**
 * Identifica i vari possibili font utilizzabili.
 * Per ogni font vengono evidenziate le dimensioni in dots e millimetri alla risoluzione standard di 203 dpi.
 * Il font standard è A.
 * Per ulteriori info consultare la pagina 1286 (e seguenti) del manuale.
 * @author Damiano
 *
 */
public enum Font {
	
	/**
	 * Il font utilizzato di default nella maggior parte delle etichette perchè più scalabile.
	 */
	A(9, 5, 1, 7, KeyType.U, KeyType.L, KeyType.D),
	/**
	 * Solo UPPERCASE.
	 */
	B(11, 7, 2, 11, KeyType.U),
	C(18, 10, 2, 14, KeyType.U, KeyType.L, KeyType.D),
	D(18, 10, 2, 14, KeyType.U, KeyType.L, KeyType.D),
	/**
	 * Solo OCR-B.
	 */
	E(28, 15, 5, 23, KeyType.OCR_B),
	F(26, 13, 3, 21, KeyType.U, KeyType.L, KeyType.D),
	G(60, 40, 8, 48, KeyType.U, KeyType.L, KeyType.D),
	/**
	 * Solo OCR-A.
	 */
	H(21, 13, 6, 21, KeyType.OCR_A),
	/**
	 * Usato insieme al comando <code>^GS</code>.
	 */
	GS(24, 24, 0, 18, KeyType.SYMBOL);
	
	private final int h;
	private final int w;
	private final int intercharacter;
	private final int baseline;
	private final double height;
	private final double width;
	private final double gap;
	private final KeyType[] types;
	
	/**
	 * Costruttore di default.
	 * I parametri height, width e gap vengono calcolati a partire da h, w e ic passati in base alla risoluzione di 203 dpi.
	 * @param h
	 * @param w
	 * @param ic
	 * @param b
	 * @param t
	 */
	private Font(int h, int w, int ic, int b, KeyType... t) {
		this.h = h;
		this.w = w;
		this.intercharacter = ic;
		this.baseline = b;
		this.types = t;
		this.height = (h / 203) * 2.54;
		this.width = (w / 203) * 2.54;
		this.gap = (ic / 203) * 2.54;
	}
	
	public int calcolaLarghezza(String s, int multiplier) {
		int length = s.length();
		int characterLength = w * length * multiplier;
		int spaceLength = length > 0 ? intercharacter * (length - 1) * multiplier : 0;
		return characterLength + spaceLength;
	}
	
	public int calcolaAltezza(String s, int multiplier) {
		int size; 
		if (s == null || s.isEmpty())
			size = 0;
		else
			size = h * multiplier;
		return size;
	}
	
	public double calcolaLarghezzaInMillimetri(String s,int multiplier) {
		int length = s.length();
		double characterLength = width * length * multiplier;
		double spaceLength = gap * (length - 1) * multiplier;
		return characterLength + spaceLength;
	}
	
	public double calcolaAltezzaInMillimetri(String s, int multiplier) {
		double size = height * multiplier;
		return size;
	}

	public int getH() {
		return h;
	}

	public int getW() {
		return w;
	}
	
	public int getBaseline() {
		return baseline;
	}

	public KeyType[] getTypes() {
		return types;
	}

}
