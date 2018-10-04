package aiss.model.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
	
	private String id;
	private String nombre;
	private String descripcion;
	private List<Restaurante> restaurantes;
	
	public Ciudad() {}
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	
	protected void setRestaurantes(List<Restaurante> r) {
		restaurantes= r;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public List<Restaurante> getRestaurantes(){
		return restaurantes;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public Restaurante getRestaurante(String id) {
		if(restaurantes==null) {
			return null;
		}
		Restaurante restaurante = null;
		for (Restaurante r : restaurantes) {
			if(r.getId().equals(id)) {
				restaurante=r;
				break;
			}
		}
		return restaurante;
	}
	
	public void addRestaurante(Restaurante r) {
		if(restaurantes==null) {
			restaurantes = new ArrayList<Restaurante>();
		}
		restaurantes.add(r);
	}
	
	public void deleteRestaurante(Restaurante r) {
		restaurantes.remove(r);
	}
	
	public void deleteRestaurante(String id) {
		Restaurante r = getRestaurante(id);
		
		if(r!=null) {
			restaurantes.remove(r);
		}
	}
	
}
