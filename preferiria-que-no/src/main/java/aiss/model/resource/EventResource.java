package aiss.model.resource;

import org.restlet.resource.ClientResource;
import aiss.model.calendar.CalendarEvent;

public class EventResource {

	private String uri = "https://www.googleapis.com/calendar/v3/calendars/primary/events";
	private String access_token = null;
	
	public EventResource(String access_token) {
		this.access_token = access_token;
	}
	
	public boolean createEvent(CalendarEvent event) {
		ClientResource cr = new ClientResource(this.uri + "?access_token="
				+ this.access_token);
		cr.post(event);
		return true;
	}

}
