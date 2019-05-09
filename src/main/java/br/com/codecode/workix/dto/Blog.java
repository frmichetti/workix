package br.com.codecode.workix.dto;

import br.com.codecode.workix.core.enums.BlogCategory;
import br.com.codecode.workix.interfaces.Buildable;

import java.util.*;

public class Blog extends MyEntity {

	private static final long serialVersionUID = -5273926504177459295L;

	private Author author;

	private BlogCategory category;

	private String citation;

	private String content;

	private Date publishDate;

	private long id;

	private Set<String> pictures;

	private String resume;

	private Set<Tag> tags;

	private String title;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Blog(){}

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 *
	 * @see Buildable
	 * @param builder
	 *            Builder for Generate a New Blog
	 */
	private Blog(Builder builder) {
		this.author = builder.getAuthor();
		this.category = builder.getCategory();
		this.citation = builder.getCitation();
		this.content = builder.getContent();
		this.publishDate = builder.getPublishDate();
		this.pictures = builder.getPictures();
		this.resume = builder.getResume();
		this.tags = builder.getTags();
		this.title = builder.getTitle();
	}

	/**
	 * Creates builder to build {@link Blog}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	public void addPicture(String picture){
		if(pictures == null){
			pictures = new HashSet<>();
		}

		pictures.add(picture);
	}

	public void addTag(Tag tag){
		if(tags == null){
			tags = new HashSet<>();
		}
		tags.add(tag);
	}

	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}


	/**
	 * @return the blogCategory
	 */
	public BlogCategory getCategory() {
		return category;
	}

	/**
	 * @return the citation
	 */
	public String getCitation() {
		return citation;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the date
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	@Override
	public long getId() {
		return id;
	}

	/**
	 * @return the pictures
	 */
	public Set<String> getPictures() {
		return pictures;
	}

	public List<String> getPicturesAsList(){
		return new ArrayList<>(getPictures());
	}


	/**
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}


	/**
	 * @return the tags
	 */
	public Set<Tag> getTags() {
		return tags;
	}

	public String getTitle() {
		return title;
	}

	public void removePicture(String picture){
		if(pictures == null){
			pictures = new HashSet<>();
		}

		pictures.remove(picture);
	}

	public void removeTag(Tag tag){
		if(tags == null){
			tags = new HashSet<>();
		}
		tags.remove(tag);
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @param blogCategory the blogCategory to set
	 */
	public void setCategory(BlogCategory blogCategory) {
		this.category = blogCategory;
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
	public void setPublishDate(Date date) {
		this.publishDate = date;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param pictures the pictures to set
	 */
	public void setPictures(Set<String> pictures) {
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
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Builder to build {@link Blog}.
	 */
	public static final class Builder extends Blog implements Buildable<Blog> {

		private static final long serialVersionUID = -6727265310553560126L;

		/**
		 * Disabled Empty Constructor
		 */
		private Builder() {}

		/**
		 * @return a new Blog
		 */
		@Override
		public Blog build() {
			return new Blog(this);
		}

		public Builder withAuthor(Author author) {
			super.author = author;
			return this;
		}

		public Builder withBlogCategory(BlogCategory category) {
			super.category = category;
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

		public Builder withDate(Date date) {
			super.publishDate = new Date();
			return this;
		}

		public Builder withPictures(Set<String> pictures) {
			super.pictures = pictures;
			return this;
		}

		public Builder withResume(String resume) {
			super.resume = resume;
			return this;
		}

		public Builder withTags(Set<Tag> tags) {
			super.tags = tags;
			return this;
		}

		public Builder withTitle(String title) {
			super.title = title;
			return this;
		}
	}

}
