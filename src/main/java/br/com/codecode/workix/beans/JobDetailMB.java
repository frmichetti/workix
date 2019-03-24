package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Factory;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jsf.util.helper.MessagesHelper;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Job Detail ManagedBean
 *
 * @author felipe
 * @see BaseMB
 */
@Model
public class JobDetailMB extends BaseMB {

    private Job currentJob;

    @Inject
    @Generic
    private Crud<Job> dao;

    @Inject
    @Factory
    @Default
    private FacesContext facesContext;

    private long id;


    private List<Job> jobs;

    @Inject
    private MessagesHelper messagesHelper;

    private String prefix, sufix;

    public Job getCurrentJob() {
        return currentJob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the jobs
     */
    public List<Job> getJobs() {
        return jobs;
    }

    private String goToErrorPage() {

        try {

            facesContext.getExternalContext().redirect(prefix + "/404.xhtml" + sufix);

        } catch (IOException e) {

            e.printStackTrace();
        }
        return prefix + "/404.xhtml" + sufix;
    }

    /**
     * Must be Called by f:viewAction After f:viewParam {page}
     */
    @Override
    public void init() {

        prefix = facesContext.getExternalContext().getRequestContextPath();

        sufix = "?faces-redirect=true";

        System.out.println("JOB ID RECEIVED -> " + id);

        if (id < 1)
            goToErrorPage();
        else

            try {

                currentJob = dao.findById(id);

                jobs = dao.listAll(0, Integer.MAX_VALUE)
                        .stream()
                        .filter(j -> j.getCompany() == currentJob.getCompany())
                        .filter(j -> j.getId() != currentJob.getId())
                        .collect(Collectors.toList());

            } catch (NotImplementedYetException | NoResultException e) {

                e.printStackTrace();

                goToErrorPage();

            }

        if (currentJob == null) {
            goToErrorPage();
        }

    }

    public void signup() {
        messagesHelper.addFlash(new FacesMessage("Você foi inscrito com Sucesso !"));

    }

}
