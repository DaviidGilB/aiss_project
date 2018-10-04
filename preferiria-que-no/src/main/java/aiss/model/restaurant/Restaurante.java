package aiss.model.restaurant;

public class Restaurante {
	
	private String id;
	private String nombre;
	private String categoria;
	private String direccion;
	
	public Restaurante() {
	}
	
	public Restaurante (String nombre, String categoria, String direccion) {
		this.nombre=nombre;
		this.categoria=categoria;
		this.direccion=direccion;
	}
	public Restaurante(String id, String nombre, String categoria, String direccion) {
		this.id=id;
		this.nombre=nombre;
		this.categoria=categoria;
		this.direccion=direccion;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setCategoria(String categoria) {
		this.categoria=categoria;
	}
	
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}

}
