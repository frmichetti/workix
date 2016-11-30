package br.com.codecode.workix.model.base;

import br.com.codecode.workix.jpa.enums.Estate;

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

    protected long zipCode;

    protected String city;

    protected String neighborhood;

    protected String street;

    protected String number;

    protected Estate estate;
   
}
