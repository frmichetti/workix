package br.com.codecode.workix.jaxrs.serializer;

import br.com.codecode.workix.config.JAXRSConfiguration;
import br.com.codecode.workix.config.JAXRSContextResolver;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.util.Calendar;

/**
 * Calendar Serializer for Jackson
 * To use:
 * <code>
 * .registerModule(new SimpleModule()
 * .addSerializer(Calendar.class, new CalendarSerializer()))</code>
 *
 * @author felipe
 * @version 1.0
 * @see JAXRSConfiguration
 * @see JAXRSContextResolver
 * @since 1.0
 */
class CalendarSerializer extends JsonSerializer<Calendar> {


    @Override
    public void serialize(Calendar value, JsonGenerator gen, SerializerProvider serializers) {

    }
}
