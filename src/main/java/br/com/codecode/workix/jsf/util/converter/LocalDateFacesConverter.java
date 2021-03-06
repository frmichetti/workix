package br.com.codecode.workix.jsf.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Local Date Faces Converterfor JSF <a href=
 * "http://sidroniolima.com.br/blog/2015/12/15/localdate-e-localdatetime-em-jsf-2-2/">LocalDate
 * e LocalDateTime JSF</a>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@FacesConverter("localDateFacesConverter")
public class LocalDateFacesConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String stringValue) {

	if (null == stringValue || stringValue.isEmpty()) {
	    return null;
	}

	LocalDate localDate;

	try {
	    localDate = LocalDate.parse(stringValue, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	} catch (DateTimeParseException e) {

	    throw new ConverterException("O ano deve conter 4 dígitos. Exemplo: 13/11/2015.");
	}

	return localDate;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object localDateValue) {

	if (null == localDateValue) {

	    return "";
	}

	return ((LocalDate) localDateValue).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
