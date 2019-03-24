package br.com.codecode.workix.jaxrs.converter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

/**
 * Converter for Java 8 Dates {@link LocalDateTime} FIXME Not Working with JaxRs
 * Jackson
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String s) {
        return LocalDateTime.parse(s);
    }

    @Override
    public String marshal(LocalDateTime dateTime) {
        return dateTime.toString();
    }
}
