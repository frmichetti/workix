package br.com.codecode.cdi.event;

import java.time.Instant;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.codecode.cdi.notify.Notification;
import br.com.codecode.cdi.qualifier.Push;
import br.com.codecode.openjobs.model.scaffold.Candidate;


public class CandidateObserver {	
	
	@Inject @Push
	private Notification sendPush;

	public void alert(@Observes Candidate candidate){

		System.out.println("[CDI - Alert for Candidate Visited]");

		System.out.println(candidate.getName());		
		
		System.out.println(Instant.now());

		System.out.println("[-----------------------]");
		
		sendPush.doSendMessage(candidate, "Seu Perfil foi Visualizado", "Olá Seu Perfil Acabou de Ser Visualizado, Boa Sorte !");
			
	}

}
