package br.com.codecode.workix.jaxrs.deserializer;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

/**
 * Calendar Deserializer for Jackson
 * 
 * @see JacksonContextResolver #init()
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class CalendarDeserializer extends JsonDeserializer<Calendar> {

    @Override
    public Calendar deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {

	JsonNode node = jp.getCodec().readTree(jp);

	int year = getInt("year", node);

	int month = getInt("month", node);

	int dayOfMonth = getInt("dayOfMonth", node);

	int hourOfDay = getInt("hourOfDay", node);

	int minute = getInt("minute", node);

	int second = getInt("second", node);

	Calendar c = Calendar.getInstance();

	c.set(year, month, dayOfMonth, hourOfDay, minute, second);

	return c;
    }

    private int getInt(String name, JsonNode node) {
	return (Integer) ((IntNode) node.get(name)).numberValue();
    }
}
