package br.com.codecode.workix.config;

import java.text.SimpleDateFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * This Class define Startup Properties for JAXRS
 * 
 * @author felipe
 * @since 1.1
 * @version 1.1
 */
@Provider
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class JAXRSContextResolver implements ContextResolver<ObjectMapper> {

    private static final ObjectMapper om = build();

    @Override
    public ObjectMapper getContext(Class<?> objectType) {
	return om;
    }

    private static ObjectMapper build() {

	return new ObjectMapper()
		
		.registerModule(new JavaTimeModule())		

		.setDateFormat(new SimpleDateFormat())

		.enable(SerializationFeature.INDENT_OUTPUT)

		.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);

    }
}
