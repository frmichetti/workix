package br.com.codecode.workix.model.root;

/**
 * Root Abstract Class Contact<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #mobilePhone}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public abstract class RootContact {
	
	private long mobilePhone;
	
	/**
	 * Public Empty Default Constructor
	 */
	public RootContact(){}

	/**
	 * @return the Mobile Phone
	 */
	public final long getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the Mobile Phone to set
	 */
	public final void setMobilePhone(long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}		

}
