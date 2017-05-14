package br.com.codecode.workix.rest.api;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import br.com.codecode.workix.jaas.models.JAASRole;

/**
 * 
 */
@Stateless
@Path("/jaasroles")
public class JAASRoleEndpoint {
	@PersistenceContext(unitName = "mysqlDS")
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(JAASRole entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(JAASRoleEndpoint.class)
						.path(String.valueOf(entity.getName())).build())
				.build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") String id) {
		JAASRole entity = em.find(JAASRole.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") String id) {
		TypedQuery<JAASRole> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT j FROM JAASRole j WHERE j.name = :entityId ORDER BY j.name",
						JAASRole.class);
		findByIdQuery.setParameter("entityId", id);
		JAASRole entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces("application/json")
	public List<JAASRole> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<JAASRole> findAllQuery = em.createQuery(
				"SELECT DISTINCT j FROM JAASRole j ORDER BY j.name",
				JAASRole.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<JAASRole> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") String id, JAASRole entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getName())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(JAASRole.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
