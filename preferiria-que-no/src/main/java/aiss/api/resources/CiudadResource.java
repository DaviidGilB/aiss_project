package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.repository.CiudadRepository;
import aiss.model.repository.MapCiudadRepository;
import aiss.model.restaurant.Ciudad;
import aiss.model.restaurant.Restaurante;

@Path("/ciudades")
public class CiudadResource {
	
	private static CiudadResource _instance = null;
	CiudadRepository repository;
	
	private CiudadResource() {
		repository = (CiudadRepository) MapCiudadRepository.getInstance();	//Casting
	}
	
	public static CiudadResource getInstance() {
		if(_instance==null) {
			_instance = new CiudadResource();
		}
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<Ciudad> getAll(){
		return repository.getAllCiudades();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Ciudad get(@PathParam("id") String id) {
		Ciudad list = repository.getCiudad(id);
		
		if(list == null) {
			throw new NotFoundException("La ciudad con id= " + id + " no ha sido encontrada");
		}
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCiudad(@Context UriInfo uriInfo, Ciudad ciudad) {
		if(ciudad.getNombre() == null || "".equals(ciudad.getNombre())) {
			throw new BadRequestException("El nombre de la ciudad no puede ser vacío");
		}
		if(ciudad.getRestaurantes()!=null) {
			throw new BadRequestException("No hay restaurantes");
		}
		
		repository.addCiudad(ciudad);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(),"get");
		URI uri = ub.build(ciudad.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(ciudad);
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateCiudad(Ciudad ciudad) {
		Ciudad oldCiudad = repository.getCiudad(ciudad.getId());
		
		if(oldCiudad==null) {
			throw new NotFoundException("La propiedad ciudad no es editable");
		}
		if(ciudad.getRestaurantes()!=null) {
			throw new BadRequestException("La propiedad restaurantes no es editable");
		}
		
		//Actualizar nombre
		if(ciudad.getNombre()!=null) {
			oldCiudad.setNombre(ciudad.getNombre());
		}
		
		//Actualizar descripción
		if(ciudad.getDescripcion()!=null) {
			oldCiudad.setDescripcion(ciudad.getDescripcion());
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeCiudad(@PathParam("id") String id) {
		Ciudad toberemoved = repository.getCiudad(id);
		if(toberemoved == null) {
			throw new NotFoundException("La ciudad con id " + id + " no ha sido encontrada");
		}else {
			repository.deleteCiudad(id);
		}
		return Response.noContent().build();
	}
	
	@POST
	@Path("/{ciudadId}/{restauranteId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addRestaurante(@Context UriInfo uriInfo, @PathParam("ciudadId") String ciudadId, @PathParam("restauranteId") String restauranteId) {
		Ciudad ciudad = repository.getCiudad(ciudadId);
		Restaurante restaurante = repository.getRestaurante(restauranteId);
		
		if(ciudad==null) {
			throw new NotFoundException("La ciudad con id " + ciudadId + " no ha sido encontrada");
		}
		
		if(restaurante == null) {
			throw new NotFoundException("El restaurante con id "+ restauranteId + " no ha sido encontrado");
		}
		
		if(ciudad.getRestaurante(restauranteId)!=null) {
			throw new BadRequestException("El restaurante ya ha sido incluido");
		}
		
		repository.addRestaurante(ciudadId,restauranteId);
		
		//Construir la respuesta
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(ciudadId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(ciudad);
		return resp.build();
	}
	
	@DELETE
	@Path("/{ciudadId}/{restauranteId}")
	public Response removeRestaurante(@PathParam("ciudadId") String ciudadId, @PathParam("restauranteId") String restauranteId) {
		Ciudad ciudad = repository.getCiudad(ciudadId);
		Restaurante restaurante = repository.getRestaurante(restauranteId);
		
		if(ciudad==null) {
			throw new NotFoundException("La ciudad con id= " + ciudadId + " no ha sido encontrada");
		}
		
		if(restaurante == null) {
			throw new NotFoundException("El restaurante con id= " + restauranteId + " no ha sido encontrado");
		}
		
		repository.removeRestaurante(ciudadId, restauranteId);
		return Response.noContent().build();
	}
}
