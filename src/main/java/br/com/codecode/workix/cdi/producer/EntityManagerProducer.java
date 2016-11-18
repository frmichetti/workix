package br.com.codecode.workix.cdi.producer;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import br.com.codecode.workix.cdi.qualifier.Production;
import br.com.codecode.workix.cdi.qualifier.Test;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = -1826763804778726145L;
	
	@PersistenceUnit(unitName = "ProductionDS")
	private EntityManagerFactory emfProduction;
	
	@PersistenceUnit(unitName = "TestDS")
	private EntityManagerFactory emfTest;
	
	@PersistenceUnit(unitName = "DefaultPU")
	private EntityManagerFactory emfDefault;
	
	@Produces
	@RequestScoped
	@Production	
	public EntityManager getProductionEntityManager() {
		return emfProduction.createEntityManager();
	}
	
	@Produces
	@RequestScoped
	@Test	
	public EntityManager getTestEntityManager() {
		return emfTest.createEntityManager();
	}	

	@Produces
	@RequestScoped	
	@Default
	public EntityManager getDefaultEntityManager() {
		return emfDefault.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}
}
