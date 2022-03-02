package requerimiento1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Principal {

	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			// Creamos nuevo documento vacio
			doc = analizador.newDocument();
			
			// Añadimos elemento raiz
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			
			// Se añaden los elementos hijos
			Element fecha = doc.createElement("fecha");
			fecha.appendChild(doc.createTextNode("20-oct-2018"));
			concierto.appendChild(fecha);
			Element hora = doc.createElement("hora");
			hora.appendChild(doc.createTextNode("21:30"));
			concierto.appendChild(hora);
			Element participantes = doc.createElement("participantes");
			concierto.appendChild(participantes);
			
			// Añadimos tres participantes al elemento participantes.
			agregarParticipantes(participantes, doc);
			
			// Guardamos en disco el nuevo documento XML.
			guardar(doc);
			
			System.out.println("El archivo se ha creado con Éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Método que agrega 3 elementos participante al elemento participantes
	 * con sus respectivos elementos hijos
	 * @param participantes elemento llamado participantes
	 * @param doc nodo documento 
	 */
	public static void agregarParticipantes(Element participantes, Document doc) {
		// Se agrega el primer participante
		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);		
		Element entrada = doc.createElement("entrada");
		Text textoEntrada = doc.createTextNode("21:30");
		entrada.appendChild(textoEntrada);
		participante.appendChild(entrada);
		
		Element grupo = doc.createElement("grupo");
		//Se crea el texto del grupo de manera directa
		grupo.appendChild(doc.createTextNode("Las Ardillas de Dakota"));
		participante.appendChild(grupo);

		// Se agrega el segundo participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("22:15"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante.appendChild(grupo);
		
		// Se agrega el tercer participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("23:00"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("ColdPLay"));
		participante.appendChild(grupo);	
	}
	
	/**
	 * Método que crea un archivo xml a partir del árbol dom que hemos creado
	 * @param doc nodo documento
	 * @throws TransformerException
	 */
	private static void guardar(Document doc) throws TransformerException {
		//fabrica de Transformer
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		//Crea el objeto Transfomer, que nos permite serializar el arbol dom a un fichero
		Transformer conversor = fabricaConversor.newTransformer();
		//Crea la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc); 
		//Crea el flujo de salida, al fichero que queremos 
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		//Por ultimo, serializa los datos
		conversor.transform(fuente, resultado);
	}
}