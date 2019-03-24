package br.com.codecode.workix.cdi.event;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.UserTopic;
import br.com.codecode.workix.jpa.models.User;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSProducer;
import java.time.Instant;

/**
 * CDI Observer Class for User
 *
 * @author felipe
 * @version 1.0
 * @see Observes
 * @since 1.0
 */
class UserObserver {

    @Inject
    @Factory
    private JMSProducer jmsProducer;

    @Inject
    @Factory
    @UserTopic
    private Destination destination;

    /**
     * Execute an Action on Event as FiredUp
     *
     * @param user Observer for User Events
     */
    public void alert(@Observes User user) {

        System.out.println("[CDI - Alert for new User]");

        System.out.println(user.getEmail());

        System.out.println(Instant.now());

        System.out.println("[-----------------------]");

        jmsProducer.send(destination, user.getUuid());

    }

}
