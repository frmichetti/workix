package br.com.codecode.workix.cdi.qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;
import javax.mail.Session;

import br.com.codecode.workix.cdi.producer.MailSessionProducer;
import br.com.codecode.workix.infra.MailSender;

/**
 * CDI - Qualifier for {@link Session} Instance
 * @see MailSender
 * @see MailSessionProducer
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@Qualifier
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Gmail{}
