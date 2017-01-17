package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Skill Class for Compatibility
 * <br>Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.1
 */
public class Skill implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The skill name. */
    private String skillName;

    @Generated("SparkTools")
    private Skill(Builder builder) {
	this.skillName = builder.skillName;
    }

    /**
     * Public Default Constructor.
     */
    public Skill(){}    

    /**
     * Gets the skill name.
     *
     * @return the Skill Name
     */
    public final String getSkillName() {
	return this.skillName;
    }

    /**
     * Sets the skill name.
     *
     * @param skillName            the Skill Name to set
     */
    public final void setSkillName(String skillName) {
	this.skillName = skillName;
    }

    /**
     * Creates builder to build {@link Skill}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Skill}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private String skillName;

	private Builder() {
	}

	public Builder withSkillName(String skillName) {

	    this.skillName = skillName;
	    return this;
	}

	public Skill build() {

	    return new Skill(this);
	}
    }   

}
