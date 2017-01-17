package br.com.codecode.workix.cdi.qualifiers;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.codecode.workix.cdi.dao.implementations.generic.Dao;
import br.com.codecode.workix.cdi.dao.implementations.mockup.BaseDaoMockup;
import br.com.codecode.workix.cdi.dao.implementations.mockup.CandidateDaoMockup;
import br.com.codecode.workix.cdi.dao.implementations.mockup.CompanyDaoMockup;
import br.com.codecode.workix.cdi.dao.implementations.mockup.JobDaoMockup;
import br.com.codecode.workix.cdi.dao.implementations.mockup.ResumeDaoMockup;
import br.com.codecode.workix.cdi.dao.implementations.mockup.UserDaoMockup;

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
