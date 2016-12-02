package br.com.codecode.workix.core.models.jdk7.root;

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
 * @since 1.1
 * @version 1.0
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
    protected BaseUser user;

    /**
     * Contact Field
     */
    protected BaseContact contact;

    /**
     * Locale Field
     */
    protected BaseLocale locale;

   
}
