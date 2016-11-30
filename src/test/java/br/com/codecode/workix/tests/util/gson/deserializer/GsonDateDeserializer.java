/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.util.gson.deserializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Simple Date Deserializer for Gson <br>
 * Register in GsonBuilder <br>
 * Example: <br>
 * <code>new GsonBuilder()				
 *	.registerTypeAdapter(Date.class, new GsonDateDeserializer())						
 *	.create();
 *	</code>
 * 
 * @author felipe
 */
public class GsonDateDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

	if (json.isJsonPrimitive()) {

	    String dateRaw = json.getAsString();

	    Date d = new Date();

	    try {

		/**
		 * attempt for DateFormat , Pattern Must be Equals
		 * {@link JacksonContextResolver #init()}
		 * 
		 * @return
		 */
		d = new SimpleDateFormat().parse(dateRaw);

		return d;

	    } catch (ParseException e) {

		System.err.println(e);

		System.out.println("Try get Date as Long ...");

		long date = json.getAsLong();

		return new Date(date);
	    }
	} else
	    throw new JsonParseException("Error on Parse Date");

    }

}
