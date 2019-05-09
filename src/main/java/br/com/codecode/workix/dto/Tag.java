package br.com.codecode.workix.dto;

import br.com.codecode.workix.interfaces.Buildable;

import java.io.Serializable;

public class Tag implements Serializable {

    private static final long serialVersionUID = 323076947054044016L;

    private String name;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Tag() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Tag
     * @see Buildable
     */
    private Tag(Builder builder) {
        this.name = builder.getName();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Creates builder to build {@link Tag}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }


    /**
     * Builder NestedClass for {@link Tag}
     *
     * @author felipe
     * @version 1.0
     * @see Tag
     * @see Buildable
     * @since 1.0
     */
    public static final class Builder extends Tag implements Buildable<Tag> {

        private static final long serialVersionUID = -5775038446937981944L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        public Builder withName(String name) {
            super.name = name;
            return this;
        }

        /**
         * Return a New Tag
         */
        @Override
        public Tag build() {
            return new Tag(this);
        }
    }

}
