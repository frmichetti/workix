package br.com.codecode.workix.tests.download;

import br.com.codecode.workix.tests.util.HttpConfig;

public interface DownloadTest {
	
	String server = HttpConfig.JAVAEE_PROJ_PROD;
	
	void downloadItens();
	
	void parseItens();

}
