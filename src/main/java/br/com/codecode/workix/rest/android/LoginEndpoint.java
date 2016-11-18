package br.com.codecode.workix.rest.android;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.User;


@Path("login")
public class LoginEndpoint {

	@Inject @Default
	private EntityManager em;

	@POST
	@Path("firebaselogin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response doLogin(Token token) {

		System.out.println("[doLogin]");

		System.out.println("[IN <--]");

		if (token == null) {

			return Response.status(Status.BAD_REQUEST).build();

		}else if((token.getKey().equals("")) || (token.getKey().isEmpty())){

			System.err.println("!!! Unauthorized !!!");

			return Response.status(Status.UNAUTHORIZED).build();

		}

		System.out.println(token);		

		User user;	

		try {

			user = em.createQuery(
					"select u from User u where u.firebaseUUID=:firebaseUUID",
					User.class)
					.setParameter("firebaseUUID", token.getKey())
					.getSingleResult();				

		} catch (NoResultException nre) {

			user = null;

			System.err.println(nre);

		}

		if (user == null) {

			//return Response.status(Status.NOT_FOUND).build();
			return Response.ok("{}").build();

		}


		//TODO Verify for user Owner //

		Candidate candidate;			

		try {

			candidate = em
					.createQuery(
							"select c from Candidate c where c.user=:user",
							Candidate.class)
					.setParameter("user", user)
					.getSingleResult();

		} catch (NoResultException nre) {

			candidate = null;

			System.err.println(nre);

		}

		System.out.println("[OUT -->]");

		if (candidate == null) {			

			candidate = new Candidate();

			candidate.setUser(user);

			return Response.ok(candidate).build();	

		}

		System.out.println(candidate.toString());

		return Response.ok(candidate).build();	

	}	

}
