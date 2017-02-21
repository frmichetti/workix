package br.com.codecode.workix.beans;

import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.validation.constraints.Min;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Blog;
import br.com.codecode.workix.jpa.models.Comment;

/**
 * This ManagedBean controls Blogs List
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class BlogListMB extends BaseMB {
    
    private DataModel<Comment> comments;
    
    @Inject
    @Generic
    private Crud<Blog> dao;
    
    @Inject
    @Generic
    private Crud<Comment> daoComment;
    
    /**
     * Max Results By Page
     */
    private final int limitRows = 10;
    
    private DataModel<Blog> list;

    @Min(1)
    private int page;

    private int start, end, totalRows, totalPages;

    /**
     * @return the comments
     */
    public DataModel<Comment> getComments() {
        return comments;
    }

    
    
    /**
     * @return the list
     */
    public DataModel<Blog> getList() {
        return list;
    }


    public int getPage() {
	return page;
    }
    
    public int getTotalPages() {
	return totalPages;
    }
    
    @Override
    public void init() {
	
	try {
	    
	    list = new ListDataModel<Blog>(dao.listAll(0, Integer.MAX_VALUE));
	    
	    comments = new ListDataModel<Comment>(daoComment.listAll(0, Integer.MAX_VALUE));
	    
	    
	    
	} catch (NotImplementedYetException e) {	    
	    e.printStackTrace();
	}	

    }

    public void setPage(int page) {
	this.page = page;
    }
    
    

}
