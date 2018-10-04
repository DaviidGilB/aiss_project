package aiss.model.repository;

import static org.junit.Assert.*;
import org.joda.time.DateTime;
import org.junit.Test;
import aiss.model.calendar.CalendarEvent;
import aiss.model.calendar.End;
import aiss.model.calendar.Start;
import aiss.model.resource.EventResource;

public class EventResourceTest {
	
	private static final String TOKEN 
		= "TOKEN_GOOGLE_USUARIO";
	/*
	@Test
	public void testCreateEvent() {
		EventResource r = new EventResource(TOKEN);
		CalendarEvent ev = new CalendarEvent();
		ev.setDescription("Prueba: " + DateTime.now().toString());
		ev.setSummary("Test JUnit");
		ev.setLocation("ETSII");
		Start start = new Start();
		start.setDateTime("2018-06-05T21:30:00+02:00");
		End end = new End();
		end.setDateTime("2018-06-05T22:30:00+02:00");
		ev.setStart(start);
		ev.setEnd(end);
		ev.setStatus("confirmed");
		r.createEvent(ev);
		assertTrue("No se ha creado el evento",
				ev.getSummary().equals("Test JUnit"));
	}
	*/
}
