package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jpa.models.Blog;
import br.com.codecode.workix.jpa.models.Comment;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

/**
 * This ManagedBean controls Blogs Fragment on HomePage and 404 page
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
 */
@Model
public class BlogsMB extends BaseMB {

    @Inject
    @Generic
    private Crud<Blog> dao;

    @Inject
    @Generic
    private Crud<Comment> daoComment;

    private DataModel<Blog> list;

    private DataModel<Comment> comments;

    @PostConstruct
    @Override
    protected void init() {
        list = new ListDataModel<>(dao.listAll(0, Integer.MAX_VALUE));

        comments = new ListDataModel<>(daoComment.listAll(0, Integer.MAX_VALUE));
    }


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


}
