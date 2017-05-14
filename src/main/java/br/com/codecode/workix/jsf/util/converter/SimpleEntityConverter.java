/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.jsf.util.converter;

import br.com.codecode.workix.interfaces.Persistable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Map;

/**
 * Simple Entity Converter for JSF
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@FacesConverter("SimpleEntityConverter")
public class SimpleEntityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
	if (value != null) {
	    return this.getAttributesFrom(component).get(value);
	}
	return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

	if (value != null && !"".equals(value)) {

	    Persistable entity = (Persistable) value;

	    // adiciona item como atributo do componente
	    this.addAttribute(component, entity);

	    Long codigo = entity.getId();
	    if (codigo != null) {
		return String.valueOf(codigo);
	    }
	}

	return (String) value;
    }

    protected void addAttribute(UIComponent component, Persistable o) {

	String key = String.valueOf(o.getId()); // codigo da empresa como chave
						// neste caso

	this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
	return component.getAttributes();
    }

}
