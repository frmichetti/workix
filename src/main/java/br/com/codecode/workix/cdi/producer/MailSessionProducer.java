package br.com.codecode.workix.cdi.producer;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.mail.Session;

import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.Fake;
import br.com.codecode.workix.cdi.qualifier.Gmail;
import br.com.codecode.workix.infra.MailSender;

/**
 * Mail Session Producer
 * @author felipe
 *
 */
@ApplicationScoped
public class MailSessionProducer {
	
	@Resource(mappedName="java:jboss/mail/gmail")
	private Session sessionGmail;
	
	@Resource(mappedName="java:jboss/mail/fake")
	private Session sessionFake;
	
	/**
	 * Produces Session for {@link MailSender} use in CDI Injection Points 
	 * @return Session Instance for {@link MailSender} 
	 */
	@Produces
	@Dependent
	@Factory 
	@Gmail
	public Session getSessionGmail(){
		return sessionGmail;
	}
	
	/**
	 * Produces Session for {@link MailSender} use in CDI Injection Points 
	 * @return Session Instance for {@link MailSender} 
	 */
	@Produces
	@Dependent
	@Factory 
	@Fake
	public Session getSessionFake(){
		return sessionFake;
	}
	
	

}
