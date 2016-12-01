package br.com.codecode.workix.core.models.root;

import br.com.codecode.workix.core.models.enums.Estate;

/**
 * Root Abstract Class Locale<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #zipCode}</li>
 * <li>{@link #city}</li>
 * <li>{@link #neighborhood}</li>
 * <li>{@link #street}</li>
 * <li>{@link #number}</li>
 * <li>{@link #estate}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public abstract class BaseLocale {

    /**
     * Zip Code Field
     */
    protected long zipCode;

    /**
     * City Field
     */
    protected String city;

    /**
     * NeighBorhood Field
     */
    protected String neighborhood;

    /**
     * Street Field
     */
    protected String street;

    /**
     * Number of House Field
     */
    protected String number;

    /**
     * Estate Field
     */
    protected Estate estate;
   
}
