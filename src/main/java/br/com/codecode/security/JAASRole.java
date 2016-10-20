/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.security;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * Only for JAAS security
 * 
 * @since 1.0
 * @version
 */
@Entity
public class JAASRole implements Serializable {

	private static final long serialVersionUID = -3259219990958750371L;

	@Id
	@Column(unique = true, nullable = false)
	private String name;

	protected JAASRole(){}
	
	public JAASRole (String name){
		this();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
