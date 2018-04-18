package it.ltc.utility.zpl.etichette.ltc;

import it.ltc.utility.zpl.etichette.Etichetta;
import it.ltc.utility.zpl.parameters.Orientation;

/**
 * Classe che estende la classe Etichetta, definisce i campi utilizzati
 * nell'etichetta LTC di ingresso merce.
 * <edit>
 * Sono stati aggiunti controlli sul numero massimo di articoli stampabili sull'etichetta.
 * - Damiano
 * </edit>
 * @author Antonio 30 ago 2017
 *
 */
public abstract class EtichettaColloInLTC extends Etichetta {
	
	public static final int MAX_ARTICOLI = 6;

	protected final String cliente;
	protected final String packing;
	protected final String barcode;

	protected final ProdottoEtichetta[] articoli;

	protected final String ubicazioneProposta;
	protected final int quantitaTotale;
	protected final Integer totaleComplessivo;

	protected final String numeroCollo;

	public EtichettaColloInLTC(int h, int w, Orientation orientation, String cliente, String packing, String barcode, String ubicazione, String numeroCollo, ProdottoEtichetta[] prodotti, Integer totaleComplessivo) {
		super(h, w, orientation);
		//Controllo sul numero massimo di prodotti stampabili
		if (prodotti.length > MAX_ARTICOLI)
			throw new IllegalArgumentException("Un etichetta può contenere al massimo " + MAX_ARTICOLI);
		//Copio la lista di prodotti
		this.articoli = prodotti.clone();
		//Calcolo la quantita' totale
		int quantita = 0;
		for (ProdottoEtichetta prodotto : articoli)
			if (prodotto != null)
				quantita += prodotto.getQuantita();
		//Copio il resto delle informazioni
		this.quantitaTotale = quantita;
		this.cliente = checkStringValue(cliente);
		this.packing = checkStringValue(packing);
		this.barcode = checkStringValue(barcode);
		this.ubicazioneProposta = checkStringValue(ubicazione);
		this.numeroCollo = checkStringValue(numeroCollo);
		this.totaleComplessivo = totaleComplessivo;
	}
	
	private String checkStringValue(String value) {
		if (value == null)
			value = "";
		return value;
	}

}
