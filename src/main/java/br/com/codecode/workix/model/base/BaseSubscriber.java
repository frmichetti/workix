package br.com.codecode.workix.model.base;

/**
 * Root Abstract Class Subscriber<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #id}</li>
 * <li>{@link #email}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class BaseSubscriber {

    private long id;

    private String email;

    /**
     * Public Empty Default Constructor
     */
    public BaseSubscriber() {
    }

    /**
     * @return the id
     */
    public long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
	this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

}
