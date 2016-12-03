package br.com.codecode.workix.tests.model.jdk7;

import java.io.Serializable;

import br.com.codecode.workix.core.models.jdk7.root.BaseUser;
import br.com.codecode.workix.interfaces.Notificable;

/**
 * @author felipe
 *
 */
public final class User extends BaseUser implements Notificable , Serializable{
    
    /**
     * @serialField
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String getEmail() {
	return super.email;
    }

    @Override
    public String getFirebaseMessageToken() {	
	return super.firebaseMessageToken;
    }

    @Override
    public String getFirebaseUUID() {
	return super.firebaseUUID;
    }

    @Override
    public boolean isActive() {	
	return super.active;
    }

    @Override
    public void setActive(boolean active) {
	super.active = active;	
    }

    @Override
    public void setEmail(String email) {
	super.email = email;	
    }

    @Override
    public void setFirebaseMessageToken(String firebaseMessageToken) {
	super.firebaseMessageToken = firebaseMessageToken;
    }

    @Override
    public void setFirebaseUUID(String firebaseUUID) {
	super.firebaseUUID = firebaseUUID;
    }

}
