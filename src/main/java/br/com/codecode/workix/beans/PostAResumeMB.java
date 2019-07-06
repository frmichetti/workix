package br.com.codecode.workix.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Candidate;
import br.com.codecode.workix.jpa.models.Resume;

/**
 * This ManagedBean controls post-a-resume.xhtml
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
 */
@Model
public class PostAResumeMB extends BaseMB {

    @Inject
    @Generic
    private Crud<Resume> dao;

    @Inject
    @Generic
    private Crud<Candidate> candidateDao;

    @Inject
    @Persist
    private Resume currentResume;

    private List<Candidate> candidates;

    @PostConstruct
    @Override
    protected void init() {

        candidates = candidateDao.listAll(0, 100);

        debug();

    }

    private void debug() {
        currentResume.setContent("STUB CONTENT HERE");
        currentResume.setObjective("STUB OBJECTIVE");
        currentResume.setCandidate(candidates.get(candidates.size() - 1));

    }

    public Resume getCurrentResume() {
        return currentResume;
    }

    public void setCurrentResume(Resume currentResume) {
        this.currentResume = currentResume;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void commit() {

        dao.save(currentResume);

    }

}
