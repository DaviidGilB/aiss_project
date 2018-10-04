package aiss.model.repository;

import static org.junit.Assert.*;
import org.junit.Test;
import aiss.model.geocoding.CurrentLocation;
import aiss.model.resource.LocationResource;

public class LocationResourceTest {
	
	LocationResource resource = new LocationResource();

	@Test
	public void testGetLocation() {
		CurrentLocation location = resource.getLocation("37.358316099999996", "-5.9868621");
		assertTrue("La búsqueda no tiene resultados", location.getResults().size()>0);
	}
	
	@Test
	public void testGetLocation2() {
		CurrentLocation location = resource.getLocation("37", "-20");
		assertTrue("La búsqueda no tiene resultados", location.getResults().isEmpty());
	}

}
