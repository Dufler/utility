package it.ltc.utility.miscellanea.string.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation da inserire su un field di un oggetto in modo da mappare la sua posizione e il suo tipo nella riga di testo da parsare.
 * @author Damiano
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Campo {

	int start();
	int length();
	TipoCampo type() default TipoCampo.STRINGA;
	int decimals() default 2;
	String dateFormat() default "dd/MM/yyyy";
	String defaultValue() default "";
	boolean useDefaultValueOnError() default false;
	boolean useDefaultValueIfEmpty() default false;
	
}
