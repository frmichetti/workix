package br.com.codecode.openjobs.tests.download;

import br.com.codecode.openjobs.tests.util.HttpConfig;

public interface DownloadTest {
	
	String server = HttpConfig.JAVAEE_PROJ_PROD;
	
	void downloadItens();
	
	void parseItens();

}
