/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.mail;

import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.util.ReadFile;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This Class Construct Email Body from a Template TODO FIXME
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class MailBodyBuilder {

    @Inject
    @Factory
    @Default
    private FacesContext facesContext;

    private String server, templatePath;

    public MailBodyBuilder() throws NotImplementedYetException {
	throw new NotImplementedYetException();
    }

    @PostConstruct
    private void init() {
	server = facesContext.getExternalContext().getApplicationContextPath();
    }

    public String makeBodyForNew(Job job) {

	StringBuilder mailBody = new StringBuilder();

	try {

	    mailBody.append(ReadFile.readFileFromURL(new URL(server + templatePath)));

	    String result = mailBody.toString();

	    mailBody = new StringBuilder();

	    /*
	     * mailBody.append(result.replace("varUsuario",
	     * job.getCand().getName()).replace("varCarrinho",
	     * checkout.getShoppingCart()).replace("varCodigo",
	     * checkout.getUuid()));
	     */

	    return mailBody.toString();

	} catch (MalformedURLException e) {

	    System.err.println("URL do Template Incorreta " + e);

	    mailBody.append("Reserva Solicitada com Sucesso, Código de checkout ").append(job.getId());

	    return mailBody.toString();

	}

    }

    public String makeBodyForNew(Candidate candidate) {

	StringBuilder mailBody = new StringBuilder();

	try {

	    mailBody.append(ReadFile.readFileFromURL(new URL(server + templatePath)));

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