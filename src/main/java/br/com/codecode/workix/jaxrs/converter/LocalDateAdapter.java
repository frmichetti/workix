package br.com.codecode.workix.jaxrs.converter;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

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
