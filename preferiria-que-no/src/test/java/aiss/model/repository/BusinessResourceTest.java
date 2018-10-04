package aiss.model.repository;

import static org.junit.Assert.*;
import org.junit.Test;
import aiss.model.resource.BusinessResource;
import aiss.model.yelp.details.BusinessDetails;
public class BusinessResourceTest {
	
    BusinessResource resource = new BusinessResource();

	@Test
	public void testGetBusiness() {
		String id = "v6FJn3xgZ5DB7cvEnWBGIg";
		BusinessDetails business = resource.getBusiness(id);
		assertTrue("No se corresponde el nombre del restaurante con el indicado", business.getName().equals("HOB - House of Burger"));
	}
	
	@Test
	public void testGetBusiness2() {
		String id = "v6FJn3xgZ5DB7cvEnWBGIg";
		BusinessDetails business = resource.getBusiness(id);
		assertNotNull("La respuesta es nula", business!=null);
	}

}
