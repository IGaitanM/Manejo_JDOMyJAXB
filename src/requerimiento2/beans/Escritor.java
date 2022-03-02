package requerimiento2.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="escritor")
@XmlType(propOrder = {
		"id",
	    "nombre",
	    "apellidos",
	    "fechaNacimiento",
	    "libros"
	})
public class Escritor {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private List<Libro> libros;

	public Escritor(String nombre ,String apellidos, String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Escritor() {
		super();
		
	}

	@XmlAttribute(name = "id")
	public int getId_autor() {
		return id;
	}

	public void setId_autor(int id_autor) {
		this.id = id_autor;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Autor [id_autor=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", libros=" + libros + "]";
	}
	

}
