package br.com.codecode.workix.cdi.qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.codecode.workix.cdi.dao.implementation.mockup.BaseDaoMockup;
import br.com.codecode.workix.cdi.dao.implementation.mockup.CandidateDaoMockup;
import br.com.codecode.workix.cdi.dao.implementation.mockup.CompanyDaoMockup;
import br.com.codecode.workix.cdi.dao.implementation.mockup.JobDaoMockup;
import br.com.codecode.workix.cdi.dao.implementation.mockup.ResumeDaoMockup;
import br.com.codecode.workix.cdi.dao.implementation.mockup.UserDaoMockup;

/**
 * CDI - Qualifier for Dao Instance
 * @see BaseDaoMockup
 * @see CandidateDaoMockup
 * @see CompanyDaoMockup
 * @see JobDaoMockup
 * @see ResumeDaoMockup
 * @see UserDaoMockup
 * @author felipe
 *
 */
@Qualifier
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Mockup{}
