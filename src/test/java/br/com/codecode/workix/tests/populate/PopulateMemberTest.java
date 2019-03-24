package br.com.codecode.workix.tests.populate;

import br.com.codecode.workix.jpa.models.Member;
import br.com.codecode.workix.jpa.models.SocialMedia;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Populate DB with Members
 *
 * @author felipe
 * @version 1.0
 * @since 1.1
 */
public class PopulateMemberTest extends BaseTest implements CommonPopTest<Member> {

    private List<Member> members;

    private String resp;

    @Before
    @Override
    public void create() {

        members = new ArrayList<>();

        String pictureUrl;
        String serviceUrl;
        if (server.contains("localhost")) {
            serviceUrl = "http://localhost/resources/placeholder/140x140.jpg";
            pictureUrl = "http://localhost/resources/images/members/felipe_140_140.jpg";
        } else {
            serviceUrl = "http://www.workix.com.br/resources/placeholder/140x140.jpg";
            pictureUrl = "http://www.workix.com.br/resources/images/members/felipe_140_140.jpg";
        }

        Member felipe = Member.builder()

                .withName("FELIPE RODRIGUES MICHETTI")

                .withOccupation("Fundador e Desenvolvedor")

                .withShortText("Porque pagar por um conteúdo que você não tem certeza de sua verdade?")

                .withPicture(pictureUrl);

        felipe.addSocialMedia(SocialMedia.builder().withMedia("GitHub").withUrl("https://github.com/frmichetti").build());

        felipe.addSocialMedia(SocialMedia.builder().withMedia("Linkedin").withUrl("https://br.linkedin.com/pub/felipe-rodrigues-michetti/105/61/511").build());

        System.out.println("[create] " + felipe.getName());

        addToList(felipe);

        Member jefferson = Member.builder()

                .withName("JEFFERSON PEDROSO")

                .withOccupation("Co-Founder e CMO")

                .withShortText("Muitas idéias boas parecem loucura ou impossíveis em primeiro lugar.");

        jefferson.setPicture(serviceUrl);

        System.out.println("[create] " + jefferson.getName());

        addToList(jefferson);


        assertEquals(2, members.size());

    }

    @Override
    public void addToList(Member m) {

        assertNotNull(m);

        System.out.println("[addToList] " + m.getName());

        members.add(m);

    }

    @Test
    @Override
    public void sendToServer() {

        members.forEach(m -> {

            System.out.println("[sendToServer] " + m.getName());

            resp = HttpTest.sendPost(server + "/members", getGson().toJson(m));

            assertNotNull(resp);

        });

    }

}
