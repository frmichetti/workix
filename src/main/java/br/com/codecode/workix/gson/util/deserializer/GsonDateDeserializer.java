package br.com.codecode.workix.gson.util.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Simple Date Deserializer for Gson <br>
 * Register in GsonBuilder <br>
 * Example: <br>
 * <code>new GsonBuilder()				
 *	.registerTypeAdapter(Date.class, new GsonDateDeserializer())						
 *	.create();
 *	</code>
 *
 * @author felipe
 */
public class GsonDateDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        if (json.isJsonPrimitive()) {

            String dateRaw = json.getAsString();

            Date d = new Date();

            try {

                d = new SimpleDateFormat("yyyy-MM-dd").parse(dateRaw);

                return d;

            } catch (ParseException e) {

                System.err.println(e);

                System.out.println("Try get Date as Long ...");

                long date = json.getAsLong();

                return new Date(date);
            }
        } else
            throw new JsonParseException("Error on Parse Date");

    }

}
