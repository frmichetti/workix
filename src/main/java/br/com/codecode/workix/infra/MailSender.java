/**
 *
 * @author frmichetti
 * <Felipe Rodrigues Michetti at http://www.codecode.com.br>
 * Locale frmichetti@gmail.com
 */
package br.com.codecode.workix.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.codecode.workix.cdi.qualifier.Gmail;

/**
 * This Class Prepare and Send a Email
 * @author felipe
 *
 */
@ApplicationScoped
public class MailSender {

	@Inject @Gmail
	private Session session;	

	/**
	 * Send Mail Message
	 * @param from
	 * @param to
	 * @param subject
	 * @param body
	 */
	public void send(String from,String to,String subject,String body){

		Message mimeMessage = new MimeMessage(session);

		try {

			mimeMessage.setRecipients(RecipientType.TO, InternetAddress.parse(to));

			mimeMessage.setFrom(new InternetAddress(from));
			
			mimeMessage.setSubject(subject);
			
			mimeMessage.setContent(body, "text/html");			
			
			Transport.send(mimeMessage);
			
		} catch (MessagingException	e) {
			throw new RuntimeException(e);
		}

	}

}
