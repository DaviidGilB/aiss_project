package aiss.model.resource;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

import aiss.model.yelp.details.BusinessDetails;

public class BusinessResource {

	private String uri = "https://api.yelp.com/v3/businesses/";
	private String API_KEY = "RuA5qRBALMn1KoGd59Q4yItk5lmd3bpv8lnEm8QW0za5PnrCmEKdGgWJVUcuyJwDBueNumMSJHh6fMybo0MIDUtTo6UcfHkNyBxwV2Z2QpjAehkxrXMewCf1NfPqWnYx";

	public BusinessDetails getBusiness(String id) {
		String uri = this.uri + id + "?locale=es_ES";
		
		ClientResource cr = new ClientResource(uri);
		
		String pAccessToken = "Bearer " + API_KEY;
		ChallengeResponse challengeResponse = new ChallengeResponse(
		                      new ChallengeScheme("", ""));
		challengeResponse.setRawValue(pAccessToken);
		cr.setChallengeResponse(challengeResponse);
		
		BusinessDetails details = cr.get(BusinessDetails.class);
		
		return details;
	}
	
}
