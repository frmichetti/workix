package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Skill {@link Embeddable} JPA Class
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
abstract class Skill implements Serializable {

	private static final long serialVersionUID = -5975419980185059163L;
	
	@Column
	private String skillName;

	/**
	 * @return the skillName
	 */
	public final String getSkillName() {
		return skillName;
	}

	/**
	 * @param skillName the skillName to set
	 */
	public final void setSkillName(String skillName) {
		this.skillName = skillName;
	}	
	
	

}
