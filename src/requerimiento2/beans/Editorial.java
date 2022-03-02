package requerimiento2.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="editorial")
@XmlType(propOrder = {
		"id",
	    "nombre",
	    "direcion",
	    "libros"
	})
public class Editorial {
	
	private int id;
	private String nombre;
	private String direcion;
	private List<Libro> libros;
	
	public Editorial() {
		super();
	}

	public Editorial(int id, String nombre, String direcion, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direcion = direcion;
		this.libros = libros;
	}

	@XmlAttribute(name = "id")
	public int getId_editorial() {
		return id;
	}

	public void setId_editorial(int id_editorial) {
		this.id = id_editorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Editorial [id_editorial=" + id + ", nombre=" + nombre + ", direcion=" + direcion + ", libros="
				+ libros + "]";
	}

	
}
