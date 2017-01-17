package br.com.codecode.workix.gson.util.serializer;

import java.lang.reflect.Type;
import java.util.Calendar;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonCalendarSerializer implements JsonSerializer<Calendar> {

    @Override
    public JsonElement serialize(Calendar src, Type typeOfSrc, JsonSerializationContext context) {	
	return new JsonPrimitive(src.getTimeInMillis());
    }

}
