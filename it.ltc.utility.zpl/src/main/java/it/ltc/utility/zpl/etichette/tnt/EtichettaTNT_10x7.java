package it.ltc.utility.zpl.etichette.tnt;

import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe che estende l'etichetta TNT, mappa l'etichetta 10x7
 * @author Antonio 24 ago 2017
 *
 */
public class EtichettaTNT_10x7 extends EtichettaTNT {
	
	public final static Orientation orientation = Orientation.ROTATED270;
	
	public EtichettaTNT_10x7(int h, int w) {
		super(h, w, orientation);
	}
	
	
//	private Barcode getBarcode(int barWidth, Double barWide, int barHeight, 
//			int positionX, int positionY, JUSTIFY justify, 
//			ORIENTATION barcodeOrientation, Integer barcodeHeight, YESNO printLineBefore, YESNO printLineAbove, String dataValue) {
//		
//		Barcode barcode = new Barcode(positionX,positionY,barHeight,0);
//		
//		barcode.setBarWidth(barWidth);
//		barcode.setBarWide(barWide);
//		barcode.setBarHeight(barcode.getH());
//		barcode.setPositionX(barcode.getX());
//		barcode.setPositionY(barcode.getY());
//		barcode.setJustify(justify);
//		barcode.setBarcodeOrientation(barcodeOrientation);
//		barcode.setBarcodeHeight(barcodeHeight);
//		barcode.setPrintLineBefore(printLineBefore);
//		barcode.setPrintLineAbove(printLineAbove);
//		barcode.setDataValue(dataValue);
//		barcode.BarcodeInit();
//		
//		return barcode;
//	}

	public void EtichettaTNT_10x7Init() {
//		Orientation orientation = Orientation.ROTATED270;
//		
//		Elemento barcode = new Barcode(3,3.0,160,
//				695,569, Justify.LEFT,
//			    orientation,
//			    null, YesNo.YES, YesNo.NO, this.barcode, true);
//		addElemento(barcode);
//		
//		Elemento logo = new LogoTNT(32, 57, 46, 0, orientation);
//		addElemento(logo);
//		
//		TitoloScalable codFilPartenza = new TitoloScalable(39, 87, 569, Justify.LEFT, codFilialePartenza, orientation, false);
//		addElemento(codFilPartenza);
//		
//		TitoloBitmapped titoloNrColli = new TitoloBitmapped(1, 569-249, 127, 569, Justify.LEFT, "COLLI: " + nrColli, orientation, false);
//		addElemento(titoloNrColli);
//		if (peso != null) {
//			TitoloBitmapped titoloPeso = new TitoloBitmapped(1, 569-249, 127, 569, Justify.LEFT, "PESO: " + peso, orientation, false);
//			addElemento(titoloPeso);
//		}
//		
//		TitoloBitmapped titoloMittente = new TitoloBitmapped(1, 569-249, 215, 569, Justify.LEFT, "MITTENTE: " + mittente, orientation, false);
//		addElemento(titoloMittente);
//		TitoloBitmapped titoloDestinatario = new TitoloBitmapped(1, 569-249, 247, 569, Justify.LEFT, destinatario, orientation, false);
//		addElemento(titoloDestinatario);
//		TitoloBitmapped titoloIndDestinatario = new TitoloBitmapped(1, 569-249, 279, 569, Justify.LEFT, indirizzoDest, orientation, false);
//		addElemento(titoloIndDestinatario);
//		TitoloBitmapped titoloLocDestinatario = new TitoloBitmapped(1, 569-249, 311, 569, Justify.LEFT, localitaDest, orientation, false);
//		addElemento(titoloLocDestinatario);
//		
//		TitoloScalable segnaCollo = new TitoloScalable(45, 381, 569, Justify.LEFT, numSegnaCollo, orientation, false);
//		addElemento(segnaCollo);
//		TitoloScalable riferimentoMitt = new TitoloScalable(23, 487, 569, Justify.LEFT, "R.C.: " + rifMittente, orientation, false);
//		addElemento(riferimentoMitt);
//		TitoloFontName codFilArrivo = new TitoloFontName(68, 391, 453, Justify.LEFT, codFilialeArrivo, orientation, Charset.UCS2_BIGENDIAN, false);
//		addElemento(codFilArrivo);
//		TitoloFontName filArrivo = new TitoloFontName(34, 435, 569, Justify.LEFT, filialeArrivo, orientation, Charset.UCS2_BIGENDIAN, false);
//		addElemento(filArrivo);
//		TitoloFontName lettVettura = new TitoloFontName(23, 207, 249, Justify.LEFT, "LDV: " + letteraVettura, orientation, Charset.UCS2_BIGENDIAN, false);
//		addElemento(lettVettura);
//		TitoloFontName dataPar = new TitoloFontName(23, 172, 249, Justify.LEFT, "Data: " + dataPartenza, orientation, Charset.UCS2_BIGENDIAN, false);
//		addElemento(dataPar);
//		
//		BoxGrafico gBox1 = new BoxGrafico(369, 71, 178, 51, 51);
//		addElemento(gBox1);
//		BoxGrafico gBox2 = new BoxGrafico(313, 131, 118, 53, 53);
//		addElemento(gBox2);
//		BoxGrafico gBox3 = new BoxGrafico(257, 121, 128, 53, 53);
//		addElemento(gBox3);
//		
//		TitoloScalable titoloHUB = new TitoloScalable(41, 409, 249, Justify.LEFT, hub, orientation, true);
//		addElemento(titoloHUB);
//		TitoloScalable titoloSPE = new TitoloScalable(43, 299, 249, Justify.LEFT, speciale, orientation, true);
//		addElemento(titoloSPE);
//		TitoloScalable titoloPremium = new TitoloScalable(43, 355, 249, Justify.LEFT, servizioPremium, orientation, true);
//		addElemento(titoloPremium);
//		
//		
//		TitoloFontName titoloMicorzona = new TitoloFontName(68, 495, 249, Justify.LEFT, micorZona, orientation, Charset.UCS2_BIGENDIAN, false);
//		addElemento(titoloMicorzona);
//		
//		TitoloBitmapped titoloDestinatario2 = new TitoloBitmapped(1, 800-272, 272, 61, Justify.LEFT, destinatario2, Orientation.NORMAL, false);
//		addElemento(titoloDestinatario2);
//		
//		TitoloBitmapped titoloCommento = new TitoloBitmapped(1, 569, 766, 569, Justify.LEFT, commento, orientation, false);
//		addElemento(titoloCommento);
		
	}
	
}
