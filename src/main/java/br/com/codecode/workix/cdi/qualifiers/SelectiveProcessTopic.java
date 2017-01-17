package br.com.codecode.workix.cdi.qualifiers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.producers.JmsDestinationProducer;

/**
 * CDI Qualifier for {@link JmsDestinationProducer}
 * 
 * @see Notification
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Qualifier
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface SelectiveProcessTopic {
}
