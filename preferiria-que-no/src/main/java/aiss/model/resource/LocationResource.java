package aiss.model.resource;

import org.restlet.resource.ClientResource;
import aiss.model.geocoding.CurrentLocation;

public class LocationResource {
	
	private String uri ="https://maps.googleapis.com/maps/api/geocode/json?latlng=";
	private String API_KEY = "AIzaSyAtVQaOBZvu3WtsYfZu7L8qnWlitTTBZi4";
	
	public CurrentLocation getLocation(String lat, String lon) {
		String uri = this.uri + lat + "," + lon + "&key=" + API_KEY;
		ClientResource cr = new ClientResource(uri);
		
		CurrentLocation currentLocation = cr.get(CurrentLocation.class);
		
		return currentLocation;
	}
}
