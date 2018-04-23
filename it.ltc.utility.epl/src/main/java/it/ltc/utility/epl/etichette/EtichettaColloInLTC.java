package it.ltc.utility.epl.etichette;

import java.util.List;

public class EtichettaColloInLTC extends Etichetta {

	public String cliente;
	public String packing;
	
	public String barcode;

	public List<ProdottoEtichetta> articoli;
	
	public String ubicazionepProposta;
	public String quantitaTot;
	
	public String numCollo; 
	
	public EtichettaColloInLTC(int h, int w) {
		super(h, w);
	}

}
