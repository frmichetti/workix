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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.GsonBuilder;

import br.com.codecode.openjobs.tests.populate.PopulateTest;
import br.com.codecode.openjobs.tests.util.Http;
import br.com.frmichetti.carhollics.core.model.compatibility.Service;
/**
 * Populate DB with Services
 *  
 * @author felipe
 * @since 1.0
 * @version
 */
public class PopulateServiceTest implements PopulateTest {

	private Service s1,s2,s3,s4,s5,s6,s7,s8,s9 ;

	private List<Service> services ;
	
	private String resp ;

	@Test
	@Override
	public void create() {
		
		System.out.println("[create]");

		s1 = new Service();

		s1.setTitle("Troca de óleo lubrificante");
		
		s1.setPrice(new BigDecimal(169));

		s1.setDuration(180);
		
		s1.setDescription("A troca do óleo completa (que inclui filtro do óleo e ar do motor) lubrifica e higieniza o motor do seu carro.");
	
		s1.setObservation("* Já inclui filtro do óleo e filtro de ar do motor");

		assertNotNull(s1);

		s2 = new Service();

		s2.setTitle("Lavagem Ecológica");
		
		s2.setPrice(new BigDecimal(40));

		s2.setDuration(120);
		
		s2.setDescription("Seu carro limpo por dentro e por fora com apenas um copo d'àgua.");
		
		s2.setObservation("");

		assertNotNull(s2);

		s3 = new Service();

		s3.setTitle("Enceramento");

		s3.setPrice(new BigDecimal(79));

		s3.setDuration(120);
		
		s3.setDescription("Camada de proteção e brilho que faz sua lavagem durar até 3 vezes mais.");
		
		s3.setObservation("* Já inclui Lavagem Ecológica.");

		assertNotNull(s3);

		s4 = new Service();

		s4.setTitle("Polimento");
		
		s4.setPrice(new BigDecimal(269));

		s4.setDuration(240);
		
		s4.setDescription("Remova manchas e riscos sem danificar a pintura de seu veículo.");
		
		s4.setObservation("* Já inclui Lavagem Ecológica e Enceramento.");

		assertNotNull(s4);

		s5 = new Service();

		s5.setTitle("Higienização de Ar Condicionado");
		
		s5.setPrice(new BigDecimal(50));

		s5.setDuration(60);
		
		s5.setDescription("Limpeza do sistema de circulação de ar, proteção contra fungos, bactérias, mofo e odores indesejados.");
				
		s5.setObservation("");

		assertNotNull(s5);

		s6 = new Service();

		s6.setTitle("Higienização Interna");
		
		s6.setPrice(new BigDecimal(230));

		s6.setDuration(180);
		
		s6.setDescription("Limpeza profunda do interior do veículo, remoção de fungos e bactérias.");
		
		s6.setObservation("");

		assertNotNull(s6);

		s7 = new Service();
		
		s7.setTitle("Hidratação do Couro");

		s7.setPrice(new BigDecimal(150));

		s7.setDuration(120);

		s7.setDescription("Cria uma película protetora sobre o couro, hidratando e evitando rachaduras e ressecamentos.");

		s7.setObservation("");

		assertNotNull(s7);

		s8 = new Service();

		s8.setTitle("Cristalização de Vidros");
		
		s8.setPrice(new BigDecimal(50));

		s8.setDuration(60);

		s8.setDescription("Garanta visibilidade em dias de chuva e evite a fixação de impurezas.");

		s8.setObservation("");

		assertNotNull(s8);

		s9 = new Service();

		s9.setTitle("Limpeza Técnica de Motor");

		s9.setPrice(new BigDecimal(140));

		s9.setDuration(120);

		s9.setDescription("Prolonga a vida útil do motor, além de hidratar as borrachas e plásticos.");

		s9.setObservation("");

		assertNotNull(s9);

	}

	@Test
	@Override
	public void addToList() {
		
		create();
		
		System.out.println("[addToList]");		
		
		services = new ArrayList<>();				

		services.add(s1);

		services.add(s2);

		services.add(s3);

		services.add(s4);

		services.add(s5);

		services.add(s6);

		services.add(s7);

		services.add(s8);

		services.add(s9);

		assertNotNull(services);

		assertEquals(9,services.size());	

	}

	@Test
	@Override
	public void sendToServer() {

		addToList();	
		
		System.out.println("[sendToServer]");		
		
		services.stream().forEach(s ->{
							
				resp = Http.sendPost(server + "services",						
						new GsonBuilder()						
						.create().toJson(s));						
			
			System.out.println("Sending to Server");						

			assertNotNull(resp);
		});

		

	}

}
