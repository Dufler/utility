package it.ltc.utility.epl.etichette;

import it.ltc.utility.epl.elementi.Barcode;
import it.ltc.utility.epl.elementi.Elemento;
import it.ltc.utility.epl.elementi.FontMinSize;
import it.ltc.utility.epl.elementi.TitoloRidimensionabile;
import it.ltc.utility.epl.parametri.BARCODETYPE;
import it.ltc.utility.epl.parametri.FONTTYPE;
import it.ltc.utility.epl.parametri.REVERSE;
import it.ltc.utility.epl.parametri.ROTATION;

/**
 * Calsse che mappa l'etichetta di imballo dimensione 10x12 (800x960)dots
 * @author Antonio 07 set 2017
 *
 */
public class EtichettaImballo_10x12 extends EtichettaImballo {

	public EtichettaImballo_10x12(int h, int w) {
		super(h, w);
	}
	
	public void EtichettaImballo_10x12Init() {
		ROTATION orientation = ROTATION.ROTATED90;
		int w = this.getW();
		
		int initY = 20;
		
		Elemento barcode = new Barcode(250, 450, 100, 4, numeroCollo, orientation, BARCODETYPE.CODE128_AUTO);
		addElemento(barcode);
		
		FontMinSize fontMin = new FontMinSize(1, 2, 2);
		Elemento ragsocCli = new TitoloRidimensionabile(790, initY, 0, 750-initY, FONTTYPE.DIM_14x24, 2, 2,
				ragsocCliente, orientation, REVERSE.NORMAL, fontMin);
		addElemento(ragsocCli);
		
		Elemento progCollo = new TitoloRidimensionabile(790, 864, 0, w-864, FONTTYPE.DIM_14x24, 2, 2,
				progressivoCollo, orientation, REVERSE.NORMAL, fontMin);
		addElemento(progCollo);
		Elemento numCollo = new TitoloRidimensionabile(730, 740, 0, w-740, FONTTYPE.DIM_10x16, 2, 2,
				numeroCollo, orientation, REVERSE.NORMAL);
		addElemento(numCollo);
		
		
		Elemento indirizzoCli = new TitoloRidimensionabile(670, initY, 0, 400-initY, FONTTYPE.DIM_8x12, 1, 2, 
				indirizzoCliente, orientation, REVERSE.NORMAL);
		addElemento(indirizzoCli);
		Elemento capcittaprovCli = new TitoloRidimensionabile(640, initY, 0, 400-initY, FONTTYPE.DIM_8x12, 1, 2, 
				capcittaprovCliente, orientation, REVERSE.NORMAL);
		addElemento(capcittaprovCli);
		
		Elemento luogoPart = new TitoloRidimensionabile(730, 400, 0, 750-400, FONTTYPE.DIM_8x12, 1, 2,
				"Luogo di partenza:", orientation, REVERSE.NORMAL);
		addElemento(luogoPart);
		Elemento ragsocMitt = new TitoloRidimensionabile(700, 400, 0, 750-400, FONTTYPE.DIM_8x12, 1, 2,
				ragsocMittente, orientation, REVERSE.NORMAL);
		addElemento(ragsocMitt);
		Elemento capcittaprovMitt = new TitoloRidimensionabile(670, 400, 0, 750-400, FONTTYPE.DIM_8x12, 1, 2, 
				capcittaprovMittente, orientation, REVERSE.NORMAL);
		addElemento(capcittaprovMitt);
		Elemento opzionaliCli = new TitoloRidimensionabile(640, 400, 0, 750-400, FONTTYPE.DIM_8x12, 1, 2,
				opzionaliCliente, orientation, REVERSE.NORMAL);
		addElemento(opzionaliCli);
		
		FontMinSize fontMinDest = new FontMinSize(3, 1, 2);
		Elemento destinatario = new TitoloRidimensionabile(580, initY, 0, w-initY, FONTTYPE.DIM_8x12, 1, 2,
				"DESTINATARIO / RECIVER", orientation, REVERSE.NORMAL, fontMinDest);
		addElemento(destinatario);
		Elemento ragsocDest = new TitoloRidimensionabile(550, initY, 0, w-initY, FONTTYPE.DIM_14x24, 1, 3,
				ragsocDestinatario, orientation, REVERSE.NORMAL, fontMinDest);
		addElemento(ragsocDest);
		Elemento indirizzoDest = new TitoloRidimensionabile(480, initY, 0, w-initY, FONTTYPE.DIM_12x20, 1, 3,
				indirizzoDestinatario, orientation, REVERSE.NORMAL, fontMinDest);
		addElemento(indirizzoDest);
		Elemento capcittaprovDest = new TitoloRidimensionabile(410, initY, 0, w-initY, FONTTYPE.DIM_12x20, 1, 3,
				capcittaprovDestinatario, orientation, REVERSE.NORMAL, fontMinDest);
		addElemento(capcittaprovDest);
		Elemento nazioneDest = new TitoloRidimensionabile(350, initY, 0, w-initY, FONTTYPE.DIM_14x24, 2, 3,
				nazioneDestinatario, orientation, REVERSE.NORMAL, fontMinDest);
		addElemento(nazioneDest);
		
		Elemento corr = new TitoloRidimensionabile(280, initY, 0, 450-initY, FONTTYPE.DIM_12x20, 2, 2,
				corriere, orientation, REVERSE.NORMAL);
		addElemento(corr);
		Elemento listaOrdine = new TitoloRidimensionabile(240, initY, 0, 450-initY, FONTTYPE.DIM_10x16, 1, 2,
				"Lista: " + numeroOrdine, orientation, REVERSE.NORMAL);
		addElemento(listaOrdine);
		Elemento pesoKG = new TitoloRidimensionabile(190, initY, 0, 450-initY, FONTTYPE.DIM_10x16, 2, 2,
				"Kg. " + peso, orientation, REVERSE.NORMAL);
		addElemento(pesoKG);
		Elemento noteDest = new TitoloRidimensionabile(80, initY, 0, w-initY, FONTTYPE.DIM_14x24, 1, 3,
				"Dest: " + note, orientation, REVERSE.NORMAL);
		addElemento(noteDest);
		
	}
	

}
