package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import aiss.model.yelp.search.BusinessSearch;

public class SearchResource {
	
	private String uri = "https://api.yelp.com/v3/businesses/search?locale=es_ES&location=";
	private String API_KEY = "RuA5qRBALMn1KoGd59Q4yItk5lmd3bpv8lnEm8QW0za5PnrCmEKdGgWJVUcuyJwDBueNumMSJHh6fMybo0MIDUtTo6UcfHkNyBxwV2Z2QpjAehkxrXMewCf1NfPqWnYx";

	public BusinessSearch getSearch(String location, String category) throws UnsupportedEncodingException {
		String locationCodificada = URLEncoder.encode(location, "UTF-8");
		
		String uri = this.uri + locationCodificada + "&categories=" + category;
		
		ClientResource cr = new ClientResource(uri);
		
		String pAccessToken = "Bearer " + API_KEY;
		ChallengeResponse challengeResponse = new ChallengeResponse(
		                      new ChallengeScheme("", ""));
		challengeResponse.setRawValue(pAccessToken);
		cr.setChallengeResponse(challengeResponse);
		
		BusinessSearch search = cr.get(BusinessSearch.class);
		
		return search;
	}
	 
}
