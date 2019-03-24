package br.com.codecode.workix.tests.json.parse.jdk7;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.jdk7.Resume;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.json.parse.DownloadTest;

public class DownloadTestResume extends BaseTest implements DownloadTest<Resume> {

    private String resp;

    @Before    
    public void downloadItens() {

	resp = downloadItens(server + "/resumes");

	assertFalse(resp.isEmpty());

    }

    @Test    
    public void parseItens() {	

	List<Resume> resumes = parseItens(resp, new TypeToken<List<Resume>>(){});

	assertNotNull(resumes);

	assertTrue(resumes.size() > 0);

	System.out.println("----Stream----");

	resumes.stream()	
		.forEach(System.out::println);

	System.out.println("----Stream----");

    }

}