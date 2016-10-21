package br.com.codecode.openjobs.tests.download;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.codecode.openjobs.tests.download.gson.DownloadTestAddress;
import br.com.codecode.openjobs.tests.download.gson.DownloadTestCategory;
import br.com.codecode.openjobs.tests.download.gson.DownloadTestCheckout;
import br.com.codecode.openjobs.tests.download.gson.DownloadTestCustomer;
import br.com.codecode.openjobs.tests.download.gson.DownloadTestService;
import br.com.codecode.openjobs.tests.download.gson.DownloadTestUser;
import br.com.codecode.openjobs.tests.download.gson.DownloadTestVehicle;

@RunWith(Suite.class)
@SuiteClasses({
	DownloadTestAddress.class,
	DownloadTestCategory.class,
	DownloadTestCustomer.class,
	DownloadTestService.class,
	DownloadTestUser.class,	
	DownloadTestVehicle.class,
	DownloadTestCheckout.class})
public class TestSuiteDownloadEverything {

}
