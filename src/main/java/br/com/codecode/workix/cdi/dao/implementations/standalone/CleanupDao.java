package br.com.codecode.workix.cdi.dao.implementations.standalone;

import br.com.codecode.workix.cdi.dao.implementations.persist.BaseDao;
import br.com.codecode.workix.jpa.models.SelectiveProcess;

import java.time.LocalDateTime;
import java.util.List;

/**
 * StandAlone DAO for find Expired Selective Processes
 *
 * @author felipe
 * @version 1.0
 * @see BaseDao
 * @since 1.1
 */
public class CleanupDao extends BaseDao {


    private static final long serialVersionUID = 8313089022686190122L;

    public List<SelectiveProcess> findExpiredProcesses(LocalDateTime expire) {

        String jpql = "select p from SelectiveProcess p where p.expire <= :expire";

        return em.createQuery(jpql, SelectiveProcess.class).setParameter("expire", expire).getResultList();

    }

}
