package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.resource.BusinessResource;
import aiss.model.yelp.details.BusinessDetails;
import aiss.model.yelp.details.Category;
import aiss.utility.ASCII;

/**
 * Servlet implementation class SaveController
 */
public class SaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SaveController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

			String id;
			if(req.getParameter("id")!=null) {
				id = req.getParameter("id");
				session.setAttribute("id", id);
			} else {
				id = (String) session.getAttribute("id");
				
				if(id!=null) {
					log.log(Level.FINE, "ID: " + id + " cargado con éxito.");
				} else {
					log.log(Level.WARNING, "No se ha realizado la carga del parámetro ID");
					req.setAttribute("message", "No se ha realizado la carga del parámetro ID");
					req.getRequestDispatcher("/ErrorView.jsp").forward(req, resp);
				}
				
				session.setAttribute("id", null);
			}
			String accessToken=(String)req.getSession().getAttribute("GoogleCalendar-token");
			if(accessToken!=null && !"".equals(accessToken)){
				BusinessResource resource = new BusinessResource();
				BusinessDetails business = resource.getBusiness(id);
				
				log.log(Level.INFO, "Objeto negocio creado con éxito");
				
				String summary = business.getName();
				req.setAttribute("summary", ASCII.replace(summary));
				
				String description = "";
				for(int i = 0; i<business.getCategories().size(); i++) {
					description = description + business.getCategories().get(i).getTitle() + ", ";
				}
				description = description + business.getPhone();
				req.setAttribute("description", ASCII.replace(description));
				
				String location = business.getName() + ", ";
				for(String s:business.getLocation().getDisplayAddress()) {
					location = location + s;
					if(business.getLocation().getDisplayAddress().indexOf(s) !=
							business.getLocation().getDisplayAddress().size()-1) {
						location = location + ", ";
					}
				}
				req.setAttribute("location", ASCII.replace(location));
				
				req.setAttribute("business", business);
				req.getRequestDispatcher("/SaveView.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req,resp);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
