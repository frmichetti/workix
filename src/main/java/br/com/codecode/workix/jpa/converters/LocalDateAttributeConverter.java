package br.com.codecode.workix.jpa.converters;

import java.time.LocalDate;
import java.sql.Date;

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
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
	return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
	return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}