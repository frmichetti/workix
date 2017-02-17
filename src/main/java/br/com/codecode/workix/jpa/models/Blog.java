package br.com.codecode.workix.jpa.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.cdi.qualifiers.Persist;

/**
 * Blog JPA with Inherited Fields and Methods
 * 
 * @see MyEntity
 * @author felipe
 * 
 * @since 1.0
 * @version 1.0
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Blog extends MyEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -5273926504177459295L;
    
    private List<Author> authors;

    private BlogCategory blogCategory;

    private List<Comment> comments;

    private LocalDate date;

    private long id;

    private List<String> pictures;    

    private List<Tag> tags;
    
    private String title;    

    
    public void addAuthor(Author author){
	if(author == null){
	    authors = new ArrayList<>();
	}

	authors.add(author);
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
    public List<Author> getAuthors() {
	return authors;
    }

    /**
     * @return the blogCategory
     */
    public BlogCategory getBlogCategory() {
	return blogCategory;
    }



    /**
     * @return the comments
     */
    public List<Comment> getComments() {
	return comments;
    }



    /**
     * @return the date
     */
    public LocalDate getDate() {
	return date;
    }


    @Override
    public long getId() {
	return id;
    }


    /**
     * @return the pictures
     */
    public List<String> getPictures() {
        return pictures;
    }


    /**
     * @return the tags
     */
    public List<Tag> getTags() {
	return tags;
    }


    public String getTitle() {
	return title;
    }

    public void removeAuthor(Author author){
	if(author == null){
	    authors = new ArrayList<>();
	}

	authors.remove(author);
    }

    public void removeTag(Tag tag){
	if(tags == null){
	    tags = new ArrayList<>();
	}
	tags.remove(tag);
    }


    /**
     * @param author the author to set
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
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
	this.comments = comments;
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
     * @param tags the tags to set
     */
    public void setTags(List<Tag> tags) {
	this.tags = tags;
    }

    public void setTitle(String title) {
	this.title = title;
    }

}
