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
import br.com.codecode.workix.cdi.qualifier.Development;
import br.com.codecode.workix.cdi.qualifier.OpenShift;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = -1826763804778726145L;
	
	@PersistenceUnit(unitName = "ProdDS")
	private EntityManagerFactory emfProd;
	
	@PersistenceUnit(unitName = "DevDS")
	private EntityManagerFactory emfDev;
	
	@PersistenceUnit(unitName = "MySQLDS")
	private EntityManagerFactory emfOpenShift;	
	
	@Produces
	@RequestScoped
	@Production	
	public EntityManager getProdEntityManager() {
		return emfProd.createEntityManager();
	}
	
	@Produces
	@RequestScoped
	@Development	
	public EntityManager getDevEntityManager() {
		return emfDev.createEntityManager();
	}	
	
	@Produces
	@RequestScoped
	@OpenShift	
	public EntityManager getOpenShiftEntityManager() {
		return emfOpenShift.createEntityManager();
	}	

	@Produces
	@RequestScoped	
	@Default
	public EntityManager getDefaultEntityManager() {
		
		System.out.println("INIT PARAM >> " + getInitParam());

		EntityManagerFactory emf = null;

		if (getInitParam().equals("Production")){	
			
			emf = emfProd;

		}else if (getInitParam().equals("Development")){
			
			emf = emfDev;

		}else{
			throw new RuntimeException("Init Param is NULL or Undefined");
		}
		
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}
	
	/**
	 * FIXME GET WEBINF PARAM
	 * @return
	 */
	private String getInitParam(){
		
		return "Development";
	}
}
