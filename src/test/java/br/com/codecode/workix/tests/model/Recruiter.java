package br.com.codecode.workix.tests.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.codecode.workix.model.scaffold.Candidate;

/**
 * 
 * @author felipe
 *
 */
@Named
@ApplicationScoped
@SuppressWarnings("unchecked")
public class Recruiter extends Observable implements Observer {

	private Collection<SelectiveProcess> processes = new ArrayList<>();

	@PostConstruct
	private void init(){

		SelectiveProcess pro1,pro2,pro3;

		ArrayList<Candidate> candidates;

		Candidate c1,c2,c3;

		pro1 = new SelectiveProcess();

		pro2 = new SelectiveProcess();

		pro3 = new SelectiveProcess();

		pro1.setActive(true);		

		pro2.setActive(false);

		pro3.setActive(true);

		pro1.setMaxCandidates(1);

		pro2.setMaxCandidates(2);

		pro3.setMaxCandidates(3);

		c1 = new Candidate();

		c2 = new Candidate();

		c3 = new Candidate();

		candidates = new ArrayList<>();

		candidates.add(c1);
		candidates.add(c2);
		candidates.add(c3);


		for(int x=0 ; x < candidates.size() ;x++){
			candidates.get(x).setId(x+1L);
			candidates.get(x).setName("Candidate " + (x+1L));
		}

		this.register(pro1);

		this.register(pro2);

		this.register(pro3);

	}

	public Collection<SelectiveProcess> getProcesses() {
		return processes;
	}


	public void setProcesses(Collection<SelectiveProcess> processes) {
		this.processes = processes;
	}


	public Recruiter() {

		this.addObserver(this);

	}


	private void checkProcesses(){

		System.out.println("CheckProcess");					

	}


	public void register(SelectiveProcess selectiveProcess){		

		processes.add(selectiveProcess);

		selectiveProcess.addObserver(this);

		notifyMe(processes);		

	}

	public void unregister(SelectiveProcess selectiveProcess){

		processes.remove(selectiveProcess);

		selectiveProcess.deleteObserver(this);

		notifyMe(processes);

	}

	private void notifyMe(Collection<SelectiveProcess> selectiveProcesses){
		setChanged();
		notifyObservers(selectiveProcesses);
	}

	
	@Override
	public void update(Observable o, Object arg) {		

		checkProcesses();	

		if(o instanceof Recruiter){

			System.out.println("Observable is Recruiter");

			if(arg instanceof Collection<?>){

				System.out.println(((ArrayList<SelectiveProcess>)arg).size());
			}
		}






	}



}
