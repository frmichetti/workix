package br.com.codecode.workix.cdi.dao.implementations.persist;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.jpa.models.SelectiveProcess;

import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.List;

/**
 * DAO for Selective Process
 * 
 * @since 1.0
 * @version 1.0
 * @see BaseDao
 * @see Crud
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
    public List<SelectiveProcess> listAll(int startPosition, int maxResult) {

	TypedQuery<SelectiveProcess> findAllQuery = em.createQuery(
		"SELECT DISTINCT s FROM SelectiveProcess s LEFT JOIN FETCH s.job LEFT JOIN FETCH s.employeer LEFT JOIN FETCH s.candidates ORDER BY s.id",
		SelectiveProcess.class);

	findAllQuery.setFirstResult(startPosition);

	findAllQuery.setMaxResults(maxResult);

	return findAllQuery.getResultList();
    }

    @Override
    public BigInteger countRegisters() {
	return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + SelectiveProcess.class.getSimpleName())
		.getSingleResult();
    }

    @Override
    public SelectiveProcess findByUuid(String uuid) {
	// TODO Auto-generated method stub
	return null;
    }

}
