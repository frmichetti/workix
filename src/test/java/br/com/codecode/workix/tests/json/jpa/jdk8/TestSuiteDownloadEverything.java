package br.com.codecode.workix.tests.json.jpa.jdk8;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
    DownloadTestCompany.class, 
    DownloadTestUser.class, 
    DownloadTestCandidate.class, 
    DownloadTestJob.class,
    DownloadTestResume.class,
    DownloadTestSelectiveProccess.class})
public class TestSuiteDownloadEverything {
}
