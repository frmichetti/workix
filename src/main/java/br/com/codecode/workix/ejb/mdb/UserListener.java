/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.ejb.mdb;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifiers.Email;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Push;
import br.com.codecode.workix.jpa.models.User;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenBean;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.time.Instant;

/**
 * This Class is a {@link MessageDrivenBean} for {@link User} Execute Actions
 * {@link #onMessage(Message)}
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topics/usersTopic") })
final class UserListener implements MessageListener {

    @Inject
    @Factory
    private ManagedExecutorService managedExecutorService;

    @Inject
    @Email
    private Notification sendMail;

    @Inject
    @Push
    private Notification sendPush;

    public UserListener() {
    }

    @Override
    public void onMessage(Message message) {

	System.out.println("[MDB - onMessage]");

	TextMessage text = (TextMessage) message;

	System.out.println("Received Message -> " + text);

	try {

	    String uuid = text.getText();

	    managedExecutorService.execute(() -> {

		System.out.println("TODO SEND A MAIL TO USER " + Instant.now());

		System.out.println("UUID " + uuid);

	    });

	} catch (JMSException e) {

	    System.err.println("---Error on Read Message---");

	    e.printStackTrace();

	}

    }

}
