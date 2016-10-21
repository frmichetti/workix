package br.com.codecode.openjobs.tests.download;

import br.com.codecode.openjobs.tests.util.HttpConfig;

public interface DownloadTest {
	
	String server = HttpConfig.SCAFFOLD_PROJ;
	
	void downloadItens();
	
	void parseItens();

}
