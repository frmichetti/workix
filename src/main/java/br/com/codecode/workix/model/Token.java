/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.model;

import java.util.Date;

/**
 * Token Model
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public final class Token {

	private Date createdAt;

	private String key;
	
	/**
	 * 
	 */
	public Token() {
		setCreatedAt(new Date());
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	private void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Token [createdAt=" + createdAt + ", key=" + key + "]";
	}	

}
