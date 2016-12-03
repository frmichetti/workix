/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.jaas;

import javax.ejb.Stateless;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.dao.implementations.persist.BaseDao;
import br.com.codecode.workix.jaas.model.JAASUser;

/**
 * Stand Alone DAO for JAASUser
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Stateless
public class SecurityDao extends BaseDao {

    private static final long serialVersionUID = -3575890815048830157L;

    public JAASUser loadUserByUsername(@NotEmpty String userName) {

	String jpql = "select u from JAASUser u where u.login = :login";

	JAASUser user = em.createQuery(jpql, JAASUser.class).setParameter("login", userName).getSingleResult();

	return user;
    }

}