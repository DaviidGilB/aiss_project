package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.SearchResource;
import aiss.model.yelp.search.Business;
import aiss.model.yelp.search.BusinessSearch;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String location = request.getParameter("location");
		String category = request.getParameter("category");
		
		if(location!=null && category!=null) {
			log.log(Level.FINE, "Cargadas localización : " + location + " y categoría: " + category + " con éxito.");
		} else {
			log.log(Level.WARNING, "No se ha realizado la carga de los parámetros de localización y categoría");
			request.setAttribute("message", "No se ha realizado la carga de los parámetros de localización y categoría");
			request.getRequestDispatcher("/ErrorView.jsp").forward(request, response);
		}
		
		SearchResource resource = new SearchResource();
		BusinessSearch search = resource.getSearch(location, category);
		
		log.log(Level.INFO, "Objeto búsqueda creado con éxito");
		
		request.setAttribute("busqueda", search.getBusinesses());
		request.getRequestDispatcher("/ResultsView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
