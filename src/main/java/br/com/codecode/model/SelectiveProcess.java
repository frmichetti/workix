package br.com.codecode.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import br.com.codecode.model.scaffold.Candidate;

public class SelectiveProcess extends Observable implements Observer,Serializable  {

	private static final long serialVersionUID = -8009482242264135346L;

	public Collection<Candidate> candidates = new ArrayList<>();	

	public boolean active;	

	public int maxCandidates;

	public SelectiveProcess() {
		this.addObserver(this);	
	}

	public boolean registerCandidate(Candidate candidate){

		boolean b = false;

		if(active && isElegible()){

			candidates.add(candidate);			

			System.out.println(candidate.getName() + " Registered with Success");

			b = true;

		}else{

			System.out.println(candidate.getName() + " Cannot Register - Process is Disabled");

			b = false;
		}

		notifyChanges(candidates);

		return b;

	}


	@Override
	public void update(Observable observable, Object object) {		

		if(observable instanceof SelectiveProcess){			

			if(active = isElegible()){

				if(object instanceof ArrayList<?>){								

					countCandidates((ArrayList<?>) object);

				}

			}else{
				System.out.println("Max candidates Reached - Disabled Process at " + Instant.now());
			}


		}

	}

	private boolean isElegible(){
		System.out.println("[" + candidates.size() + "/" + maxCandidates+ "]");
		return (candidates.size() < maxCandidates);
	}

	private void countCandidates(Collection<?> collection){		
		maxCandidates = collection.size();
		System.out.println("Registered Candidates = " + maxCandidates);
	}


	private void notifyChanges(){		
		notifyObservers();
		setChanged();
	}

	private void notifyChanges(Object object){		
		notifyObservers(object);
		setChanged();
	}



}
