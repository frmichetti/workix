package br.com.codecode.workix.model.pojo;

import br.com.codecode.workix.model.base.BaseUser;

/**
 * Draft User Class
 * @author felipe
 * 
 *
 */
class User extends MyEntity implements BaseUser{

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setActive(boolean active) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFirebaseMessageToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFirebaseMessageToken(String firebaseMessageToken) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFirebaseUUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFirebaseUUID(String firebaseUUID) {
		// TODO Auto-generated method stub
		
	}	
	

}
