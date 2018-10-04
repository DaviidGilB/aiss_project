package aiss.api.application;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import aiss.api.resources.CiudadResource;
import aiss.api.resources.RestaurantResource;

public class RestaurantApplication extends Application{
	
	private Set<Object> singletons = new HashSet<Object>();
	private  Set<Class<?>> classes = new HashSet<Class<?>>();
	
	//Carga todos los recursos que están implementados en la aplicación
	//de manera que puedan ser encontrados en RESTEasy
	
	public RestaurantApplication() {
		singletons.add(CiudadResource.getInstance());
		singletons.add(RestaurantResource.getInstance());	
	}
	
	public Set<Class<?>> getClasses(){
		return classes;
	}
	
	public Set<Object> getSingletons(){
		return singletons;
	}
	

}
