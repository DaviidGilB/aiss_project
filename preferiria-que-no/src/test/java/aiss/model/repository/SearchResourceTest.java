package aiss.model.repository;

import static org.junit.Assert.*;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import aiss.model.resource.SearchResource;
import aiss.model.yelp.search.BusinessSearch;

public class SearchResourceTest {
	
	SearchResource resource = new SearchResource();

	@Test
	public void testGetSearch() throws UnsupportedEncodingException {
		BusinessSearch search = resource.getSearch("Sevilla", "restaurants");
		assertTrue("La búsqueda no se ha realizado correctamente", search.getBusinesses().size()>0);
	}
	
	@Test
	public void testGetSearch2() throws UnsupportedEncodingException {
		BusinessSearch search = resource.getSearch("Sevilla", "restaurants");
		assertTrue("La búsqueda no se ha realizado correctamente", search.getBusinesses().get(0).getName().equals("Eslava"));
	}

}
