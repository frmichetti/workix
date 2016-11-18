package br.com.codecode.workix.cdi.dao.implementation.mockup;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.codecode.workix.jsf.util.MessagesHelper;

public class BasicDaoMockup implements Serializable {

	private static final long serialVersionUID = -4533114503790241039L;
	
	protected static final String TITLE = "MOCKUP";
	
	@Inject
	protected MessagesHelper messagesHelper;
	
	@Inject @Default
	protected EntityManager em;

}
