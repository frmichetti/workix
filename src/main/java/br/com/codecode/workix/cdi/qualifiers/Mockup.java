package br.com.codecode.workix.cdi.qualifiers;

import br.com.codecode.workix.cdi.dao.implementations.generic.Dao;
import br.com.codecode.workix.cdi.dao.implementations.mockup.*;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * CDI - Qualifier for {@link Dao} Instance
 * 
 * @see BaseDaoMockup
 * @see CandidateDaoMockup
 * @see CompanyDaoMockup
 * @see JobDaoMockup
 * @see ResumeDaoMockup
 * @see UserDaoMockup
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Qualifier
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Mockup {
}
