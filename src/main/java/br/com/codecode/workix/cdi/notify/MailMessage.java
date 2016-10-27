/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.notify;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.codecode.workix.cdi.qualifier.Email;
import br.com.codecode.workix.infra.MailSender;
import br.com.codecode.workix.model.scaffold.Candidate;


@Email
public class MailMessage implements Notification, Serializable {	

	private static final long serialVersionUID = -8429438521984628827L;

	private final String FROM = "frmichetti@gmail.com";
	
	@Inject
	private MailSender mailSender;

	public MailMessage() {
		System.out.println("[Creating instance of " + this.getClass().getSimpleName() +"]");
	}
		
	
	@Override
	public void doSendMessage(Candidate to, String title, String body) {

		mailSender.send(FROM,to.getUser().getEmail(), title, body);

	}



}
