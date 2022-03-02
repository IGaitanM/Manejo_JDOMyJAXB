package requerimiento2.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import requerimiento2.beans.Editorial;
import requerimiento2.beans.Escritor;
import requerimiento2.beans.Libreria;
import requerimiento2.beans.Libro;

public class ObjectToXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Libreria.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;
		}

		Marshaller m;
		
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Libreria libreria = new Libreria();
			libreria = crearLibreria(libreria);
			m.marshal(libreria, new File("libreria.xml"));
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Libreria crearLibreria(Libreria libreria) {

		Escritor michael = new Escritor(1, "Michael", "Ende", "10-12-1929", null);
		Escritor carlos = new Escritor (2, "Carlos", "Ruiz Zafón", "25-08-1964", null);
		Escritor brandon = new Escritor (3, "Brandon", "Sanderson", "19-11-1975", null);
		
		Editorial alfa = new Editorial(1, "Alfaguara", "Calle Alfaguara", null) ;
		Editorial planeta = new Editorial (2, "Planeta", "Av Diagonal 662", null);
		
		Libro laHistoria = new Libro(1, "La Historia Interminable","12.50", alfa, michael);
		Libro laSombra = new Libro(2, "La Sombra del viento","20.20", planeta, carlos);
		Libro elPrisionero = new Libro(3, "El Prisionero del Cielo","22.50", planeta, carlos);
		Libro elantris = new Libro(4, "Elantris","23.30", planeta, brandon);
		Libro elCamino = new Libro(5, "El Camino de los Reyes","17.50", planeta, brandon);
		Libro elImperio = new Libro(0, "El Imperio Final","22.10", planeta, brandon);
		
		List<Libro> librosKoreander = new ArrayList<>();
		librosKoreander.add(laHistoria);
		librosKoreander.add(elantris);
		librosKoreander.add(elCamino);
		librosKoreander.add(elImperio);
		
		libreria.setId(1);
		libreria.setNombre("Libreria Koreander");
		libreria.setNombre_dueño("Karl Konrad Koreander");
		libreria.setDirecion("Calle Fujur");
		libreria.setLibros(librosKoreander);


		
		return libreria;
	}

}
