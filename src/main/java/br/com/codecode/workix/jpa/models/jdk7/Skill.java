package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

import java.io.Serializable;

/**
 * Skill JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.0
 */
public class Skill implements Serializable {

    private static final long serialVersionUID = -5975419980185059163L;

    private String skillName;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    Skill() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Skill
     * @see Buildable
     */
    Skill(Builder builder) {
        this.setSkillName(builder.getSkillName());
    }

    /**
     * Creates builder to build {@link Skill}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * @return the Skill Name
     */
    String getSkillName() {
        return this.skillName;
    }

    /**
     * @param skillName the Skill Name to set
     */
    void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    /**
     * Builder NestedClass for {@link Skill}
     *
     * @author felipe
     * @version 1.0
     * @see Buildable
     * @see Skill
     * @since 1.0
     */
    public final static class Builder extends Skill implements Buildable<Skill> {

        private static final long serialVersionUID = -2784926262850261658L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * Return a new Skill
         */
        @Override
        public Skill build() {
            return new Skill(this);
        }

        /**
         * @param skillName the skillName to set
         * @return Builder
         */
        public Builder withSkillName(String skillName) {
            this.setSkillName(skillName);
            return this;
        }

    }

}
