package br.com.codecode.workix.tests.model.draft;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.codecode.workix.core.common.jk7.Token;
import br.com.codecode.workix.gson.util.deserializer.GsonCalendarDeserializer;
import br.com.codecode.workix.gson.util.deserializer.GsonDateDeserializer;
import br.com.codecode.workix.gson.util.deserializer.GsonLocalDateDeserializer;
import br.com.codecode.workix.gson.util.deserializer.GsonLocalDateTimeDeserializer;
import br.com.codecode.workix.gson.util.serializer.GsonLocalDateSerializer;
import br.com.codecode.workix.gson.util.serializer.GsonLocalDateTimeSerializer;


public class TestToken {
    
    private Token token;
    
    private static Gson g;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	
	g = new GsonBuilder()
	
	.setPrettyPrinting()
	
	.setDateFormat(new SimpleDateFormat().toPattern())
	
	.enableComplexMapKeySerialization()	
	
	.registerTypeAdapter(LocalDate.class, new GsonLocalDateSerializer())
	
	.registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeSerializer())
	
	.registerTypeAdapter(Date.class, new GsonDateDeserializer())
	
	.registerTypeAdapter(Calendar.class, new GsonCalendarDeserializer())
	
	.registerTypeAdapter(LocalDate.class, new GsonLocalDateDeserializer())
	
	.registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeDeserializer())
	
	.create();
	
    }

    @Before
    public void setUp() throws Exception {
	token = token.builder().withKey("key").build();
    }

    @Test
    public void test() {
	
	assertNotNull(token);
	
	System.out.println(token.getKey());
	
	System.out.println(token.getCreatedAt());
	
	System.out.println(g.toJson(token));
	
	
	
    }

}
