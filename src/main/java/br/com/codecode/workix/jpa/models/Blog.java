package br.com.codecode.workix.jpa.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Blog JPA with Inherited Fields and Methods
 * 
 * @see MyEntity
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Blog extends MyEntity {

    /**
     * @serialField
     */
    private static final long serialVersionUID = -5273926504177459295L;

    private List<Author> authors;

    private BlogCategory blogCategory;    

    private String citation;
    
    private String content;        
    
    private LocalDate date;
    
    private long id;

    private List<String> pictures;

    private String resume;

    private List<Tag> tags;    

    private String title;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Blog(){}
    
    private Blog(Builder builder) {
	this.authors = builder.getAuthors();
	this.blogCategory = builder.getBlogCategory();
	this.citation = builder.getCitation();
	this.content = builder.getContent();
	this.date = builder.getDate();
	this.id = builder.getId();
	this.pictures = builder.getPictures();
	this.resume = builder.getResume();
	this.tags = builder.getTags();
	this.title = builder.getTitle();
    }

    /**
     * Creates builder to build {@link Blog}.
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }


    public void addAuthor(Author author){
	if(authors == null){
	    authors = new ArrayList<>();
	}

	authors.add(author);
    }

    public void addPicture(String picture){
	if(pictures == null){
	    pictures = new ArrayList<>();
	}

	pictures.add(picture);
    }

    public void addTag(Tag tag){
	if(tags == null){
	    tags = new ArrayList<>();
	}
	tags.add(tag);
    }

    /**
     * @return the author
     */
    @NotNull    
    @ManyToMany(fetch=FetchType.EAGER,targetEntity=Author.class)
    public List<Author> getAuthors() {
	return authors;
    }


    /**
     * @return the blogCategory
     */    
    @Enumerated(EnumType.STRING)
    public BlogCategory getBlogCategory() {
	return blogCategory;
    }

    /**
     * @return the citation
     */
    @Column
    @Lob
    public String getCitation() {
        return citation;
    }

    /**
     * @return the content
     */
    @Column
    @Lob
    public String getContent() {
	return content;
    }

    /**
     * @return the date
     */
    @Column
    public LocalDate getDate() {
	return date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return id;
    }

    /**
     * @return the pictures
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Blog_Images", joinColumns = @JoinColumn(name = "id"))
    public List<String> getPictures() {
	return pictures;
    }


    /**
     * @return the resume
     */
    @Column
    @Lob
    public String getResume() {
	return resume;
    }


    /**
     * @return the tags
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Blog_Tags", joinColumns = @JoinColumn(name = "id"))
    public List<Tag> getTags() {
	return tags;
    }


    @Column
    public String getTitle() {
	return title;
    }


    public void removeAuthor(Author author){
	if(authors == null){
	    authors = new ArrayList<>();
	}

	authors.remove(author);
    }

    public void removePicture(String picture){
	if(pictures == null){
	    pictures = new ArrayList<>();
	}

	pictures.remove(picture);
    }

    public void removeTag(Tag tag){
	if(tags == null){
	    tags = new ArrayList<>();
	}
	tags.remove(tag);
    }

    /**
     * @param authors the author to set
     */
    public void setAuthors(List<Author> authors) {
	this.authors = authors;
    }

    /**
     * @param blogCategory the blogCategory to set
     */
    public void setBlogCategory(BlogCategory blogCategory) {
	this.blogCategory = blogCategory;
    }


    /**
     * @param citation the citation to set
     */
    public void setCitation(String citation) {
        this.citation = citation;
    }


    /**
     * @param content the content to set
     */
    public void setContent(String content) {
	this.content = content;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
	this.date = date;
    }

    @Override
    public void setId(long id) {
	this.id = id;	
    }

    /**
     * @param pictures the pictures to set
     */
    public void setPictures(List<String> pictures) {
	this.pictures = pictures;
    }

    /**
     * @param resume the resume to set
     */
    public void setResume(String resume) {
	this.resume = resume;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<Tag> tags) {
	this.tags = tags;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * Builder to build {@link Blog}.
     */    
    public static final class Builder extends Blog implements Buildable<Blog> {

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = -6727265310553560126L;	

	private Builder() {}

	@Override
	public Blog build() {
	    return new Blog(this);
	}

	public Builder withAuthors(List<Author> authors) {
	    super.authors = authors;
	    return this;
	}

	public Builder withBlogCategory(BlogCategory blogCategory) {
	    super.blogCategory = blogCategory;
	    return this;
	}

	public Builder withCitation(String citation) {
	    super.citation = citation;
	    return this;
	}

	public Builder withContent(String content) {
	    super.content = content;
	    return this;
	}

	public Builder withDate(LocalDate date) {
	    super.date = date;
	    return this;
	}

	public Builder withId(long id) {
	    super.id = id;
	    return this;
	}

	public Builder withPictures(List<String> pictures) {
	    super.pictures = pictures;
	    return this;
	}

	public Builder withResume(String resume) {
	    super.resume = resume;
	    return this;
	}

	public Builder withTags(List<Tag> tags) {
	    super.tags = tags;
	    return this;
	}

	public Builder withTitle(String title) {
	    super.title = title;
	    return this;
	}
    }

}
