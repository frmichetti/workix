package br.com.codecode.workix.tests.model.jdk7;

import java.io.Serializable;
import java.util.Calendar;

import br.com.codecode.workix.core.models.jdk7.root.BaseUser;
import br.com.codecode.workix.interfaces.Notificable;

public final class User extends BaseUser implements Notificable , Serializable {

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

    @Override
    public long getId() {
	return super.getId();
    }

    @Override
    public int getVersion() {
	return super.getVersion();
    }

    @Override
    public String getUuid() {
	return super.getUuid();
    }

    @Override
    public Calendar getCreatedAt() {
	return super.getCreatedAt();
    }

    @Override
    public Calendar getUpdatedAt() {
	return super.getUpdatedAt();
    }

    @Override
    public void setId(long id) {
	super.setId(id);
    }

    @Override
    public void setVersion(int version) {
	super.setVersion(version);
    }

    @Override
    public void setUuid(String uuid) {
	super.setUuid(uuid);
    }

    @Override
    public void setCreatedAt(Calendar createdAt) {
	super.setCreatedAt(createdAt);
    }

    @Override
    public void setUpdatedAt(Calendar updatedAt) {	
	super.setUpdatedAt(updatedAt);
    }  

    @Override
    public String toString() {	
	return super.toString();
    }

    @Override
    public void finalize() throws Throwable {
	super.finalize();
    }

    

}
