package br.com.codecode.workix.cdi.qualifiers;

import br.com.codecode.workix.cdi.producers.EntityManagerProducer;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * CDI Qualifier for Persistence Unit
 *
 * @author felipe
 * @version 1.1
 * @see EntityManagerProducer
 * @since 1.0
 */
@Qualifier
@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Documented
public @interface Persist {
}
