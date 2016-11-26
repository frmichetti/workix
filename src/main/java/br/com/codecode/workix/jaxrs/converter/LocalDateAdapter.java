package br.com.codecode.workix.jaxrs.converter;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 * Converter for Java 8 Dates {@link LocalDate}
 * FIXME Not Working with JaxRs Jackson
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
   
	@Override
    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.parse(s);
    }
   
	@Override
    public String marshal(LocalDate dateTime) throws Exception {
        return dateTime.toString();
    }   
}
