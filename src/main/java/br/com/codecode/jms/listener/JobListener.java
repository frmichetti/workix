/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.jms.listener;

import java.time.Instant;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.com.codecode.cdi.notify.Notification;
import br.com.codecode.cdi.qualifier.Email;
import br.com.codecode.cdi.qualifier.Push;


@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName="destinationLookup",
				propertyValue="java:/jms/topics/jobsTopic")})
public class JobListener implements MessageListener{	

	@Resource(name = "java:comp/DefaultManagedExecutorService")
	private ManagedExecutorService managedExecutorService;

	@Inject @Email
	private Notification sendMail;

	@Inject @Push
	private Notification sendPush;

	public JobListener(){}

	@Override	
	public void onMessage(Message message) {

		System.out.println("[MDB - onMessage]");

		TextMessage text = (TextMessage) message;		

		System.out.println("Received Message -> " + text);

		String uuid = "";

		try {

			uuid = text.getText();

			managedExecutorService.submit(() ->{

				System.out.println("TODO SEND A MAIL TO USER " + Instant.now());

			});

		} catch (JMSException e) {

			System.err.println("---Error on Read Message---");

			e.printStackTrace();

		}
	}

}
