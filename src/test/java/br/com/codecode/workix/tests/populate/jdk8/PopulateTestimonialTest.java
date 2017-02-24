/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate.jdk8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.jpa.models.jdk8.Author;
import br.com.codecode.workix.jpa.models.jdk8.Testimonial;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.populate.CommonPopTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with Testimonials
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public class PopulateTestimonialTest extends BaseTest implements CommonPopTest<Testimonial> {

    private List<Testimonial> testimonials;

    private String resp;    

    private int repeat = 30;

    private List<Author> authors;
    
    @Before
    public void downloadAuthors() {

	System.out.println("[downloadAuthors]");

	resp = HttpTest.sendGet(server + "/authors");

	authors = getGson().fromJson(resp, new TypeToken<List<Author>>(){}.getType());

	assertNotNull(authors);

	assertTrue(authors.size() > 0);

    }

    
    @Override
    public void create() {

	testimonials = new ArrayList<>();

	for (int x = 0; x < repeat; x++) {

	    Testimonial t = Testimonial.builder()

	    .withAuthor(authors.get(x))

	    .withPicture(authors.get(x).getPicture())

	    .withSignature("Assinatura Aqui")

	    .withText("Conteúdo Aqui");

	    System.out.println("[create] " + t.getAuthor().getName());

	    addToList(t);
	}

	assertEquals(repeat, testimonials.size());

    }

    @Override
    public void addToList(Testimonial t) {

	assertNotNull(t);

	System.out.println("[addToList] " + t.getAuthor().getName());

	testimonials.add(t);

    }

    @Test
    @Override
    public void sendToServer() {
	
	create();

	testimonials.stream().forEach(t -> {

	    System.out.println("[sendToServer] " + t.getAuthor().getName());

	    resp = HttpTest.sendPost(server + "/testimonials", getGson().toJson(t));

	    assertNotNull(resp);

	});

    }

}
