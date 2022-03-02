package requerimiento2.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import requerimiento2.beans.Libreria;

public class XMLToObject {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Libreria.class);
			
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("libreria.xml");
			if (fichero.exists()) {
				Libreria libreria = (Libreria) u.unmarshal(fichero);			
				System.out.println(libreria);
			} else {
				System.out.println("Fichero XML festival.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
