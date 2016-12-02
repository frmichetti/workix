package br.com.codecode.workix.core.models.jdk7.root;

import br.com.codecode.workix.core.models.jdk7.actions.SkillActions;

/**
 * Root Abstract Class Skill<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #skillName}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see SkillActions
 */
public abstract class BaseSkill implements SkillActions{

    /**
     * Name of Skill Field
     */
    protected String skillName;   

}
