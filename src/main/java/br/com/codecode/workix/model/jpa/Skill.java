package br.com.codecode.workix.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.model.interfaces.Buildable;
import br.com.codecode.workix.model.root.RootSkill;

/**
 * Skill {@link Embeddable} JPA Class
 * @author felipe
 * @since 1.0
 * @version 1.0
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
	 * @param builder Builder for Generate a New Skill
	 */
	public Skill(Builder builder) {
		this.setSkillName(builder.getSkillName()); 
	}	
	
	/**
	 * @return the Skill Name
	 */
	public final String getSkillName() {
		return this.skillName;
	}	
	
	/**
	 * @param skillName the Skill Name to set
	 */
	public final void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/**
	 * Builder NestedClass for {@link Skill} 
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 */
	public final static class Builder extends RootSkill implements Buildable<Skill> {	
	
		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){}		

		/**
		 * Constructor with Required Fields
		 * @param skillName Skill Name
		 */
		public Builder(String skillName) {
			this();			
			this.setSkillName(skillName);
		}		
	
		/**
		 * @param skillName the skillName to set
		 * @return Builder
		 */
		public Builder withSkillName(String skillName) {
			this.setSkillName(skillName);
			return this;
		}
		
		/**
		 * Return a New Skill
		 */
		@Override
		public Skill build()
		{
			return new Skill(this);
		}

	}	
	
	

}
