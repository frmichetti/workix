package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jsf.util.helper.Paginator;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This ManagedBean controls candidates.xhtml and candidates2.xhtml
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
 */
@Model
public class CandidatesMB extends BaseMB {

    private final List<Integer> pager = new ArrayList<>();
    @Inject
    @Factory
    @Default
    private FacesContext facesContext;
    @Inject
    @Generic
    private Crud<Candidate> dao;
    private DataModel<Candidate> list;

    private String prefix, sufix;
    private int start, end, totalRows, totalPages;
    @Min(1)
    private int page;

    /**
     * @return the pager
     */
    public List<Integer> getPager() {
        return pager;
    }

    /**
     * Must be Called by f:viewAction After f:viewParam {page}
     */
    @Override
    public void init() {

        try {

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

        } catch (Exception e) {

            e.printStackTrace();

            goToErrorPage();
        }

        prefix = "/" + facesContext.getExternalContext().getContextName();

        sufix = "&faces-redirect=true";

        {
            System.out.println("Current Page : " + page);

            System.out.println("Current totalRows : " + totalRows);

            System.out.println("Current totalPages : " + totalPages);

            System.out.println("Start " + start);

            System.out.println("End " + end);
        }

        for (int x = 0; x <= totalPages; x++) {
            if (x == 0) continue;
            pager.add(x);
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public DataModel<Candidate> getList() {
        return list;
    }

    public String goToCandidateDetail(Candidate candidate) {

        System.out.println("Received Candidate " + candidate.toString());

        return prefix + "/resume.xhtml?id=" + String.valueOf(candidate.getId()) + sufix;
    }

    private String goToErrorPage() {

        try {

            facesContext.getExternalContext().redirect(prefix + "/404.xhtml" + sufix);

        } catch (IOException e) {

            e.printStackTrace();
        }
        return prefix + "/404.xhtml" + sufix;
    }

    public String goToLastPage() {
        return prefix + "/candidates2.xhtml?page=" + String.valueOf(totalPages) + sufix;
    }

    public String goToFirstPage() {
        return prefix + "/candidates2.xhtml?page=" + String.valueOf(1) + sufix;
    }

}
