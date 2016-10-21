package br.com.codecode.openjobs.tests.populate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.codecode.openjobs.tests.populate.gson.PopulateAddressTest;
import br.com.codecode.openjobs.tests.populate.gson.PopulateCategoryTest;
import br.com.codecode.openjobs.tests.populate.gson.PopulateCheckout;
import br.com.codecode.openjobs.tests.populate.gson.PopulateCustomer;
import br.com.codecode.openjobs.tests.populate.gson.PopulateServiceTest;
import br.com.codecode.openjobs.tests.populate.gson.PopulateUserTest;
import br.com.codecode.openjobs.tests.populate.gson.PopulateVehicleTest;

@RunWith(Suite.class)
@SuiteClasses({	
	PopulateCategoryTest.class,
	PopulateServiceTest.class,	
	PopulateVehicleTest.class,
	PopulateUserTest.class,	
	PopulateCustomer.class,	
	PopulateAddressTest.class,
	PopulateCheckout.class
})
public class TestSuitPopulateEverything {}
