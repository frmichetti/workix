/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.openjobs.tests.populate.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;

import br.com.codecode.openjobs.model.scaffold.Company;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.codecode.openjobs.tests.util.HttpConfig;


/**
 * Populate DB with Companies
 *  
 * @author felipe
 * @since 1.0
 * @version
 */
public class PopulateCompanyTest {	

	private List<Company> companies ;

	private String resp;

	@Before
	public void create() {	
		
		companies = new ArrayList<>();

		for(int x = 0 ;x < 1_000 ; x++){			

			Company c = new Company();				

			c.setName("Company Mockup N# " + String.valueOf(x+1));			
			
			c.setCnpj(String.valueOf(x+1));
			
			c.setSegment("Segment " + String.valueOf(x+1));

			System.out.println("[create] " + c.getName());

			addToList(c);

		}

		assertEquals(1_000,companies.size());


	}


	private void addToList(Company company){		
		
		assertNotNull(company);
		
		assertNotNull(companies);

		System.out.println("[addToList] " + company.getName());

		companies.add(company);		

	}

	@Test	
	public void sendToServer(){	
		
		assertNotNull(companies);

		companies.stream().forEach(c ->{			

			System.out.println("[sendToServer] " + c.getName());

			resp = Http.sendPost(HttpConfig.SCAFFOLD_PROJ + "companies",
					new GsonBuilder()						
					.create().toJson(c));

			assertNotNull(resp);
		});


	}




}
