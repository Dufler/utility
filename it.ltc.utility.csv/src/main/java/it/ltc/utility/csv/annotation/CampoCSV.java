package it.ltc.utility.csv.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation da inserire su un field di un oggetto in modo da mappare la sua posizione e il suo tipo nella riga del file csv da parsare.
 * @author Damiano
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CampoCSV {
	
	/**
	 * Indica se il campo è opzionale o meno (default falso)
	 */
	boolean optional() default false;
	
	/**
	 * Indica il nome del campo come appare nella colonna csv (non è case sensitive)
	 */
	String name();
	
	/**
	 * Indica la posizione del campo, viene usato solo durante l'esportazione.
	 */
	int position();
	
	TipoCampo type() default TipoCampo.STRINGA;
	int decimals() default 2;
	String dateFormat() default "dd/MM/yyyy";
	String defaultValue() default "";
	boolean useDefaultValueOnError() default false;
	boolean useDefaultValueIfEmpty() default false;

}
