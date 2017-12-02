/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.notify.implementation;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifiers.Email;
import br.com.codecode.workix.interfaces.Debugable;
import br.com.codecode.workix.interfaces.Notificable;
import br.com.codecode.workix.mail.MailSender;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Email Message Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Debugable
 */
@Email
public class MailMessage implements Notification, Debugable {

    @Inject
    private MailSender mailSender;

    @PostConstruct
    private void init() {
	Debugable.super.onStart();
    }

    @Override
    public void doSendMessage(Notificable to, String title, String body) {

        String FROM = "frmichetti@gmail.com";
        mailSender.send(FROM, to.getEmail(), title, body);

    }

}
