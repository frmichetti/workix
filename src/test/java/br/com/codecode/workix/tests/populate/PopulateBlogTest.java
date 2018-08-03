/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.tests.populate;

import br.com.codecode.workix.core.enums.BlogCategory;
import br.com.codecode.workix.jpa.models.Author;
import br.com.codecode.workix.jpa.models.Blog;
import br.com.codecode.workix.jpa.models.Tag;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

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

    private List<Author> authors;

    @Before
    public void downloadAuthors() {

        System.out.println("[downloadAuthors]");

        resp = HttpTest.sendGet(server + "/authors");

        authors = getGson().fromJson(resp, new TypeToken<List<Author>>() {
        }.getType());

        assertNotNull(authors);

        assertTrue(authors.size() > 0);

    }

    @Override
    public void create() {

        posts = new ArrayList<>();

        int howManyPosts = 20;
        for (int x = 0; x < howManyPosts; x++) {

            Blog b = Blog.builder()

                    .withTitle("Postagem de Blog 'Mockup' " + x + 1)
                    .withDate(new Date())
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


        assertEquals(howManyPosts, posts.size());

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

        posts.forEach(b -> {

            System.out.println("[sendToServer] " + b.getTitle());

            resp = HttpTest.sendPost(server + "/blogs", getGson().toJson(b));

            assertNotNull(resp);

        });

    }

}
