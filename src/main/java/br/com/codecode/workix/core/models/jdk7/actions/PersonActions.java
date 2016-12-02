package br.com.codecode.workix.core.models.jdk7.actions;

/**
 * Markup Interface for Person Implementation
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see EntityActions
 */
abstract interface PersonActions extends EntityActions {

    ContactActions getContact();

    LocaleActions getLocale();

    String getName();

    UserActions getUser();

    void setContact(ContactActions contact);

    void setLocale(LocaleActions locale);

    void setName(String name);

    void setUser(UserActions user);

}
