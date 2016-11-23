package br.com.codecode.workix.model.base;

import br.com.codecode.workix.model.jpa.Contact;
import br.com.codecode.workix.model.jpa.Locale;
import br.com.codecode.workix.model.jpa.User;

public interface BasePerson extends BaseEntity{

	String getName();
	
	void setName(String name);
	
	Contact getContact();

	void setContact(Contact contact);

	User getUser();

	void setUser(User user);
	
	Locale getLocale();
	
	void setLocale(Locale locale);	
	
}
