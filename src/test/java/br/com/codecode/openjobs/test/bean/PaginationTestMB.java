package br.com.codecode.openjobs.test.bean;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.jsf.util.PaginationHelper;
import br.com.codecode.openjobs.model.scaffold.Job;

@Model
public class PaginationTestMB {
	
	@Inject
	private Crud<Job> dao;

	private Collection<Job> joblist;
	
	@PostConstruct
	private void init(){
		joblist = dao.listAll(0, Integer.MAX_VALUE);		
	}
	
	/******************************** PAGINATION ****************************************/

	private PaginationHelper pagination;
	
	private int selectedItemIndex;

	private DataModel<Job> dtmdl = null; 

	@PersistenceContext
	private EntityManager em;

	public PaginationHelper getPagination() {

		if (pagination == null) {

			pagination = new PaginationHelper(10) {
				@Override
				public int getItemsCount() {
					return joblist.size();
				}

				@Override
				public DataModel<Job> createPageDataModel() {

					return new ListDataModel<Job>(findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
				}
			};
		}
		return pagination;
	}

	public DataModel<Job> getdtmdl() {

		if (dtmdl == null) {
			dtmdl = getPagination().createPageDataModel();
		}

		return dtmdl;
	}
	private void recreateModel() {
		dtmdl = null;
	}

	private void recreatePagination() {
		pagination = null;
	}

	private void updateCurrentItem() {

		Job item ;

		int count = joblist.size();

		if (selectedItemIndex >= count) {

			// selected index cannot be bigger than number of items:
			selectedItemIndex = count - 1;

			// go to previous page if last page disappeared:
			if (pagination.getPageFirstItem() >= count) {

				pagination.previousPage();
			}
		}
		if (selectedItemIndex >= 0) {
			item = findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
		}
	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "pagination.xhtml";
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "pagination.xhtml";
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
