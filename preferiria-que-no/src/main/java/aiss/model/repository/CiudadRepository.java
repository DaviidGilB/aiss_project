package aiss.model.repository;

import java.util.Collection;

import aiss.model.restaurant.Ciudad;
import aiss.model.restaurant.Restaurante;

public interface CiudadRepository {
	
	//Restaurantes
	public void addRestaurante(Restaurante r);
	public Collection<Restaurante> getAllRestaurantes();
	public Restaurante getRestaurante(String id);
	public void updateRestaurante(Restaurante r);
	public void deleteRestaurante(String id);
	
	//Ciudades
	public void addCiudad(Ciudad c);
	public Collection<Ciudad> getAllCiudades();
	public Ciudad getCiudad(String id);
	public void updateCiudad(Ciudad c);
	public void deleteCiudad(String id);
	public Collection<Restaurante> getAll(String ciudadId);
	public void addRestaurante(String ciudadId,String restauranteId);
	public void removeRestaurante(String ciudadId,String restauranteId);

}
