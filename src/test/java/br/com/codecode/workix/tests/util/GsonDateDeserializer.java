/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.util;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
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
	.registerTypeAdapter(Date.class, new GsonDateDeserializer())						
	.create();
	</code>
 * @author felipe
 *
 */
public class GsonDateDeserializer implements JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {

		if (json.isJsonPrimitive()){

			String dateRaw = json.getAsString();			

			Date d = new Date();

			try {

				d = DateFormat.getInstance().parse(dateRaw);

				return d;

			} catch (ParseException e) {

				long date = json.getAsLong();	

				return new Date(date);
			}
		}else
			throw new JsonParseException("Error on Parse Date");







	}

}
