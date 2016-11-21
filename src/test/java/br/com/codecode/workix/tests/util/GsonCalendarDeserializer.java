package br.com.codecode.workix.tests.util;

import java.lang.reflect.Type;
import java.util.Calendar;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Simple Calendar Converter for Gson
 * @author felipe
 *
 */
public class GsonCalendarDeserializer implements JsonDeserializer<Calendar> {

	@Override
	public Calendar deserialize(JsonElement json, Type type,
			JsonDeserializationContext context)	throws JsonParseException {

		if(json.isJsonObject()){				

			int year = 	getInt("year", json);

			int month = getInt("month", json);

			int dayOfMonth = getInt("dayOfMonth", json);

			int hourOfDay = getInt("hourOfDay", json);

			int minute = getInt("minute", json);

			int second = getInt("second", json);

			Calendar c = Calendar.getInstance();

			c.set(year, month, dayOfMonth, hourOfDay, minute, second);

			return c;

		}else{
			throw new JsonParseException("Cannot Convert Json to Calendar");
		}
	}

	private int getInt(String name, JsonElement element) {
		return element.getAsInt();
	} 



}
