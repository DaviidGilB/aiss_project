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
import aiss.model.restaurant.Restaurante;

@Path("/restaurants")
public class RestaurantResource {
	
	public static RestaurantResource _instance=null;
	CiudadRepository repository;
	
	private RestaurantResource() {
		repository = (CiudadRepository) MapCiudadRepository.getInstance();
	}
	
	public static RestaurantResource getInstance() {
		if(_instance==null) {
			_instance = new RestaurantResource();
		}
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<Restaurante> getAll(){
		return repository.getAllRestaurantes();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Restaurante get(@PathParam("id") String restauranteId) {
		Restaurante restaurante = repository.getRestaurante(restauranteId);
		if(restaurante==null) {
			throw new NotFoundException("El restaurante con id= " + restauranteId + " no ha sido encontrado");
		}
		return restaurante;
		
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public javax.ws.rs.core.Response addRestaurante(@Context UriInfo uriInfo, Restaurante restaurante) {		//Aquí he tenido que cambiar el return type
		if(restaurante.getNombre()==null || "".equals(restaurante.getNombre())) {
			throw new BadRequestException("El nombre del Restaurante no puede ser null");
		}
		if(restaurante.getCategoria()==null || "".equals(restaurante.getCategoria())) {
			throw new BadRequestException("La categoría del Restaurante no puede ser null");
		}if(restaurante.getDireccion()==null || "".equals(restaurante.getDireccion())) {
			throw new BadRequestException("La dirección del Restaurate no puede ser null");
		}
		repository.addRestaurante(restaurante);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(),"get");
		URI uri = ub.build(restaurante.getId());
		ResponseBuilder resp = javax.ws.rs.core.Response.created(uri);
		resp.entity(restaurante);
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateRestaurante(Restaurante restaurante) {
		Restaurante oldRestaurante = repository.getRestaurante(restaurante.getId());
		if(oldRestaurante==null) {
			throw new NotFoundException("El restaurante con id= " + restaurante.getId() + " no ha sido encontrada");
		}
		if(restaurante.getNombre()!=null) {
			oldRestaurante.setNombre(restaurante.getNombre());
		}if(restaurante.getCategoria()!=null) {
			oldRestaurante.setCategoria(restaurante.getCategoria());
		}if(restaurante.getDireccion()!=null) {
			oldRestaurante.setDireccion(restaurante.getDireccion());
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeRestaurant(@PathParam("id") String restauranteId) {
		Restaurante restauranteRemoved = repository.getRestaurante(restauranteId);
		if(restauranteRemoved == null) {
			throw new NotFoundException("El restaurante con id = " + restauranteId + " no ha sido encontrado");
		}else {
			repository.deleteRestaurante(restauranteId);
		}
		return Response.noContent().build();
	}	
}
