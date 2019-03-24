package br.com.codecode.workix.cdi.qualifiers;

import br.com.codecode.workix.cdi.producers.MailSessionProducer;
import br.com.codecode.workix.mail.MailSender;

import javax.inject.Qualifier;
import javax.mail.Session;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * CDI - Qualifier for {@link Session} Instance
 *
 * @author felipe
 * @version 1.1
 * @see MailSender
 * @see MailSessionProducer
 * @since 1.0
 */
@Qualifier
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
public @interface Gmail {
}
