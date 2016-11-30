package br.com.codecode.workix.tests.bean;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@ManagedBean
@Named
@RequestScoped
public class Login {

    @Inject
    private FacesContext facesContext;

    private String usuario, senha, mensagem;

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getMensagem() {
	return mensagem;
    }

    public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
    }

    // faça o login da forma que achar melhor!
    public void logar() {
	String page;
	if (usuario != null && senha != null) {
	    if (usuario.equals("lala") && senha.equals("lolo")) {
		mensagem = "Bem Vindo ao Sistema " + usuario + " você está logado!";

		page = "/workix/index.xhtml?faces-redirect=true";

		try {
		    facesContext.getExternalContext().redirect(page);
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	    }
	} else {
	    mensagem = "Usuário ou senha Inválidos!";
	    page = "/error/";
	    try {
		facesContext.getExternalContext().redirect(page);
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

    }

}
