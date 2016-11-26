package br.com.codecode.workix.model.base;

/**
 * Markup Interface for Person Implementation
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract interface BasePerson extends BaseEntity {

	String getName();

	void setName(String name);

	BaseContact getContact();

	void setContact(BaseContact contact);

	BaseUser getUser();

	void setUser(BaseUser user);

	BaseLocale getLocale();

	void setLocale(BaseLocale locale);	

}
