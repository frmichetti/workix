package br.com.codecode.workix.jaxrs.converter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Converter for Java 8 Dates {@link LocalDate} FIXME Not Working with JaxRs
 * Jackson
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String s) {
        return LocalDate.parse(s);
    }

    @Override
    public String marshal(LocalDate dateTime) {
        return dateTime.toString();
    }
}
