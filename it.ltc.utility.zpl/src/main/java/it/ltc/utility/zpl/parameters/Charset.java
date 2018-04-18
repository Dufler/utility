package it.ltc.utility.zpl.parameters;

/**
 * CAHRSET definisce gli insiemi di caratteri utilizzabili per la codifica internazionale.
 * @author Antonio 23 ago 2017
 *
 */
public enum Charset {

	
	SINGLEBYTE_USA1(0),
	SINGLEBYTE_USA2(1),
	SINGLEBYTE_UK(2),
	SINGLEBYTE_HOLLAND(3),
	SINGLEBYTE_DENNOR(4),
	SINGLEBYTE_SWEFIN(5),
	SINGLEBYTE_GER(6),
	SINGLEBYTE_FRA1(7),
	SINGLEBYTE_FRA2(8),
	/**
	 * Charset di Default
	 */
	SINGLEBYTE_ITA(9),
	SINGLEBYTE_SPA(10),
	SINGLEBYTE_MISCELLANEOUS(11),
	SINGLEBYTE_JAP(12),
	ZEBRA850(13),
	DOUBLEBYTE_ASIAN(14),
	SHIFT_JIS(15),
	EUC_JPCN(16),
	/**
	 * Charset utilizzato per TitoloFontName 
	 */
	UCS2_BIGENDIAN(17),
	SINGLEBYTE_ASIAN(24),
	MULTIBYTE_ASIAN(26),
	ZEBRA1252(27),
	UTF8(28),
	UTF16_BIGENDIAN(29),
	UTF16_LITTLEENDIAN(30),
	ZEBRA1250(31),
	ZEBRA1251(33),
	ZEBRA1253(34),
	ZEBRA1254(35),
	ZEBRA1255(36);
	
	
	private final int value;
	private Charset(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
