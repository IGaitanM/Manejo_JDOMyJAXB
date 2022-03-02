package requerimiento2.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="libro")
@XmlType(propOrder = {
		"id",
	    "titulo",
	    "escritor",
	    "editorial",
	    "precio"
	})
public class Libro {

	private int id;
	private String titulo;
	private String precio;
	private Editorial editorial;
	private Escritor escritor;


	public Libro(int id, String titulo, String precio, Editorial editorial, Escritor escritor) {
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
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	public Escritor getEscritor() {
		return escritor;
	}


	public void setEscritor(Escritor escritor) {
		this.escritor = escritor;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial
				+ ", escritor=" + escritor + "]";
	}


	
}
