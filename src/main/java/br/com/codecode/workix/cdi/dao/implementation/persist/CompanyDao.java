package br.com.codecode.workix.cdi.dao.implementation.persist;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Persist;
import br.com.codecode.workix.model.scaffold.Company;

/**
 * DAO for Company
 */
@Persist
public class CompanyDao extends BaseDao implements Crud<Company> {	

	private static final long serialVersionUID = -6997728484075279219L;

	@Override
	public void save(Company entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(long id) {
		Company entity = em.find(Company.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Company findById(long id) {
		return em.find(Company.class, id);
	}

	@Override
	public Company update(Company entity) {
		return em.merge(entity);
	}

	@Override
	public List<Company> listAll(int startPosition, int maxResult) {

		TypedQuery<Company> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Company c ORDER BY c.id",
				Company.class);

		findAllQuery.setFirstResult(startPosition);

		findAllQuery.setMaxResults(maxResult);

		return findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + Company.class.getSimpleName()).getSingleResult();
	}

	@Override
	public Company saveOrUpdate(Company entity) {

		if (entity == null){
			throw new IllegalArgumentException("One valid Entity is required to persist");		

		}

		if(entity.getId() == 0){

			em.persist(entity);

		}else

		{
			em.merge(entity);

		}

		return entity;

	}

	@Override
	public Company findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
