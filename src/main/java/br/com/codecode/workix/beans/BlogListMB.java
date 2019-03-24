package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jpa.models.Blog;
import br.com.codecode.workix.jpa.models.Comment;
import br.com.codecode.workix.jsf.util.helper.Paginator;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * This ManagedBean controls Blogs List
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
 */
@Model
public class BlogListMB extends BaseMB {

    private DataModel<Comment> comments;

    @Inject
    @Factory
    @Default
    private FacesContext facesContext;

    @Inject
    @Generic
    private Crud<Blog> dao;

    @Inject
    @Generic
    private Crud<Comment> daoComment;

    private DataModel<Blog> list;

    private String prefix, sufix;

    @Min(1)
    private int page;

    private int start;
    private int end;
    private int totalPages;

    private final List<Integer> pager = new ArrayList<>();


    /**
     * @return the pager
     */
    public List<Integer> getPager() {
        return pager;
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


    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public void init() {

        int totalRows;

        totalRows = dao.countRegisters().intValue();

            /*
      Max Results By Page
     */
        int limitRows = 10;
        Paginator paginator = new Paginator(limitRows, page, totalRows);

        totalPages = paginator.getTotalPages();

        start = paginator.getStart();

        end = paginator.getEnd();

        list = new ListDataModel<>(dao.listAll(start - 1, limitRows));

        comments = new ListDataModel<>(daoComment.listAll(0, limitRows));


        prefix = "/" + facesContext.getExternalContext().getContextName();

        sufix = "&faces-redirect=true";

        for (int x = 0; x <= totalPages; x++) {

            if (x == 0) continue;

            pager.add(x);
        }

        debug:
        {
            System.out.println("Current Page : " + page);

            System.out.println("Total Rows : " + totalRows);

            System.out.println("Total Pages : " + totalPages);

            System.out.println("Start " + start);

            System.out.println("End " + end);
        }


    }

    public void setPage(int page) {
        this.page = page;
    }

    public String goToLastPage() {
        return prefix + "/blog.xhtml?page=" + String.valueOf(totalPages) + sufix;
    }

    public String goToFirstPage() {
        return prefix + "/blog.xhtml?page=" + String.valueOf(1) + sufix;
    }


}
