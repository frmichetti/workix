package br.com.codecode.workix.cdi.qualifiers;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.producers.JmsDestinationProducer;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * CDI Qualifier for {@link JmsDestinationProducer}
 *
 * @author felipe
 * @version 1.1
 * @see Notification
 * @since 1.0
 */
@Qualifier
@Target({METHOD, PARAMETER, FIELD})
@Retention(RUNTIME)
@Documented
public @interface JobTopic {
}
