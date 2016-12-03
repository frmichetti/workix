package br.com.codecode.workix.tests.json.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DownloadTestCompany.class, DownloadTestUser.class, DownloadTestCandidate.class, })
public class TestSuiteDownloadEverything {
}
