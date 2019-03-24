package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.jpa.models.jdk7.Resume;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * This ManagedBean controls Counter Fragment on HomePage
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
 */
@Model
public class StatsMB extends BaseMB {

    @Inject
    @Generic
    private Crud<Job> jobDao;

    @Inject
    @Generic
    private Crud<Company> companyDao;

    @Inject
    @Generic
    private Crud<Candidate> candidateDao;

    @Inject
    @Generic
    private Crud<Resume> resumeDao;

    private int counterJobs, counterCandidates, counterEmployeers, counterResumes;

    @PostConstruct
    @Override
    protected void init() {

        jobDao.countRegisters();

        counterJobs = jobDao.countRegisters().intValue();

        counterEmployeers = companyDao.countRegisters().intValue();

        counterCandidates = candidateDao.countRegisters().intValue();

        counterResumes = resumeDao.countRegisters().intValue();


    }

    public int getCounterJobs() {
        return counterJobs;
    }

    public int getCounterCandidates() {
        return counterCandidates;
    }

    public int getCounterEmployeers() {
        return counterEmployeers;
    }

    public int getCounterResumes() {
        return counterResumes;
    }

}
