package br.com.codecode.workix.model.base;

import br.com.codecode.workix.model.scaffold.Contact;
import br.com.codecode.workix.model.scaffold.Locale;
import br.com.codecode.workix.model.scaffold.User;

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
