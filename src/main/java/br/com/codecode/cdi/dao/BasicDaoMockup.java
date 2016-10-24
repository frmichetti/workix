package br.com.codecode.cdi.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.codecode.jsf.util.MessagesHelper;

public class BasicDaoMockup implements Serializable {

	private static final long serialVersionUID = -4533114503790241039L;
	
	protected static final String TITLE = "MOCKUP";
	
	@Inject
	protected MessagesHelper messagesHelper;
	

	@PersistenceContext
	protected EntityManager em;

}
