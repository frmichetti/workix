package br.com.codecode.workix.tests.populate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs All Unit Tests on br.com.codecode.workix.tests.populate<br>
 * MUST ALL Lights Green
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({ PopulateUserTest.class, PopulateCandidateTest.class, PopulateCompanyTest.class, PopulateJobTest.class,
    PopulateResumeTest.class, PopulateAuthorTest.class, PopulateTestimonialTest.class })
public class TestSuitPopulateEverything {
}
