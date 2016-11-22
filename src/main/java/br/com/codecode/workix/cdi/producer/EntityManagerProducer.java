package br.com.codecode.workix.cdi.producer;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import br.com.codecode.workix.cdi.qualifier.Development;
import br.com.codecode.workix.cdi.qualifier.Factory;
import br.com.codecode.workix.cdi.qualifier.OpenShift;
import br.com.codecode.workix.cdi.qualifier.Production;

/**
 * Entity Manager Producer
 * @see {@link persistence.xml}
 * @author felipe
 *
 */
@ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = -1826763804778726145L;

	@PersistenceUnit(unitName = "ProdDS")
	private EntityManagerFactory emfProd;

	@PersistenceUnit(unitName = "DevDS")
	private EntityManagerFactory emfDev;

	@PersistenceUnit(unitName = "MySQLDS")
	private EntityManagerFactory emfOpenShift;	

	/**
	 * Produce EntityManager for CDI Injection Points 
	 * @return {@link Production} Implementation
	 */
	@Produces
	@RequestScoped
	@Factory
	@Production	
	public EntityManager getProdEntityManager() {
		return emfProd.createEntityManager();
	}

	/**
	 * Produce EntityManager for CDI Injection Points 
	 * @return {@link Development} Implementation
	 */
	@Produces
	@RequestScoped
	@Factory
	@Development	
	public EntityManager getDevEntityManager() {
		return emfDev.createEntityManager();
	}	

	/**
	 * Produce EntityManager for CDI Injection Points 
	 * @return {@link OpenShift} Implementation
	 */
	@Produces
	@RequestScoped
	@Factory
	@OpenShift	
	public EntityManager getOpenShiftEntityManager() {
		return emfOpenShift.createEntityManager();
	}	

	/**
	 * Produce EntityManager for CDI Injection Points based
	 * on WEB-INF/web.xml ContextParam javax.faces.PROJECT_STAGE
	 * @return {@link EntityManager}
	 */
	@Produces
	@RequestScoped	
	@Factory
	@Default
	public EntityManager getDefaultEntityManager() {

		System.out.println("INIT PARAM >> " + getContextParam());

		EntityManagerFactory emf = null;

		if (getContextParam().equals("Production")){	

			emf = emfProd;

		}else if (getContextParam().equals("Development")){

			emf = emfDev;

		}else if (getContextParam().equals("OpenShift")){

			emf = emfOpenShift;

		}else{
			throw new RuntimeException("Context Param is NULL or Undefined");
		}

		return emf.createEntityManager();
	}

	/**
	 * Closes Entity Manager when Necessary
	 * @param em
	 */
	public void close(@Disposes EntityManager em) {	
		
		if (em.isOpen()) {
			em.close();
		}
		
	}

	@Inject @Factory
	private FacesContext facesContext;

	/**
	 * Discover Project Stage Parameter to Choose Default EntityManager  
	 * @return String Representation for Entity Manager Selection
	 * @throws RuntimeException
	 */
	private String getContextParam() throws RuntimeException{

		if(facesContext != null){
			return facesContext.getExternalContext().getInitParameter("javax.faces.PROJECT_STAGE");
		}else
			throw new RuntimeException("Impossible to Discover Runtime Environment");

		
	}
}
