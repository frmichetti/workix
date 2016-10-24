package br.com.codecode.cdi.dao;

import java.math.BigInteger;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import br.com.codecode.cdi.qualifier.Mockup;
import br.com.codecode.openjobs.model.scaffold.Candidate;
import br.com.codecode.openjobs.model.scaffold.User;

@Mockup
public class CandidateDaoMockup extends BasicDaoMockup implements Crud<Candidate>{

	private static final long serialVersionUID = -405041688690426708L;

	@Inject
	private Event<Candidate> alertNewVisit;

	@Override
	public void create(Candidate entity) {
		messagesHelper.addFlash(new FacesMessage(TITLE,entity.getName() + " Salvo com Sucesso!"));		
	}

	@Override
	public Candidate update(Candidate entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Candidate findById(Long id) {

		Candidate c = em.find(Candidate.class, id);

		if(c != null){
			alertNewVisit.fire(c);
		}

		return c;
	}

	@Override
	public List<Candidate> listAll(Integer start, Integer end) {
		TypedQuery<Candidate> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Candidate c ORDER BY c.id",
				Candidate.class);

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
		return (BigInteger) em.createNativeQuery("SELECT count(1) FROM Candidate").getSingleResult();
	}

}
