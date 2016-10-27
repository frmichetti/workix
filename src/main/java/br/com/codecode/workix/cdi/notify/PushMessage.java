/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.notify;

import java.io.Serializable;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

import br.com.codecode.workix.cdi.qualifier.Push;
import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.util.Http;


@Push
public class PushMessage implements Notification, Serializable{

	private static final long serialVersionUID = 7123778177220320094L;

	private final String FCM_SERVER = "https://fcm.googleapis.com/fcm/send";

	@Inject
	private Http http;

	public PushMessage() {
		System.out.println("[Creating instance of " + this.getClass().getSimpleName() +"]");
	}

	@Override
	public void doSendMessage(Candidate to,String title, String body){

		JsonObject jsonObject = Json.createObjectBuilder()
				.add("to", to.getUser().getFirebaseMessageToken())
				.add("notification", Json.createObjectBuilder()
						.add("body", body).add("title", title)
						.add("icon", "myicon")
						.build())
				.build();				

		String json = jsonObject.toString() ;

		System.out.println(json);

		String resp = http.sendPost(FCM_SERVER, json);

		System.out.println(resp);

	}



}
