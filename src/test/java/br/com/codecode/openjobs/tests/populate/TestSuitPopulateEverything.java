package br.com.codecode.openjobs.tests.populate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.codecode.openjobs.tests.populate.gson.PopulateCompanyTest;
import br.com.codecode.openjobs.tests.populate.gson.PopulateCandidateTest;
import br.com.codecode.openjobs.tests.populate.gson.PopulateUserTest;

@RunWith(Suite.class)
@SuiteClasses({	
	PopulateUserTest.class,	
	PopulateCandidateTest.class,	
	PopulateCompanyTest.class,	
})
public class TestSuitPopulateEverything {}
