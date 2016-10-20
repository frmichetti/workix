/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.util;

import java.net.MalformedURLException;
import java.net.URL;

import br.com.codecode.openjobs.model.scaffold.Candidate;
import br.com.codecode.openjobs.model.scaffold.Job;


public class MailBodyBuilder {

	private static final String LOCAL_SERVER = "http://localhost:8080/carhollics-javaee";

//	private static final String REMOTE_SERVER = "http://callcenter-carhollics.rhcloud.com";	

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
			.append(job.getUuid());

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