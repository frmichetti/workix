package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;

import br.com.codecode.workix.interfaces.Buildable;

/**
 * Skill JPA Class with Inherited Fields and Methods
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */

public class Skill implements Serializable {

    /**
     * Builder NestedClass for {@link Skill}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Buildable
     */
    public final static class Builder extends Skill implements Buildable<Skill> {

	private static final long serialVersionUID = -2784926262850261658L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder() {
	}

	/**
	 * Constructor with Required Fields
	 * 
	 * @param skillName
	 *            Skill Name
	 */
	public Builder(String skillName) {
	    this();
	    this.setSkillName(skillName);
	}

	/**
	 * Return a New Skill
	 */
	@Override
	public Skill build() {
	    return new Skill(this);
	}

	/**
	 * @param skillName
	 *            the skillName to set
	 * @return Builder
	 */
	public Builder withSkillName(String skillName) {
	    this.setSkillName(skillName);
	    return this;
	}

    }

    private static final long serialVersionUID = -5975419980185059163L;

    private String skillName;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Skill() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Skill
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
     * @param skillName
     *            the Skill Name to set
     */
    public final void setSkillName(String skillName) {
	this.skillName = skillName;
    }

}
