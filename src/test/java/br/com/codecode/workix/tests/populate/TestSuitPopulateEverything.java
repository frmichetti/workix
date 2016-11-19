package br.com.codecode.workix.tests.populate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({	
	PopulateUserTest.class,	
	PopulateCandidateTest.class,	
	PopulateCompanyTest.class,	
	PopulateJobTest.class,
	PopulateResume.class
})
public class TestSuitPopulateEverything {}
