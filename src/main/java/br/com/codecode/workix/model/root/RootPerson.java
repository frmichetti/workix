package br.com.codecode.workix.model.root;

import br.com.codecode.workix.model.base.BaseContact;
import br.com.codecode.workix.model.base.BaseLocale;
import br.com.codecode.workix.model.jpa.User;

/**
 * Root Abstract Class Person<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #name}</li>
 * <li>{@link #user}</li>
 * <li>{@link #contact}</li>
 * <li>{@link #locale}</li> 
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootPerson extends RootEntity {

	protected String name;

	protected User user;	

	protected BaseContact contact;

	protected BaseLocale locale;
}
