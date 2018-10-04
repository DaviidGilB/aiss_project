package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import aiss.model.calendar.CalendarEvent;
import aiss.model.calendar.End;
import aiss.model.calendar.Start;
import aiss.model.resource.EventResource;
import aiss.utility.ASCII;

/**
 * Servlet implementation class ToCalendarController
 */
public class ToCalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(ToCalendarController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToCalendarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken=(String)request.getSession().getAttribute("GoogleCalendar-token");
		
		if(accessToken!=null) {
			log.log(Level.FINE, "accesToken cargado con éxito.");
		} else {
			log.log(Level.WARNING, "No se ha realizado la carga del parámetro ID");
			request.setAttribute("message", "No se ha realizado la carga del parámetro ID");
			request.getRequestDispatcher("/ErrorView.jsp").forward(request, response);
		}
		
		String summary = request.getParameter("summary");
		String description = request.getParameter("description");
		String location = request.getParameter("location");
		String start = request.getParameter("start");
		String time = request.getParameter("time");
		
		if(summary!=null && description!=null && location!=null && start!=null && time!=null) {
			log.log(Level.FINE, "Parámetros cargados con éxito");
		} else {
			log.log(Level.WARNING, "No se ha realizado la carga los parámetros");
			request.setAttribute("message", "No se ha realizado la carga de los parámetros");
			request.getRequestDispatcher("/ErrorView.jsp").forward(request, response);
		}
		
		String[] fecha = start.split("-");
		Integer año = new Integer(fecha[0].trim());
		Integer mes = new Integer(fecha[1].trim());
		Integer dia = new Integer(fecha[2].trim());
		
		String[] tiempo = time.split(":");
		Integer hora = new Integer(tiempo[0].trim());
		Integer minutos = new Integer(tiempo[1].trim());
		
		DateTime fecha1 = new DateTime(año, mes, dia, hora, minutos, DateTimeZone.forID("Europe/Madrid"));
		DateTimeFormatter dateFormatter = ISODateTimeFormat.dateTime();
		String startRFC = dateFormatter.print(fecha1);
		
		DateTime fecha2 = new DateTime(año, mes, dia, hora+1, minutos, DateTimeZone.forID("Europe/Madrid"));
		String endRFC = dateFormatter.print(fecha2);		
		
		//Objeto
		CalendarEvent event = new CalendarEvent();
		End endObject = new End();
		Start startObject = new Start();
		
		endObject.setDateTime(endRFC);
		startObject.setDateTime(startRFC);
		event.setEnd(endObject);
		event.setStart(startObject);
		event.setStatus("confirmed");
		event.setSummary(summary);
		event.setDescription(description);
		event.setLocation(location);
		
		EventResource e = new EventResource(accessToken);
		e.createEvent(event);
		
		log.log(Level.INFO, "Evento creado con éxito");
		
		request.setAttribute("name", summary);
		request.getRequestDispatcher("/SuccessView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
