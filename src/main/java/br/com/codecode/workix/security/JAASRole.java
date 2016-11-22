/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Only for JAAS security
 * 
 * @since 1.0
 * @version
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name="JAAS_Role")
@Entity
public class JAASRole implements Serializable {

	private static final long serialVersionUID = -3259219990958750371L;

	@Id
	@Column(unique = true, nullable = false)
	private String name;

	protected JAASRole(){}

	public JAASRole(String name) {
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
