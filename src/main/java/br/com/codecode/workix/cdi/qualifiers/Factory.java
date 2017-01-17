package br.com.codecode.workix.cdi.qualifiers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.inject.Produces;
import javax.inject.Qualifier;

/**
 * CDI Qualifier for Factory Producers
 * 
 * @see Produces
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Qualifier
@Target({ METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Factory {

}
