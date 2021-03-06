package br.com.codecode.workix.cdi.event;

import java.time.Instant;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifiers.Push;
import br.com.codecode.workix.jpa.models.Candidate;

/**
 * CDI Observer Class for {@link Candidate}
 * 
 * @see Observes
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class CandidateObserver {

    @Inject
    @Push
    private Notification sendPush;

    /**
     * Execute an Action on Event as FiredUp
     * 
     * @param candidate
     *            Observer for Candidate Events
     */
    public void alert(@Observes Candidate candidate) {

	System.out.println("[CDI - Alert for Candidate Visited]");

	System.out.println(candidate.getName());

	System.out.println(Instant.now());

	System.out.println("[-----------------------]");

	sendPush.doSendMessage(candidate.getUser(), "Seu Perfil foi Visualizado",
		"Olá Seu Perfil Acabou de Ser Visualizado, Boa Sorte !");

    }

}
