package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

@Embeddable
public class Skill implements Serializable {

	private static final long serialVersionUID = -5975419980185059163L;
	
	@Expose
	private String skillName;
	
	public Skill(){}	

	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	

}
