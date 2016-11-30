package br.com.codecode.workix.jpa.models;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Resume JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 * @see Resume
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Resume extends MyEntity {

    private static final long serialVersionUID = 7569771700044121495L;

    private long id;

    /**
     * Owner of Resume<br>
     * One {@link Resume} To One {@link Candidate}
     */
    private Candidate candidate;

    private String objective, content;

    /**
     * One {@link Resume} To Many {@link Experience}
     */
    private Set<Experience> experiences;

    /**
     * One {@link Resume} To Many {@link Education}
     */

    private Set<Education> educations;

    /**
     * One {@link Resume} To Many {@link Skill}
     */    
    private Set<Skill> skills;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Resume() {
    }

    public void addEducation(Education education) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations.add(education);
    }

    public void addExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.add(experience);
    }

    public void addSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.add(skill);

    }

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    public Candidate getCandidate() {
	return candidate;
    }

    @Lob
    @Column
    public String getContent() {
	return content;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Resume_Educations", joinColumns = @JoinColumn(name = "id"))
    public Set<Education> getEducations() {
	return educations;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Resume_Experiences", joinColumns = @JoinColumn(name = "id"))
    public Set<Experience> getExperiences() {
	return experiences;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return this.id;
    }

    @Column
    public String getObjective() {
	return objective;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Resume_Skills", joinColumns = @JoinColumn(name = "id"))
    public Set<Skill> getSkills() {
	return skills;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    @PostConstruct
    private void init() {
	educations = new HashSet<Education>();
	experiences = new HashSet<Experience>();
	skills = new HashSet<Skill>();
    }

    public void removeEducation(Education education) {
	this.educations.remove(education);
    }

    public void removeExperience(Experience experience) {
	if (experiences == null)
	    experiences = new HashSet<>();
	else
	    this.experiences.remove(experience);
    }

    public void removeSkill(Skill skill) {
	if (skills == null)
	    skills = new HashSet<>();
	else
	    this.skills.remove(skill);
    }

    public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public void setEducations(Set<Education> educations) {
	if (educations == null)
	    educations = new HashSet<>();
	else
	    this.educations = educations;
    }

    public void setExperiences(Set<Experience> experiences) {
	this.experiences = experiences;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

    public void setObjective(String objective) {
	this.objective = objective;
    }

    public void setSkills(Set<Skill> skills) {
	this.skills = skills;
    }

}