package it.ltc.utility.csv.annotation;

import java.util.Comparator;

/**
 * Semplice ordinatore che ordina i campi in base all'indice della posizione (se dichiarata) o al nome.
 * @author Damiano
 *
 */
public class OrdinatoreCampi implements Comparator<CampoCSV> {

	@Override
	public int compare(CampoCSV o1, CampoCSV o2) {
		Integer c1 = o1.position();
		Integer c2 = o2.position();
		int compare = c1.compareTo(c2);
		if (compare == 0) {
			String n1 = o1.name() != null ? o1.name() : "";
			String n2 = o2.name() != null ? o2.name() : "";
			compare = n1.compareTo(n2);
		}
		return compare;
	}

}
