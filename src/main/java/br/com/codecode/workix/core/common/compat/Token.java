/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.core.common.compat;

import java.util.Calendar;

import br.com.codecode.workix.interfaces.Buildable;

/**
 * Token Model for Compatibily with Older Versions
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class Token {

    //FIXME Broken    
    private Calendar createdAt;

    private String key;

    /**
     * Public Default Constructor
     */
    private Token(){}
    
    private Token(Builder builder) {
	setCreatedAt(builder.getCreatedAt());
	this.key = builder.getKey();
    }

    /**
     * Creates builder to build {@link Token}.
     * 
     * @return created builder
     */
    public static Builder builder() {
	return new Builder();
    }

    public Calendar getCreatedAt() {
	return createdAt;
    }

    public String getKey() {
	return key;
    }

    private void setCreatedAt(Calendar createdAt) {
	this.createdAt = createdAt;
    }

    public void setKey(String key) {
	this.key = key;
    }

    @Override
    public String toString() {
	return new StringBuilder()
		.append("Token [createdAt=")
		.append(createdAt)
		.append(", key=")
		.append(key)
		.append("]").toString();
    }

    /**
     * Builder to build {@link Token}.
     */
    public static final class Builder extends Token implements Buildable<Token> {

	private Builder(){}

	@Override
	public Token build() {
	    return new Token(this);
	}

	public Builder withKey(String key) {
	    super.key = key;
	    super.createdAt = Calendar.getInstance();
	    return this;
	}
    }

}
