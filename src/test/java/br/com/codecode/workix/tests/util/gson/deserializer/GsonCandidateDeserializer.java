package br.com.codecode.workix.tests.util.gson.deserializer;

import java.lang.reflect.Type;
import java.util.Calendar;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import br.com.codecode.workix.core.models.jdk7.root.BaseCandidate;
import br.com.codecode.workix.core.models.jdk7.root.BaseContact;
import br.com.codecode.workix.core.models.jdk7.root.BaseLocale;
import br.com.codecode.workix.core.models.jdk7.root.BaseUser;
import br.com.codecode.workix.tests.model.jdk7.Candidate;
import br.com.codecode.workix.tests.model.jdk7.Contact;
import br.com.codecode.workix.tests.model.jdk7.Locale;
import br.com.codecode.workix.tests.model.jdk7.User;
import br.com.codecode.workix.tests.util.gson.GsonProvider;

public class GsonCandidateDeserializer implements JsonDeserializer<BaseCandidate> {

    @Override
    public BaseCandidate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	    throws JsonParseException {


	JsonObject obj = json.getAsJsonObject();
	
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
	String uuid  = (obj.has("uuid")) && (!obj.get("uuid").isJsonNull()) ? obj.get("uuid").getAsString() : "";

	/**
	 * Created at Field
	 */
	Calendar createdAt = GsonProvider.buildGson().fromJson(obj.get("createdAt"), Calendar.class);

	/**
	 * Updated at Field
	 */
	Calendar updatedAt = GsonProvider.buildGson().fromJson(obj.get("updatedAt"), Calendar.class);

	/**
	 * Name Field
	 */
	String name = (obj.has("name")) && (!obj.get("name").isJsonNull()) ? obj.get("name").getAsString() : "";

	/**
	 * User Field
	 */
	BaseUser user = GsonProvider.buildGson().fromJson(obj.get("user"), User.class) ;

	/**
	 * Contact Field
	 */
	BaseContact contact = GsonProvider.buildGson().fromJson(obj.get("contact"), Contact.class);

	/**
	 * Locale Field
	 */
	BaseLocale locale = GsonProvider.buildGson().fromJson(obj.get("locale"), Locale.class);

	/**
	 * CPF Field
	 */
	long cpf  = (obj.has("cpf")) && (!obj.get("cpf").isJsonNull()) ? obj.get("cpf").getAsLong() : 0;

	/**
	 * Birth Date Field
	 */
	Calendar birthDate  = GsonProvider.buildGson().fromJson(obj.get("birthDate"), Calendar.class);
	
	
	Candidate c = new Candidate();
	
	c.setUser(user);
	
	c.setContact(contact);
	
	c.setLocale(locale);	
	
	c.setCpf(cpf);
	
	c.setName(name);
	
	c.setBirthDate(birthDate);
	
	c.setUuid(uuid);
	
	c.setVersion(version);
	
	c.setCreatedAt(createdAt);
	
	c.setUpdatedAt(updatedAt);
	
	c.setId(id);
	
	
	

	return c;
    }

}
