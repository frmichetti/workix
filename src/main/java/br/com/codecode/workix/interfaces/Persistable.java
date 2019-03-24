package br.com.codecode.workix.interfaces;

import br.com.codecode.workix.jsf.util.converter.AnotherEntityConverter;
import br.com.codecode.workix.jsf.util.converter.SimpleEntityConverter;

/**
 * Markup Interface for Persistable Entities <br>
 * Implements this for works with <br>
 * {@link SimpleEntityConverter} and {@link AnotherEntityConverter} in JSF
 *
 * @author Felipe Rodrigues Michetti
 * @since 1.0
 * @version 1.0
 */
public interface Persistable {

    /**
     * @return the Id
     */
    long getId();

    /**
     * @param id define the Id
     */
    void setId(long id);

}
