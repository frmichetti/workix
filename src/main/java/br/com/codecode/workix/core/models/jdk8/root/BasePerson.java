package br.com.codecode.workix.core.models.jdk8.root;

import br.com.codecode.workix.core.models.jdk8.actions.ContactActions;
import br.com.codecode.workix.core.models.jdk8.actions.LocaleActions;
import br.com.codecode.workix.core.models.jdk8.actions.UserActions;

/**
 * Root Abstract Class Person<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #name}</li>
 * <li>{@link #user}</li>
 * <li>{@link #contact}</li>
 * <li>{@link #locale}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseEntity
 */
abstract class BasePerson extends BaseEntity {

    /**
     * Name Field
     */
    protected String name;

    /**
     * User Field
     */
    protected UserActions user;

    /**
     * Contact Field
     */
    protected ContactActions contact;

    /**
     * Locale Field
     */
    protected LocaleActions locale;

   
}
