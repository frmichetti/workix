package br.com.codecode.workix.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.qualifier.Persist;
import br.com.codecode.workix.model.scaffold.Company;

/**
 * DAO for Company
 */

@Persist
public class CompanyDao extends BasicDao implements Crud<Company> {	

	private static final long serialVersionUID = -6997728484075279219L;

	@Override
	public void create(Company entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(Long id) {
		Company entity = em.find(Company.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Company findById(Long id) {
		return em.find(Company.class, id);
	}

	@Override
	public Company update(Company entity) {
		return em.merge(entity);
	}

	@Override
	public List<Company> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Company> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Company c ORDER BY c.id",
				Company.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM Company").getSingleResult();
	}
}
