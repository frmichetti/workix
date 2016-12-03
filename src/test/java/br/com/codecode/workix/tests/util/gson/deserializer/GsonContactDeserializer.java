package br.com.codecode.workix.tests.util.gson.deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import br.com.codecode.workix.core.models.jdk7.root.BaseContact;
import br.com.codecode.workix.tests.model.jdk7.Contact;

public class GsonContactDeserializer implements JsonDeserializer<BaseContact> {

    @Override
    public BaseContact deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	    throws JsonParseException {

	/**
	 * Mobile Phone Field
	 */
	long mobilePhone = json.getAsJsonObject().get("mobilePhone").getAsLong();

	Contact c = new Contact();
	
	c.setMobilePhone(mobilePhone);
	
	return c;
    }

}
