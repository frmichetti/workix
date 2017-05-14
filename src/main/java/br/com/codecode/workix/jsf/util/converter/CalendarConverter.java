/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.jsf.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar Converter for JSF
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@FacesConverter("CalendarConverter")
public class CalendarConverter implements Converter {

    private static DateTimeConverter originalConverter = new DateTimeConverter();

    static {
	originalConverter.setPattern("yyyy-MM-dd");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

	Date date = (Date) originalConverter.getAsObject(context, component, value);

	if (date == null) {
	    return null;
	}

	Calendar newCalendar = Calendar.getInstance();

	newCalendar.setTime(date);

	return newCalendar;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

	if (value == null) {
	    return null;
	}

	Calendar calendar = (Calendar) value;

	return originalConverter.getAsString(context, component, calendar.getTime());
    }

}
