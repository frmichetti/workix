package br.com.codecode.workix.jpa.converters;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @see <a href=
 *      "http://www.thoughts-on-java.org/persist-localdate-localdatetime-jpa">
 *      Persist LocalDate LocalDateTime</a>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
	return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
	return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
    }
}
