package br.com.codecode.workix.model.scaffold;

import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

@Embeddable
public class Skill {
	
	@Expose
	private String name;
	
	public Skill() {
		
	}	

	public Skill(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
