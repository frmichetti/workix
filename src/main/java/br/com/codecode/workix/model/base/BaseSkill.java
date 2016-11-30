package br.com.codecode.workix.model.base;

/**
 * Root Abstract Class Skill<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #skillName}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public abstract class BaseSkill {

    private String skillName;

    /**
     * Public Empty Default Constructor
     */
    public BaseSkill() {
    }

    /**
     * @return the Skill Name
     */
    public String getSkillName() {
	return skillName;
    }

    /**
     * @param skillName
     *            the Skill Name to set
     */
    public void setSkillName(String skillName) {
	this.skillName = skillName;
    }

}
