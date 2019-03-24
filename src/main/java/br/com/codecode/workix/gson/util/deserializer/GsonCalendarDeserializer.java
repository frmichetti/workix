package br.com.codecode.workix.gson.util.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Simple Calendar Deserializer for Gson <br>
 * Register in GsonBuilder <br>
 * Example:<br>
 * <code>new GsonBuilder()
 * .registerTypeAdapter(Calendar.class, new GsonCalendarDeserializer())
 * .create();
 * </code>
 *
 * @author felipe
 */
public class GsonCalendarDeserializer implements JsonDeserializer<Calendar> {

    @Override
    public Calendar deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {

        if (json.isJsonObject()) {

            int year = getInt("year", json);

            int month = getInt("month", json);

            int dayOfMonth = getInt("dayOfMonth", json);

            int hourOfDay = getInt("hourOfDay", json);

            int minute = getInt("minute", json);

            int second = getInt("second", json);

            Calendar c = Calendar.getInstance();

            c.set(year, month, dayOfMonth, hourOfDay, minute, second);

            return c;

        } else if (json.isJsonPrimitive()) {

            String dateRaw = json.getAsString();

            Calendar c = Calendar.getInstance();

            Date d = null;

            try {

                if (dateRaw.length() == 10)
                    d = new SimpleDateFormat("yyyy-MM-dd").parse(dateRaw);
                else
                    d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").parse(dateRaw);
            } catch (ParseException e) {

                e.printStackTrace();
            }

            c.setTime(d);

            return c;

        } else
            throw new JsonParseException("Cannot Parse Json Object");

    }

    private int getInt(String name, JsonElement element) {

        return element.getAsJsonObject().get(name).getAsInt();

    }

}
