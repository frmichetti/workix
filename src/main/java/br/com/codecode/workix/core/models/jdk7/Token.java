/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.core.models.jdk7;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

/**
 * Token Model
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public final class Token {

    /**
     * Builder to build {@link Token}.
     */    
    public static final class Builder {

	private Calendar createdAt;

	private String key;

	private Builder(){}

	public Token build() {
	    return new Token(this);
	}

	public Builder withKey(String key) {
	    this.key = key;
	    this.createdAt = Calendar.getInstance();
	    return this;
	}
    }

    private Calendar createdAt;

    private String key;

    /**
     * Public Default Constructor
     */
    private Token(){}
    
    private Token(@NotNull Builder builder) {
	setCreatedAt(builder.createdAt);
	this.key = builder.key;
    }

    /**
     * Creates builder to build {@link Token}.
     * 
     * @return created builder
     */    
    public static Builder builder() {
	return new Builder();
    }

    private void setCreatedAt(Calendar createdAt) {
	this.createdAt = createdAt;
    }

    public Calendar getCreatedAt() {
	return createdAt;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    @Override
    public String toString() {
	return new StringBuilder().append("Token [createdAt=").append(createdAt).append(", key=").append(key)
		.append("]").toString();
    }

}
