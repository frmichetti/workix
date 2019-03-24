package br.com.codecode.workix.gson.util.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class GsonLocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
    
    @Override
    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context)
	    throws JsonParseException {

	return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString());

    }

}
