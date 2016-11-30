package br.com.codecode.workix.tests.util.gson.deserializer;

import java.lang.reflect.Type;
import java.time.LocalDate;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class GsonLocalDateDeserializer implements JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context)
	    throws JsonParseException {
	
	return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
    
    }

}
