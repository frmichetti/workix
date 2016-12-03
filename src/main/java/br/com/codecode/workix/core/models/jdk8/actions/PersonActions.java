package br.com.codecode.workix.core.models.jdk8.actions;

import br.com.codecode.workix.core.models.jdk8.root.BaseContact;
import br.com.codecode.workix.core.models.jdk8.root.BaseLocale;
import br.com.codecode.workix.core.models.jdk8.root.BaseUser;

/**
 * Markup Interface for Person Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see EntityActions
 */
abstract interface PersonActions extends EntityActions {

    ContactActions getContact();

    LocaleActions getLocale();

    String getName();

    UserActions getUser();

    void setContact(BaseContact contact);

    void setLocale(BaseLocale locale);

    void setName(String name);

    void setUser(BaseUser user);

}
