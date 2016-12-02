package br.com.codecode.workix.core.models.jdk7.root;

import br.com.codecode.workix.core.models.enums.Estate;
import br.com.codecode.workix.core.models.jdk7.actions.LocaleActions;

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
 * @since 1.1
 * @version 1.0
 * @see LocaleActions
 */
public abstract class BaseLocale implements LocaleActions {

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
