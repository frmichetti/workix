package br.com.codecode.workix.tests.util.gson.deserializer;

import java.lang.reflect.Type;
import java.util.Calendar;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import br.com.codecode.workix.core.models.jdk7.root.BaseUser;
import br.com.codecode.workix.tests.model.jdk7.User;
import br.com.codecode.workix.tests.util.gson.GsonProvider;

public class GsonUserDeserializer implements JsonDeserializer<BaseUser> {

    @Override
    public BaseUser deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	    throws JsonParseException {

	JsonObject obj = json.getAsJsonObject();	

	/**
	 * Active Field
	 */
	boolean active = (obj.has("active")) && (!obj.get("active").isJsonNull()) ? obj.get("active").getAsBoolean() : false;
	

	/**
	 * Email Field
	 */
	String email = (obj.has("email")) && (!obj.get("email").isJsonNull()) ? obj.get("email").getAsString() : "";
	

	/**
	 * Firebase UUID Field
	 */
	String firebaseUUID = (obj.has("firebaseUUID")) && (!obj.get("firebaseUUID").isJsonNull()) ? obj.get("firebaseUUID").getAsString() : "";
	

	/**
	 * Firebase Message Token Field
	 */
	String firebaseMessageToken = (obj.has("firebaseMessageToken")) && (!obj.get("firebaseMessageToken").isJsonNull()) ? obj.get("firebaseMessageToken").getAsString() : "";
	

	/**
	 * Id Field
	 */
	long id = (obj.has("id")) && (!obj.get("id").isJsonNull()) ? obj.get("id").getAsLong() : 0;

	/**
	 * Version Field
	 */
	int version = (obj.has("version")) && (!obj.get("version").isJsonNull()) ? obj.get("version").getAsInt() : 0;

	/**
	 * UUID Field
	 */
	String uuid = (obj.has("uuid")) && (!obj.get("uuid").isJsonNull()) ? obj.get("uuid").getAsString() : "";

	/**
	 * Created at Field
	 */
	Calendar createdAt = GsonProvider.buildGson().fromJson(obj.get("createdAt"), Calendar.class);

	/**
	 * Updated at Field
	 */
	Calendar updatedAt = GsonProvider.buildGson().fromJson(obj.get("updatedAt"), Calendar.class);

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
