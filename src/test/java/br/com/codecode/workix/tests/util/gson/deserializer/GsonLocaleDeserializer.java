package br.com.codecode.workix.tests.util.gson.deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import br.com.codecode.workix.core.enums.Estate;
import br.com.codecode.workix.core.models.jdk7.root.BaseLocale;
import br.com.codecode.workix.tests.model.jdk7.Locale;

public class GsonLocaleDeserializer implements JsonDeserializer<BaseLocale> {

    @Override
    public BaseLocale deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	    throws JsonParseException {

	JsonObject obj = json.getAsJsonObject();

	/**
	 * Zip Code Field
	 */
	long zipCode = (obj.has("zipCode")) && (!obj.get("zipCode").isJsonNull()) ? obj.get("zipCode").getAsLong() : 0;
	

	/**
	 * City Field
	 */
	String city = (obj.has("city")) && (!obj.get("city").isJsonNull()) ? obj.get("city").getAsString() : "";
	

	/**
	 * NeighBorhood Field
	 */
	String neighborhood = (obj.has("neighborhood")) && (!obj.get("neighborhood").isJsonNull()) ? obj.get("neighborhood").getAsString() : "";
	

	/**
	 * Street Field
	 */
	String street = (obj.has("street")) && (!obj.get("street").isJsonNull()) ? obj.get("street").getAsString() : "";
	

	/**
	 * Number of House Field
	 */
	String number = (obj.has("number")) && (!obj.get("number").isJsonNull()) ? obj.get("number").getAsString() : "";
	

	/**
	 * Estate Field
	 */
	Estate estate = (obj.has("estate")) && (!obj.get("estate").isJsonNull()) ? Estate.valueOf(obj.get("estate").getAsString()) : Estate.SP;	

	Locale l = new Locale();

	l.setZipCode(zipCode);

	l.setCity(city);

	l.setNeighborhood(neighborhood);

	l.setStreet(street);

	l.setNumber(number);

	l.setEstate(estate);

	return l;
    }

}
