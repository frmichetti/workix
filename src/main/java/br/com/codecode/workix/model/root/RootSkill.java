package br.com.codecode.workix.model.root;

/**
 * Root Abstract Class Skill<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #skillName}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootSkill {

	private String skillName;
	
	/**
	 * Public Empty Default Constructor
	 */
	public RootSkill(){}

	/**
	 * @return the Skill Name
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * @param skillName the Skill Name to set
	 */
	public final void setSkillName(String skillName) {
		this.skillName = skillName;
	}	
	
}
