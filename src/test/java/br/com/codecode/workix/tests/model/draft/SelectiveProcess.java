package br.com.codecode.workix.tests.model.draft;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import br.com.codecode.workix.jpa.models.Candidate;

/**
 * TDD for Class {@link SelectiveProcess}
 * 
 * @author felipe
 */
public class SelectiveProcess extends Observable implements Observer, Serializable {

    private static final long serialVersionUID = -8009482242264135346L;

    private Collection<Candidate> candidates = new ArrayList<>();

    private boolean active;

    private Instant disabledAt;

    private int maxCandidates;

    public SelectiveProcess() {
	this.addObserver(this);
    }

    public Collection<Candidate> getCandidates() {
	return candidates;
    }

    public void setCandidates(Collection<Candidate> candidates) {
	this.candidates = candidates;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {

	if (!active) {
	    disabledAt = Instant.now();
	}

	this.active = active;

	notifyChanges();
    }

    public Instant getDisabledAt() {
	return disabledAt;
    }

    public void setDisabledAt(Instant disabledAt) {
	this.disabledAt = disabledAt;
    }

    public int getMaxCandidates() {
	return maxCandidates;
    }

    public void setMaxCandidates(int maxCandidates) {
	this.maxCandidates = maxCandidates;
    }

    public boolean registerCandidate(Candidate candidate) {

	boolean b = false;

	if ((isActive()) && (isElegible()) && (!isInProcess(candidate))) {

	    candidates.add(candidate);

	    System.out.println(candidate.getName() + " Registered with Success");

	    b = true;

	} else {

	    System.out.println(candidate.getName() + " Cannot Registered");

	    b = false;
	}

	notifyChanges(candidates);

	return b;

    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(Observable observable, Object object) {

	if (observable instanceof SelectiveProcess) {

	    if (active = isElegible()) {

		if (object instanceof Collection<?>) {

		    countCandidates(((ArrayList<Candidate>) object));

		}

	    } else {
		if (disabledAt != null)
		    System.out.println("Max candidates Reached - Disabled Process at " + disabledAt);
	    }

	}

    }

    private boolean isElegible() {
	System.out.println("Process is Elegible " + (candidates.size() < maxCandidates));
	System.out.println("Candidates --> [" + candidates.size() + "/" + maxCandidates + "]");
	return (candidates.size() < maxCandidates);
    }

    private boolean isInProcess(Candidate candidate) {
	System.out.println(candidate.getName() + " are in this process ? " + (candidates.contains(candidate)));
	return (candidates.contains(candidate));
    }

    private void countCandidates(ArrayList<Candidate> collection) {
	maxCandidates = collection.size();
    }

    private void notifyChanges() {
	notifyObservers();
	setChanged();
    }

    private void notifyChanges(Object object) {
	notifyObservers(object);
	setChanged();
    }

    @Override
    public String toString() {
	return "SelectiveProcess [active=" + active + ", maxCandidates=" + maxCandidates + "]";
    }

}
