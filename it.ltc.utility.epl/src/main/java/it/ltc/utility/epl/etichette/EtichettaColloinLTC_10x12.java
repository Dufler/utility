package it.ltc.utility.epl.etichette;

import it.ltc.utility.epl.elementi.Barcode;
import it.ltc.utility.epl.elementi.Elemento;
import it.ltc.utility.epl.elementi.FontMinSize;
import it.ltc.utility.epl.elementi.LineaOrizzontale;
import it.ltc.utility.epl.elementi.TitoloRidimensionabile;
import it.ltc.utility.epl.parametri.BARCODETYPE;
import it.ltc.utility.epl.parametri.FONTTYPE;
import it.ltc.utility.epl.parametri.READABLE;
import it.ltc.utility.epl.parametri.REVERSE;
import it.ltc.utility.epl.parametri.ROTATION;


public class EtichettaColloinLTC_10x12 extends EtichettaColloInLTC {

	public EtichettaColloinLTC_10x12(int h, int w) {
		super(h, w);
	}
	
	public void EtichettaColloinLTC_10x12Init() {
		ROTATION orientation = ROTATION.NORMAL;
		int w = this.getW();
		w = w-10;
		
		int initX = 40;
		int initXTgl = 580;
		int initXQta = 700;
		
		FontMinSize fontFix = new FontMinSize(3,1,2);
		FontMinSize fontMinDescr = new FontMinSize(2,1,1);
		FontMinSize fontMinCliente = new FontMinSize(2,1,2);
		
		Elemento barcode = new Barcode(50, 100, 70, 4, numCollo, orientation, BARCODETYPE.CODE128_AUTO, READABLE.NO);
		Elemento ragsocCliente = new TitoloRidimensionabile(initX, 20, 0, w-initX, FONTTYPE.DIM_10x16, 1, 2, 
				cliente, orientation, REVERSE.NORMAL, fontMinCliente);
		Elemento ddtCarico = new TitoloRidimensionabile(initX, 55, 0, w-initX, FONTTYPE.DIM_10x16, 1, 2, 
				packing, orientation, REVERSE.NORMAL);
		addElemento(barcode);
		addElemento(ragsocCliente);
		addElemento(ddtCarico);
		
		Elemento intestazioneArt = new TitoloRidimensionabile(initX, 200, 0, w, FONTTYPE.DIM_10x16,	 1, 1, "Cod. Articolo", orientation, REVERSE.NORMAL);
		Elemento intestazioneTgl = new TitoloRidimensionabile(initXTgl, 200, 0, w, FONTTYPE.DIM_10x16,	 1, 1, "Taglia", orientation, REVERSE.NORMAL);
		Elemento intestazioneQta = new TitoloRidimensionabile(initXQta, 200, 0, w, FONTTYPE.DIM_10x16,	 1, 1, "Q.ta", orientation, REVERSE.NORMAL);
		Elemento intestazioneLinea = new LineaOrizzontale(20, 220, 2, 770);
		addElemento(intestazioneArt);
		addElemento(intestazioneTgl);
		addElemento(intestazioneQta);
		addElemento(intestazioneLinea);
		
		int count = 0;
		for(ProdottoEtichetta prodotto : articoli) {
			
			if (count == 7) {
				break;
			}
			int offset = 80 * count;
			 
			Elemento art = new TitoloRidimensionabile(initX, 230+offset, 0, initXTgl-initX, FONTTYPE.DIM_10x16, 1, 1, prodotto.codiceArticolo, orientation, REVERSE.NORMAL, fontFix);
			Elemento tgl = new TitoloRidimensionabile(initXTgl, 230+offset, 0, initXQta-initXTgl, FONTTYPE.DIM_10x16, 1, 1, prodotto.taglia, orientation, REVERSE.NORMAL, fontFix);
			Elemento qta = new TitoloRidimensionabile(initXQta, 230+offset, 0, w-initXQta, FONTTYPE.DIM_10x16, 1, 1, prodotto.quantita, orientation, REVERSE.NORMAL, fontFix);
			
			Elemento descr = new TitoloRidimensionabile(initX, 280+offset, 0, w-initX, FONTTYPE.DIM_10x16, 1, 1, prodotto.descrizione + " " + prodotto.colore, orientation, REVERSE.NORMAL, fontMinDescr);
			Elemento lArt = new LineaOrizzontale(20, 300+offset, 1, 770);
			addElemento(art);
			addElemento(tgl);
			addElemento(qta);
			addElemento(descr);
			addElemento(lArt);
			
			count++;
		}

		Elemento ubicazione = new TitoloRidimensionabile(initX, 820, 0, w-initX, FONTTYPE.DIM_12x20, 2, 2, 
				ubicazionepProposta, orientation, REVERSE.NORMAL, fontMinDescr);
		Elemento totQta = new TitoloRidimensionabile(initXTgl, 820, 0, w-initXTgl, FONTTYPE.DIM_12x20, 1, 2, 
				"tot.", orientation, REVERSE.NORMAL, fontMinDescr);
		Elemento totale = new TitoloRidimensionabile(initXQta, 820, 0, w-initXTgl, FONTTYPE.DIM_12x20, 2, 2, 
				quantitaTot, orientation, REVERSE.NORMAL, fontMinDescr);
		Elemento numeroCollo = new TitoloRidimensionabile(20, 870, 0, 960, FONTTYPE.DIM_14x24, 4, 5, 
				numCollo, orientation, REVERSE.NORMAL, fontMinDescr);
		addElemento(ubicazione);
		addElemento(totQta);
		addElemento(totale);
		addElemento(numeroCollo);
		
		
	}

}
