package br.com.codecode.workix.rest.scaffold;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.com.codecode.workix.config.JaxRsConfiguration;
import br.com.codecode.workix.model.jpa.Resume;

/**
 * JaxRs Endpoint for {@link Resume}
 * @see JaxRsConfiguration
 */
@Stateless
@Path("resumes")
public class ResumeEndpoint extends BaseEndpoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Resume entity) {

		em.persist(entity);

		return Response.created(
				UriBuilder.fromResource(ResumeEndpoint.class)
				.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {

		Resume entity = em.find(Resume.class, id);

		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		em.remove(entity);

		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {

		TypedQuery<Resume> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT r FROM Resume r LEFT JOIN FETCH r.candidate WHERE r.id = :entityId ORDER BY r.id",
						Resume.class);

		findByIdQuery.setParameter("entityId", id);

		Resume entity;

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
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resume> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {

		TypedQuery<Resume> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT r FROM Resume r LEFT JOIN FETCH r.candidate ORDER BY r.id",
						Resume.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}

		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}

		final List<Resume> results = findAllQuery.getResultList();

		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Resume entity) {

		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}

		if (em.find(Resume.class, id) == null) {
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
