package br.com.codecode.workix.rest.android;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Resume;
import br.com.codecode.workix.model.scaffold.User;


@Path("save")
public class SaveOrUpdateEndpoint {
	
	@Inject
	private Event<User> alertNewUser;

	@Inject	@Generic
	private Crud<User> daoUser;
	
	@Inject @Generic
	private Crud<Candidate> daoCandidate;
	
	@Inject @Generic
	private Crud<Resume> daoResume;
	
	@Path("user")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response save(User user) {
	
		user = daoUser.saveOrUpdate(user);
		
		alertNewUser.fire(user);		
		
		return Response.ok(user).build();
	}
	
	@Path("candidate")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response save(Candidate candidate) {
	
		candidate = daoCandidate.saveOrUpdate(candidate);				
		
		return Response.ok(candidate).build();
	}
	
	@Path("resume")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response save(Resume resume) {
	
		resume = daoResume.saveOrUpdate(resume);				
		
		return Response.ok(resume).build();
	}
	
	
	
	
	
}
