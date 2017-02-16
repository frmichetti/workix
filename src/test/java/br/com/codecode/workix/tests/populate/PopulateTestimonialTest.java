/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.codecode.workix.jpa.models.Testimonial;
import br.com.codecode.workix.tests.funcional.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with Testimonials
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class PopulateTestimonialTest extends BaseTest implements CommonPopTest<Testimonial> {

    private List<Testimonial> testimonials;

    private String resp;    

    private int repeat = 4;

    @Before
    @Override
    public void create() {

	testimonials = new ArrayList<>();

	for (int x = 0; x < repeat; x++) {

	    Testimonial t = new Testimonial();

	    t.setName("Name Here");

	    t.setPicture("http://localhost:8080/workix/resources/placeholder/140x140.jpg");

	    t.setSignature("Signature Here");

	    t.setText("Content Here");

	    System.out.println("[create] " + t.getName());

	    addToList(t);
	}

	assertEquals(repeat, testimonials.size());

    }

    @Override
    public void addToList(Testimonial t) {

	assertNotNull(t);

	System.out.println("[addToList] " + t.getName());

	testimonials.add(t);

    }

    @Test
    @Override
    public void sendToServer() {

	testimonials.stream().forEach(t -> {

	    System.out.println("[sendToServer] " + t.getName());

	    resp = HttpTest.sendPost(server + "/testimonials", getGson().toJson(t));

	    assertNotNull(resp);

	});

    }

}
