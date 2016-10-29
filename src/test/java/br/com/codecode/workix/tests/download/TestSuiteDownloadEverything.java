package br.com.codecode.workix.tests.download;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.codecode.workix.tests.download.gson.DownloadTestCandidate;
import br.com.codecode.workix.tests.download.gson.DownloadTestCompany;
import br.com.codecode.workix.tests.download.gson.DownloadTestUser;

@RunWith(Suite.class)
@SuiteClasses({	
	DownloadTestCompany.class,	
	DownloadTestUser.class,
	DownloadTestCandidate.class,
	})
public class TestSuiteDownloadEverything {

}
