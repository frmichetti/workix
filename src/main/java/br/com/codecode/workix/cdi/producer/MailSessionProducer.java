package br.com.codecode.workix.cdi.producer;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.mail.Session;

import br.com.codecode.workix.cdi.qualifier.Factory;
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
	
	/**
	 * Produce Session for {@link MailSender} use in CDI Injection Points 
	 * @return Session Instance for {@link MailSender} 
	 */
	@Produces
	@Dependent
	@Factory 
	@Gmail
	public Session getSession(){
		return sessionGmail;
	}
	
	

}