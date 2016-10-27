/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.util;

import java.net.MalformedURLException;
import java.net.URL;

import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Job;


public class MailBodyBuilder {

	private static final String LOCAL_SERVER = "http://localhost:8080/jobs";

//	private static final String REMOTE_SERVER = "http://powerofjava.frmichetti.rhcloud.com";	

	public static String makeBodyForNewCheckout(Job job) {

		StringBuilder mailBody = new StringBuilder();

		try {

			mailBody.append(ReadFile.readFileFromURL(
					new URL(LOCAL_SERVER + "/mail/email_template_nova_compra.html")));

			String result = mailBody.toString();

			mailBody = new StringBuilder();

			/*mailBody.append(result.replace("varUsuario", 
					job.getCand().getName()).replace("varCarrinho", 
							checkout.getShoppingCart()).replace("varCodigo", checkout.getUuid()));*/

			return mailBody.toString();


		} catch (MalformedURLException e) {

			System.err.println("URL do Template Incorreta " + e);

			mailBody.append("Reserva Solicitada com Sucesso, Código de checkout ")
			.append(job.getId());

			return mailBody.toString();

		}		

	}

	public static String makeBodyForNewUser(Candidate candidate) {

		StringBuilder mailBody = new StringBuilder();	

		try {

			mailBody.append(ReadFile.readFileFromURL(
					new URL(LOCAL_SERVER + "/mail/email_template_bem_vindo.html")));

			String result = mailBody.toString();

			mailBody = new StringBuilder();
			
			result = result.replace("varNome", candidate.getName());
			
			result = result.replace("varUsuario", candidate.getUser().getEmail());

			mailBody.append(result);	

			return mailBody.toString();


		} catch (MalformedURLException e) {

			System.err.println("URL do Template Incorreta " + e);

			mailBody.append("Olá ").append(candidate.getUser().getEmail()).append("<br />")
			.append(", Seja Bem Vindo e Aproveite Nossos Serviços");

			return mailBody.toString();

		}


	}
}