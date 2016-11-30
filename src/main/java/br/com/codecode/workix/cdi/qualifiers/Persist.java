package br.com.codecode.workix.cdi.qualifiers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.codecode.workix.cdi.producers.EntityManagerProducer;

/**
 * CDI Qualifier for Persistence Unit
 * 
 * @see EntityManagerProducer
 * @since 1.0
 * @version 1.1
 * @author felipe
 */
@Qualifier
@Target({ TYPE, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Persist {
}
