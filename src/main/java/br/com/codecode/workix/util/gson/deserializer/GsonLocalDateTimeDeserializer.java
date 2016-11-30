package br.com.codecode.workix.util.gson.deserializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class GsonLocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context)
	    throws JsonParseException {

	System.out.println("----------------");

	System.out.println("Deserialize");

	System.out.println(json.getAsJsonPrimitive().getAsString());

	return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString());

    }

}
