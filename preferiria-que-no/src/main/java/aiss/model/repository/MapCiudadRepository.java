package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.restaurant.Ciudad;
import aiss.model.restaurant.Restaurante;

public class MapCiudadRepository implements CiudadRepository{
	
	Map<String,Ciudad> ciudadMap;
	Map<String,Restaurante> restauranteMap;
	private static MapCiudadRepository instance = null;
	private int index = 0;
	
	public static MapCiudadRepository getInstance() {
		if(instance==null) {
			instance = new MapCiudadRepository();
			instance.init();
		}
		return instance;
	}
	
	public void init() {
		ciudadMap = new HashMap<String,Ciudad>();
		restauranteMap = new HashMap<String,Restaurante>();
		
		//Crear restaurantes
		Restaurante sushiFactory = new Restaurante();
		sushiFactory.setNombre("Sushi Factory");
		sushiFactory.setCategoria("Japonés");
		sushiFactory.setDireccion("Calle Falsa 1234");
		addRestaurante(sushiFactory);
		
		Restaurante gondola = new Restaurante();
		gondola.setNombre("Góndola");
		gondola.setCategoria("Italiano");
		gondola.setDireccion("Calle Venecia 27");
		addRestaurante(gondola);
		
		Restaurante puzzles = new Restaurante();
		puzzles.setNombre("Puzzles");
		puzzles.setCategoria("Bar");
		puzzles.setDireccion("Calle Torcuato Luca de Tena 16");
		addRestaurante(puzzles);
		
		Restaurante mclarens = new Restaurante();
		mclarens.setNombre("McLarens");
		mclarens.setCategoria("Bar");
		mclarens.setDireccion("Calle Cristóbal Colón 7");
		addRestaurante(mclarens);
		
		Restaurante tacoBell = new Restaurante();
		tacoBell.setNombre("Taco Bell");
		tacoBell.setCategoria("Mexicano");
		tacoBell.setDireccion("Avenida de la Paz 39");
		addRestaurante(tacoBell);
		
		//Crear Ciudades
		
		Ciudad sevilla = new Ciudad();
		sevilla.setDescripcion("Ciudad de Sevilla");
		sevilla.setNombre("Sevilla");
		addCiudad(sevilla);
		
		Ciudad cadiz = new Ciudad();
		cadiz.setNombre("Cádiz");
		cadiz.setDescripcion("Ciudad de Cádiz");
		addCiudad(cadiz);
		
		//Añadir restaurantes a ciudad
		addRestaurante(sevilla.getId(),sushiFactory.getId());
		addRestaurante(sevilla.getId(),mclarens.getId());
		addRestaurante(sevilla.getId(),gondola.getId());
		
		addRestaurante(cadiz.getId(),puzzles.getId());
		addRestaurante(cadiz.getId(),tacoBell.getId());
		addRestaurante(cadiz.getId(),sushiFactory.getId());	
	}
	
	//Operaciones relativas a ciudades
	
	public void addCiudad(Ciudad c) {
		String id = "c" + index++;
		c.setId(id);
		ciudadMap.put(id, c);
	}

	public Collection<Ciudad> getAllCiudades(){
		return ciudadMap.values();
	}
	
	public Ciudad getCiudad(String id) {
		return ciudadMap.get(id);
	}
	
	public void updateCiudad(Ciudad c) {
		ciudadMap.put(c.getId(), c);
	}
	
	public void deleteCiudad(String id) {
		ciudadMap.remove(id);
	}
	
	public void addRestaurante(String ciudadId, String restauranteId) {
		Ciudad ciudad = getCiudad(ciudadId);
		ciudad.addRestaurante(restauranteMap.get(restauranteId));
	}
	
	public Collection<Restaurante> getAll(String ciudadId){
		return getCiudad(ciudadId).getRestaurantes();
	}
	
	public void removeRestaurante(String ciudadId, String restauranteId) {
		getCiudad(ciudadId).deleteRestaurante(restauranteId);
	}
	
	
	//Operaciones relativas a Restaurante
	
	public void addRestaurante(Restaurante r) {
		String id = "r" + index++;
		r.setId(id);
		restauranteMap.put(id, r);
	}
	
	public Collection<Restaurante> getAllRestaurantes(){
		return restauranteMap.values();
	}
	
	public Restaurante getRestaurante(String restauranteId) {
		return restauranteMap.get(restauranteId);
	}
	
	public void updateRestaurante(Restaurante r) {
		Restaurante restaurante = restauranteMap.get(r.getId());
		restaurante.setNombre(r.getNombre());
		restaurante.setCategoria(r.getCategoria());
		restaurante.setDireccion(r.getDireccion());
	}
	
	public void deleteRestaurante(String restauranteId) {
		restauranteMap.remove(restauranteId);
	}

}
