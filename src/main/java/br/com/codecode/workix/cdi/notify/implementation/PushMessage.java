/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.notify.implementation;

import java.io.Serializable;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.interfaces.Notificable;
import br.com.codecode.workix.util.Http;

/**
 * Push Message Implementation<br>
 * Send a Text Message to Firebase
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Push
public class PushMessage implements Notification, Serializable {

	private static final long serialVersionUID = 7123778177220320094L;

	private final String FCM_SERVER = "https://fcm.googleapis.com/fcm/send";

	@Inject
	private Http http;

	public PushMessage() {
		System.out.println("[Creating instance of " + this.getClass().getSimpleName() +"]");
	}

	@Override
	public void doSendMessage(Notificable to,String title, String body){

		JsonObject jsonObject = Json.createObjectBuilder()
				.add("to", to.getFirebaseMessageToken())
				.add("notification", Json.createObjectBuilder()
						.add("body", body)
						.add("title", title)
						.add("icon", "myicon")
						.build())
				.build();				

		String json = jsonObject.toString() ;

		System.out.println(json);		
		
		//TODO FIXME TESTME Test this
		ClientBuilder.newClient().target(FCM_SERVER)
			.request(MediaType.APPLICATION_JSON).post(Entity.json(json));		
		
		//TODO UPDATE TO JAX2 Binding
		String resp = http.sendPost(FCM_SERVER, json);

		System.out.println(resp);

	}



}
