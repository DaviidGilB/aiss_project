package aiss.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.geocoding.CurrentLocation;
import aiss.model.resource.BusinessResource;
import aiss.model.resource.LocationResource;
import aiss.model.yelp.details.BusinessDetails;

/**
 * Servlet implementation class BusinessController
 */
public class BusinessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(BusinessController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id!=null) {
			log.log(Level.FINE, "ID: " + id + " cargado con éxito.");
		} else {
			log.log(Level.WARNING, "No se ha realizado la carga del parámetro ID");
			request.setAttribute("message", "No se ha realizado la carga del parámetro ID");
			request.getRequestDispatcher("/ErrorView.jsp").forward(request, response);
		}
		
		request.setAttribute("id", id);
		BusinessResource resource = new BusinessResource();
		BusinessDetails business = resource.getBusiness(id);
		
		log.log(Level.INFO, "Objeto restaurante creado con éxito");
		
		request.setAttribute("business", business);
		
		String destination = business.getName() + " ";
		for(String s:business.getLocation().getDisplayAddress()) {
			destination = destination + " " + s;
		}
		String place = URLEncoder.encode(destination, "UTF-8");
		
		if(request.getParameter("locationForm")==null) {
			String map = "place?q=" + place;
			request.setAttribute("map", map);
		} else {
			String lat = request.getParameter("lat");
			String lon = request.getParameter("lon");
			
			if(lat!=null && lon!=null) {
				log.log(Level.FINE, "Latitud: " + lat + " y longitud: " + lon + " cargadas con éxito");
			} else {
				log.log(Level.WARNING, "No se ha realizado la carga de los parámetros latitud y longitud");
				request.setAttribute("message", "No se ha realizado la carga de los parámetros latitud y longitud");
				request.getRequestDispatcher("/ErrorView.jsp").forward(request, response);
			}
			
			LocationResource resource2 = new LocationResource();
			CurrentLocation location = resource2.getLocation(lat, lon);
			
			log.log(Level.INFO, "Objeto localización creado con éxito");
			
			String origin = URLEncoder.encode(location.getResults().get(0).getFormattedAddress(),
					"UTF-8");
			
			String map = "directions?origin=" + origin + "&destination=" + place;
			request.setAttribute("map", map);
		}

		request.getRequestDispatcher("/BusinessView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
