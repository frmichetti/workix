package br.com.codecode.model;

import java.io.Serializable;
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
		
		if(active){
			System.out.println(candidate.getName() + "Registered with Success ");
			candidates.add(candidate);
			notifyChanges(candidates);
			b = true;
		}else{
			System.out.println("Cannot Register - Process is Disabled");
			b = false;
		}
		return b;
				
	}


	@Override
	public void update(Observable observable, Object object) {		
		
		System.out.println("[Update]");	
		
		
		if(observable instanceof SelectiveProcess){		
			
			System.out.println("[Observable instanceof Selective Process]");
			
			if(maxCandidates == candidates.size()){
			
				System.out.println("[maxCandidates == candidates.size()]");
				
				active = false;
				
				System.out.println("Max candidates Reached - Disabled Process");
				
				System.out.println("Process " + ((active) ? "Active" : "Disabled" ));
				
				if(object instanceof ArrayList<?>){
					
					System.out.println("Object instanceof ArrayList<?>");			
					
					maxCandidates = ((ArrayList<?>) object).size();					
					
					System.out.println("Registered Candidates = " + maxCandidates);
				}
				
			}
			
			
		}
		
	}
	
	private void notifyChanges(){
		System.out.println("[Notify Changes]");
		notifyObservers();
		setChanged();
	}
	
	private void notifyChanges(Object object){
		System.out.println("[Notify Changes]");
		notifyObservers(object);
		setChanged();
	}
	
	

}
