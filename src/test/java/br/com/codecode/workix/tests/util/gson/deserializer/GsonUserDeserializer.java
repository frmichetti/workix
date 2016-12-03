package br.com.codecode.workix.tests.util.gson.deserializer;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import br.com.codecode.workix.core.models.jdk7.root.BaseUser;
import br.com.codecode.workix.tests.model.jdk7.User;

public class GsonUserDeserializer implements JsonDeserializer<BaseUser> {

    @Override
    public BaseUser deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	    throws JsonParseException {

	JsonObject obj = json.getAsJsonObject();

	Set<Entry<String, JsonElement>> en = obj.entrySet();

	en.forEach(System.out::println);

	System.out.println(en.stream().filter(e -> e.getKey().equals("active")).count());

	/**
	 * Active Field
	 */
	boolean active = false;
	try {
	    active = obj.get("active").getAsBoolean();
	} catch (Exception e2) {
	    // TODO: handle exception
	}

	/**
	 * Email Field
	 */
	String email = null;
	try {
	    email = obj.get("email").getAsString();
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	/**
	 * Firebase UUID Field
	 */
	String firebaseUUID = null;
	try {
	    firebaseUUID = obj.get("firebaseUUID").getAsString();
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	/**
	 * Firebase Message Token Field
	 */
	String firebaseMessageToken = null;
	try {
	    firebaseMessageToken = obj.get("firebaseMessageToken").getAsString();
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	/**
	 * Id Field
	 */
	long id = 0;
	try {
	    id = obj.get("id").getAsLong();
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	/**
	 * Version Field
	 */
	int version = 0;
	try {
	    version = obj.get("version").getAsInt();
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	/**
	 * UUID Field
	 */
	String uuid = null;
	try {
	    uuid = obj.get("uuid").getAsString();
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	/**
	 * Created at Field
	 */
	Calendar createdAt = null;
	try {
	    createdAt = Calendar.getInstance();
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	/**
	 * Updated at Field
	 */
	Calendar updatedAt = null;
	try {
	    updatedAt = Calendar.getInstance();
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	User u = new User();

	u.setActive(active);

	u.setEmail(email);

	u.setFirebaseMessageToken(firebaseMessageToken);

	u.setFirebaseUUID(firebaseUUID);

	u.setId(id);

	u.setCreatedAt(createdAt);

	u.setUpdatedAt(updatedAt);

	u.setVersion(version);

	u.setUuid(uuid);

	return u;
    }

}
