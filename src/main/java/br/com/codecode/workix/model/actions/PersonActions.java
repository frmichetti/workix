package br.com.codecode.workix.model.actions;

/**
 * Markup Interface for Person Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract interface PersonActions extends EntityActions {

    String getName();

    void setName(String name);

    ContactActions getContact();

    void setContact(ContactActions contact);

    UserActions getUser();

    void setUser(UserActions user);

    LocaleActions getLocale();

    void setLocale(LocaleActions locale);

}
