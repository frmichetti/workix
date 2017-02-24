/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate.compat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.core.enums.BlogCategory;
import br.com.codecode.workix.jpa.models.compat.Author;
import br.com.codecode.workix.jpa.models.compat.Blog;
import br.com.codecode.workix.jpa.models.compat.Tag;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.populate.CommonPopTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with Blog Posts
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public class PopulateBlogTest extends BaseTest implements CommonPopTest<Blog> {

    private List<Blog> posts;

    private String resp;    
    
    private int howManyPosts = 20;
    
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

	posts = new ArrayList<>();	
	
	for (int x = 0; x < howManyPosts; x++) {
	    
	    Blog b = Blog.builder()	    
	    
	    .withTitle("Postagem de Blog 'Mockup' " + x+1)	    
	    .withDate(Calendar.getInstance())	    
	    .withContent("Conteúdo Aqui ")
	    .withCitation("Citação Aqui ")
	    .withBlogCategory(BlogCategory.JOBS)
	    .withAuthor(authors.get(x))
	    .build();
	    
	    b.addTag(Tag.builder().withName("Etiqueta 1").build());
	    
	    b.addTag(Tag.builder().withName("Etiqueta 2").build());
	    
	    b.addPicture("http://localhost:8080/workix/resources/placeholder/800x530.jpg");   
	    
	    
	    for (int i = 0; i < 7; i++) {
		b.setContent(b.getContent().concat(b.getContent()));
	    }
	    
	    b.setResume("Resumo Aqui ");
	    
	    for (int i = 0; i < 5; i++) {
		b.setResume(b.getResume().concat(b.getResume()));
	    }    


	    System.out.println("[create] " + b.getTitle());

	    addToList(b);
	    
	}       
	

	assertEquals(howManyPosts , posts.size());

    }

    @Override
    public void addToList(Blog b) {

	assertNotNull(b);

	System.out.println("[addToList] " + b.getTitle());

	posts.add(b);

    }

    @Test
    @Override
    public void sendToServer() {
	
	create();

	posts.stream().forEach(b -> {

	    System.out.println("[sendToServer] " + b.getTitle());

	    resp = HttpTest.sendPost(server + "/blogs", getGson().toJson(b));

	    assertNotNull(resp);

	});

    }

}
