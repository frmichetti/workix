package br.com.codecode.workix.tests.json.parse;

import br.com.codecode.workix.jpa.models.Resume;
import br.com.codecode.workix.tests.android.BaseTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
