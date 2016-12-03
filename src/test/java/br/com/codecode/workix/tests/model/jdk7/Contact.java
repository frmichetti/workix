package br.com.codecode.workix.tests.model.jdk7;

import br.com.codecode.workix.core.models.jdk7.root.BaseContact;


public final class Contact extends BaseContact {

    @Override
    public long getMobilePhone() {	
	return super.mobilePhone;
    }

    @Override
    public void setMobilePhone(long mobilePhone) {
	super.mobilePhone = mobilePhone;
    }

}
