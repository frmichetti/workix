package br.com.codecode.workix.cdi.qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.codecode.workix.cdi.producer.EntityManagerProducer;

/**
 * CDI Qualifier for Persistence Unit
 * @see EntityManagerProducer
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Qualifier
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Development{}
