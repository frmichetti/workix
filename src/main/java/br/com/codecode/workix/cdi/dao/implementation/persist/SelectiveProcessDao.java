package br.com.codecode.workix.cdi.dao.implementation.persist;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Persist;
import br.com.codecode.workix.model.scaffold.SelectiveProcess;

/**
 * DAO for Selective Process
 */
@Persist
public class SelectiveProcessDao extends BaseDao implements Crud<SelectiveProcess> {

	private static final long serialVersionUID = 5942334208981147237L;

	@Override
	public void save(SelectiveProcess entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(long id) {
		SelectiveProcess entity = em.find(SelectiveProcess.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public SelectiveProcess findById(long id) {
		return em.find(SelectiveProcess.class, id);
	}

	@Override
	public SelectiveProcess update(SelectiveProcess entity) {
		return em.merge(entity);
	}

	@Override
	public List<SelectiveProcess> listAll(int startPosition,
			int maxResult) {

		TypedQuery<SelectiveProcess> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SelectiveProcess s LEFT JOIN FETCH s.job LEFT JOIN FETCH s.employeer LEFT JOIN FETCH s.candidates ORDER BY s.id",
						SelectiveProcess.class);

		findAllQuery.setFirstResult(startPosition);

		findAllQuery.setMaxResults(maxResult);

		return findAllQuery.getResultList();
	}

	@Override
	public BigInteger countRegisters() {		
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + SelectiveProcess.class.getSimpleName()).getSingleResult();
	}

	@Override
	public SelectiveProcess saveOrUpdate(SelectiveProcess entity) {

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
	public SelectiveProcess findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
