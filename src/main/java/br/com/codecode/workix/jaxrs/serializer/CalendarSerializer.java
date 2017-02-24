package br.com.codecode.workix.jaxrs.serializer;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.codecode.workix.config.JAXRSConfiguration;
import br.com.codecode.workix.config.JAXRSContextResolver;

/**
 * Calendar Serializer for Jackson
 * To use:
 * <code>
 * .registerModule(new SimpleModule()
			.addSerializer(Calendar.class, new CalendarSerializer()))</code>
 * @see JAXRSConfiguration
 * @see JAXRSContextResolver
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class CalendarSerializer extends JsonSerializer<Calendar> {


    @Override
    public void serialize(Calendar value, JsonGenerator gen, SerializerProvider serializers)
	    throws IOException, JsonProcessingException {	
	
    }
}
