package br.com.codecode.workix.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.model.interfaces.Buildable;

/**
 * Skill {@link Embeddable} JPA Class
 * @author felipe
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Skill implements Serializable {

	private static final long serialVersionUID = -5975419980185059163L;

	@Column
	private String skillName;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */	
	public Skill(){}	

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 * @see Buildable
	 * @param builder
	 * @category Builder
	 */
	public Skill(Builder builder) {
		this.skillName = builder.skillName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "Skill [skillName=" + skillName + "]";
	}	
	
	/**
	 * Builder NestedClass for {@link Skill} 
	 * @category Builder
	 * @author felipe
	 *
	 */
	public static class Builder implements Buildable<Skill> {	

		private String skillName;

		private Builder(){}		

		public Builder(String skillName) {
			this();			
			this.skillName = skillName;
		}

		public Builder setSkillName(String skillName) {
			this.skillName = skillName;
			return this;
		}
	
		@Override
		public Skill build()
		{
			return new Skill(this);
		}

	}	
	
	

}
