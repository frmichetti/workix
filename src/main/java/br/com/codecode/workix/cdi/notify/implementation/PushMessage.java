/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.notify.implementation;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifiers.Push;
import br.com.codecode.workix.interfaces.Debugable;
import br.com.codecode.workix.interfaces.Notificable;
import br.com.codecode.workix.util.Http;

/**
 * Push Message Implementation<br>
 * Send a Text Message to Firebase
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Debugable
 */
@Push
public class PushMessage implements Notification, Debugable {

    private final String FCM_SERVER = "https://fcm.googleapis.com/fcm/send";

    private final String WEB_API_KEY = "AIzaSyDF7Uc_yoj_VAOx-7fzag92DLTfyca88aE";

    // TODO FIXME REMOVEME
    @Inject
    private Http http;

    @PostConstruct
    private void init() {
	Debugable.super.onStart();
    }

    @Override
    public void doSendMessage(Notificable to, String title, String body) {

	JsonObject jsonObject = Json.createObjectBuilder().add("to", to.getFirebaseMessageToken())
		.add("notification",
			Json.createObjectBuilder().add("body", body).add("title", title).add("icon", "myicon").build())
		.build();

	String json = jsonObject.toString();

	System.out.println(json);

	try {

	    /*
	     * //TODO FIXME TESTME Test this javax.ws.rs.core.Response r =
	     * ClientBuilder.newClient().target(FCM_SERVER)
	     * .property("Authorization", "key="+ WEB_API_KEY)
	     * .request(MediaType.APPLICATION_JSON).post(Entity.json(json));
	     */

	    // TODO FIXME REMOVEME
	    String resp = http.sendPost(FCM_SERVER, json);

	    System.out.println(resp);

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
