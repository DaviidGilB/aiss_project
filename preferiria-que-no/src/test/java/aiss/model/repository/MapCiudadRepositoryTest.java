package aiss.model.repository;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.restaurant.Ciudad;
import aiss.model.restaurant.Restaurante;
import javassist.NotFoundException;

public class MapCiudadRepositoryTest {
	
	private MapCiudadRepository repository;
	
	@Before
	public void before() {
		this.repository = MapCiudadRepository.getInstance();
	}
	
	@After
	public void after() {
		this.repository = MapCiudadRepository.getInstance();
	}
	
	@Test
	public void testAddCiudad() {
		Ciudad c = new Ciudad();
		c.setNombre("Nombre");
		c.setDescripcion("Descripción");
		Integer tam1 = repository.getAllCiudades().size();
		repository.addCiudad(c);
		Integer tam2 = repository.getAllCiudades().size();
		assertFalse("La ciudad no se ha añadido",
				tam1==tam2);
	}
	
	@Test
	public void testGetAllCiudades() {
		assertTrue("No existen ciudades", repository.getAllCiudades().size()>0);
	}
	
	@Test
	public void testGetCiudad() {
		Ciudad c = repository.getCiudad("c5");
		assertTrue("No existe la ciudad", c.getNombre().equals("Sevilla"));
	}
	
	@Test
	public void testUpdateCiudad() {
		Ciudad c = repository.getCiudad("c6");
		c.setNombre("Nombre");
		repository.updateCiudad(c);
		Ciudad ciud = repository.getCiudad("c6");
		assertTrue("No se ha actualizado la ciudad",
				ciud.getNombre().equals("Nombre"));
	}
	
	@Test
	public void testDeleteCiudad() {
		Integer tam1 = repository.getAllCiudades().size();
		repository.deleteCiudad("c6");
		Integer tam2 = repository.getAllCiudades().size();
		assertFalse("No se ha eliminado la ciudad",
				tam1==tam2);
	}

	
	@Test
	public void testAll() {
		Collection<Restaurante> c = repository.getAll("c5");
		assertTrue("No existen restaurantes en la ciudad",
				c.size()>0);
	}
	
	@Test
	public void testAddRestaurante() {
		Integer tam1 = repository.getCiudad("c5").getRestaurantes().size();
		repository.addRestaurante("c5", "r3");
		Integer tam2 = repository.getCiudad("c5").getRestaurantes().size();
		assertFalse("No se ha añadido el restaurante a la ciudad",
				tam1==tam2);
	}
	
	@Test
	public void testRemoveRestaurante() {
		Integer tam1 = repository.getCiudad("c5").getRestaurantes().size();
		repository.removeRestaurante("c5", "r0");
		Integer tam2 = repository.getCiudad("c5").getRestaurantes().size();
		assertFalse("No se ha eliminado el restaurante de la ciudad",
				tam1==tam2);
	}
	
	@Test
	public void testAddRestaurante2() {
		Restaurante r = new Restaurante();
		Integer tam1 = repository.getAllRestaurantes().size();
		r.setNombre("Nombre");
		repository.addRestaurante(r);
		Integer tam2 = repository.getAllRestaurantes().size();
		assertTrue("No se ha añadido el restaurante a la ciudad",
				tam1==tam2-1);
	}
	
	@Test
	public void testGetAllRestaurantes() {
		Collection<Restaurante> r = repository.getAllRestaurantes();
		assertTrue("No existen restaurantes",
				r.size()>0);
	}
	
	@Test
	public void testGetRestaurante() {
		Restaurante r = repository.getRestaurante("r0");
		assertTrue("No existe el restaurante indicado",
				r.getNombre().equals("Sushi Factory"));
	}
	
	@Test
	public void testUpdateRestaurante() {
		Restaurante r = repository.getRestaurante("r0");
		r.setNombre("Nombre");
		repository.updateRestaurante(r);
		assertTrue("No se ha actualizado el restaurante",
				r.getNombre().equals("Nombre"));
	}
	
	@Test
	public void testDeleteRestaurante()	{
		Integer tam1 = repository.getAllRestaurantes().size();
		repository.deleteRestaurante("r2");
		Integer tam2 = repository.getAllRestaurantes().size();
		assertFalse("No se ha eliminado el restaurante",
				tam1==tam2);
	}

}
