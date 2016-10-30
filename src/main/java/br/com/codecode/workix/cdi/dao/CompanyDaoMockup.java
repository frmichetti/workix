package br.com.codecode.workix.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.model.scaffold.Company;

@Mockup
public class CompanyDaoMockup extends BasicDaoMockup implements Crud<Company> {


	private static final long serialVersionUID = 8018323736641984258L;

	@Override
	public void create(Company entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getName() + " Salvo com Sucesso!"));	
		
	}

	@Override
	public Company update(Company entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> listAll(Integer start, Integer end) {
		TypedQuery<Company> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Company c ORDER BY c.id",
				Company.class);
		if (start != null) {
			findAllQuery.setFirstResult(start);
		}
		if (end != null) {
			findAllQuery.setMaxResults(end);
		}
		return findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + Company.class.getSimpleName()).getSingleResult();
	}

	@Override
	public Company saveOrUpdate(Company entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
