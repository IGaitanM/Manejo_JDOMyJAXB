package requerimiento2.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="libro")
@XmlType(propOrder = {
		"id",
	    "titulo",
	    "precio",
	    "editorial",
	    "escritor"
	})
public class Libro {

	private int id;
	private String titulo;
	private double precio;
	private Editorial editorial;
	private Escritor escritor;


	public Libro(int id, String titulo, double precio, Editorial editorial, Escritor escritor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.escritor = escritor;
	}


	public Libro() {
		super();

	}

	@XmlAttribute(name = "id")
	public int getId_libro() {
		return id;
	}


	public void setId_libro(int id_libro) {
		this.id = id_libro;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	public Escritor getAutor() {
		return escritor;
	}


	public void setAutor(Escritor autor) {
		this.escritor = autor;
	}

	@Override
	public String toString() {
		return "Libro [id_libro=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial
				+ ", autor=" + escritor + ", librerias=" + "]";
	}
	

	
	
}
