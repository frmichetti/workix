package br.com.codecode.workix.cdi.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BasicDao implements Serializable{

	private static final long serialVersionUID = 3943660229318614845L;
	
	@PersistenceContext
	protected EntityManager em;
	
	
}
