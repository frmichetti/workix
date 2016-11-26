/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.notify.implementation;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Email;
import br.com.codecode.workix.infra.MailSender;
import br.com.codecode.workix.interfaces.Debugable;
import br.com.codecode.workix.interfaces.Notificable;

/**
 * Email Message Implementation
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Debugable
 */
@Email
public class MailMessage implements Notification, Debugable {	

	private final String FROM = "frmichetti@gmail.com";
	
	@Inject
	private MailSender mailSender;

	@PostConstruct
	private void init(){
		Debugable.super.onStart();
	}		
	
	@Override
	public void doSendMessage(Notificable to, String title, String body) {

		mailSender.send(FROM,to.getEmail(), title, body);

	}



}
