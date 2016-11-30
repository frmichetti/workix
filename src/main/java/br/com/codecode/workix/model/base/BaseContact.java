package br.com.codecode.workix.model.base;

/**
 * Root Abstract Class Contact<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #mobilePhone}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public abstract class BaseContact {

    private long mobilePhone;

    /**
     * Public Empty Default Constructor
     */
    public BaseContact() {
    }

    /**
     * @return the Mobile Phone
     */
    public long getMobilePhone() {
	return mobilePhone;
    }

    /**
     * @param mobilePhone
     *            the Mobile Phone to set
     */
    public void setMobilePhone(long mobilePhone) {
	this.mobilePhone = mobilePhone;
    }

}
