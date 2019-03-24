package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.enums.JobType;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jsf.util.helper.JobTypeLinkHelper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import java.util.List;

/**
 * This ManagedBean controls Jobs Fragment on HomePage
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
 */
@Model
public class JobsFragment extends BaseMB {

    @Inject
    @Generic
    private Crud<Job> dao;

    @Inject
    private JobTypeLinkHelper jobTypeLinkHelper;

    private DataModel<Job> visible, hidden;

    private Job featuredJob;

    public String discoverBadge(JobType jobType) {
        return jobTypeLinkHelper.returnType(jobType);
    }


    /**
     * @return the featuredJob
     */
    public Job getFeaturedJob() {
        return featuredJob;
    }

    @PostConstruct
    @Override
    protected void init() {

        List<Job> jobs = dao.listAll(0, 10);

        if (jobs.size() > 0) {

            visible = new ListDataModel<>(jobs.subList(0, 5));

            hidden = new ListDataModel<>(jobs.subList(5, 10));

            featuredJob = jobs.stream().filter(j -> j.getJobType() == JobType.FULLTIME)
                    .findFirst().orElse(jobs.get(jobs.size() - 1));
        }

    }

    /**
     * @return the Show list
     */
    public DataModel<Job> getVisible() {
        return visible;
    }


    /**
     * @return the Hidden list
     */
    public DataModel<Job> getHidden() {
        return hidden;
    }

}
