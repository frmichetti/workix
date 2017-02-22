/**
 * 
 */
package br.com.codecode.workix.tests.model.jdk7;

import java.io.Serializable;
import java.util.Calendar;

import br.com.codecode.workix.core.models.jdk7.actions.UserActions;
import br.com.codecode.workix.core.models.jdk7.root.BaseCandidate;
import br.com.codecode.workix.core.models.jdk7.root.BaseContact;
import br.com.codecode.workix.core.models.jdk7.root.BaseLocale;
import br.com.codecode.workix.core.models.jdk7.root.BaseUser;

/**
 * @author felipe
 *
 */
public final class Candidate extends BaseCandidate implements Serializable {
    
  
    private static final long serialVersionUID = 1L;

    @Override
    public Calendar getBirthDate() {
	return super.birthDate;
    }

    @Override
    public BaseContact getContact() {
	return super.contact;
    }

    @Override
    public long getCpf() {	
	return super.cpf;
    }

    @Override
    public Calendar getCreatedAt() {	
	return super.getCreatedAt();
    }

    @Override
    public long getId() {	
	return super.getId();
    }

    @Override
    public BaseLocale getLocale() {	
	return super.locale;
    }

    @Override
    public String getName() {	
	return super.name;
    }

    @Override
    public Calendar getUpdatedAt() {	
	return super.getUpdatedAt();
    }

    @Override
    public UserActions getUser() {	
	return super.user;
    }

    @Override
    public String getUuid() {	
	return super.getUuid();
    }

    @Override
    public int getVersion() {	
	return super.getVersion();
    }

    @Override
    public void setBirthDate(Calendar birthDate) {
	super.birthDate = birthDate;
    }

    @Override
    public void setContact(BaseContact contact) {
	super.contact = contact;
    }

    @Override
    public void setCpf(long cpf) {
	super.cpf = cpf;
    }

    @Override
    public void setCreatedAt(Calendar createdAt) {	
	super.setCreatedAt(createdAt);
    }

    @Override
    public void setId(long id) {	
	super.setId(id);
    }

    @Override
    public void setLocale(BaseLocale locale) {
	super.locale = locale;

    }

    @Override
    public void setName(String name) {
	super.name = name;
    }

    @Override
    public void setUpdatedAt(Calendar updatedAt) {	
	super.setUpdatedAt(updatedAt);
    }

    @Override
    public void setUser(BaseUser user) {
	super.user =  user;
    }

    @Override
    public void setUuid(String uuid) {	
	super.setUuid(uuid);
    }

    @Override
    public void setVersion(int version) {	
	super.setVersion(version);
    }
    
    

}
