package br.com.codecode.workix.gson.util.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

public class GsonDateSerializer implements JsonSerializer<Date> {

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getTime());
    }

}
