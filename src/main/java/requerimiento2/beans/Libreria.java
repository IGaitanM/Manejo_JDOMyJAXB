package requerimiento2.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libreria")
@XmlType(propOrder = {
		"id",
		"nombre",
		"nombre_dueño",
		"direcion",
		"libros"
})

public class Libreria {

	private int id;
	private String nombre;
	private String nombre_dueño;
	private String direcion;
	private List<Libro> libros;

	public Libreria() {
		super();
	}

	public Libreria(int id, String nombre, String nombre_dueño, String direcion, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombre_dueño = nombre_dueño;
		this.direcion = direcion;
		this.libros = libros;
	}
	
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id_libreria) {
		this.id = id_libreria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_dueño() {
		return nombre_dueño;
	}

	public void setNombre_dueño(String nombre_dueño) {
		this.nombre_dueño = nombre_dueño;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Libreria [id_libreria=" + id + ", nombre=" + nombre + ", nombre_dueño=" + nombre_dueño + ", direcion="
				+ direcion + ", libros=" + libros + "]";
	}

}
