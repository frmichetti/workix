package br.com.codecode.workix.cdi.dao.implementations.persist;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.jpa.models.User;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.List;

/**
 * DAO for Job
 *
 * @version 1.0
 * @see BaseDao
 * @see Crud
 * @since 1.0
 */
@Persist
public class UserDao extends BaseDao implements Crud<User> {


    private static final long serialVersionUID = 4029639665489024760L;

    @Inject
    private Event<User> alertNewUser;

    @Override
    public void save(User entity) {

        em.persist(entity);

        alertNewUser.fire(entity);

    }

    @Override
    public void deleteById(long id) {
        User entity = em.find(User.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User update(User entity) {
        return em.merge(entity);
    }

    @Override
    public List<User> listAll(int startPosition, int maxResult) {

        TypedQuery<User> findAllQuery = em.createQuery("SELECT DISTINCT u FROM User u ORDER BY u.id", User.class);

        findAllQuery.setFirstResult(startPosition);

        findAllQuery.setMaxResults(maxResult);

        return findAllQuery.getResultList();
    }

    @Override
    public BigInteger countRegisters() {

        return (BigInteger) em.createNativeQuery("SELECT count(1) FROM " + User.class.getSimpleName())
                .getSingleResult();
    }

    @Override
    public User findByUuid(String uuid) {
        // TODO Auto-generated method stub
        return null;
    }

}
