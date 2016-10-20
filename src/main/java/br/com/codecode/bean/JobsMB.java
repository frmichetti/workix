package br.com.codecode.bean;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.codecode.dao.JobDao;
import br.com.codecode.jsf.util.PaginationHelper;
import br.com.codecode.model.scaffold.Job;

@Model
public class JobsMB {
	
	private PaginationHelper pagination;
	
	private int selectedItemIndex;
	
	private DataModel dtmdl = null;
	
	@PersistenceContext
    private EntityManager em;
	
	@Inject
	private JobDao dao;
	
	private Collection<Job> joblist;
	
	private String prefix,sufix;
	
	public JobsMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		joblist = dao.listAll(0, Integer.MAX_VALUE);
		prefix = "/jobs";
		sufix = "&faces-redirect=true";
	}

	public Collection<Job> getJoblist() {
		return joblist;
	}
	
	public String goToJobDetail(Job job){
		
		System.out.println("Received Job " + job.toString());
		
		return prefix + "/job-details.xhtml?id=" + String.valueOf(job.getId()) + sufix ;
	}
	
	
	
	 public List<Job> getAllItems() {
	        StringBuilder queryText = new StringBuilder("SELECT Job FROM Job as job ORDER BY job.title");
	        TypedQuery<Job> query = em.createQuery(queryText.toString(), Job.class);
	        List<Job> allItems = query.getResultList();
	        return allItems;
	    }
	    public int count() {
	        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	        javax.persistence.criteria.Root<Job> rt = cq.from(Job.class);
	        cq.select(em.getCriteriaBuilder().count(rt));
	        javax.persistence.Query q = em.createQuery(cq);
	        return ((Long) q.getSingleResult()).intValue();
	    }
	  
	   public List<Job> findRange(int[] range) {
	        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	        cq.select(cq.from(Job.class));
	        javax.persistence.Query q = em.createQuery(cq);
	        q.setMaxResults(range[1] - range[0]);
	        q.setFirstResult(range[0]);
	        return q.getResultList();
	    }
	
	

}
