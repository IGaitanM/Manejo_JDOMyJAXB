package requerimiento1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {

		// Factoria que crea los objetos. Su funcion es evitar el acoplamiento de clases
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		// Crea objetos complejos de manera simple
		DocumentBuilder analizador;
		// Nodo documento
		Document doc;
		// Nodo raiz
		Node raiz;

		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("concierto.xml");
			raiz = doc.getDocumentElement();
			recorrerNodos(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Método que recorre los nodos raiz del documento e imprime los valores fecha y hora
	 * @param raiz Parámetro de tipo Node
	 */
	private static void recorrerNodos(Node raiz) {
		NodeList nodos = raiz.getChildNodes();
		String fecha = null;
		String hora = null;
		Node participantes = null;

		for (int i = 0; i < nodos.getLength(); i++) {
			participantes = nodos.item(2);
			if (nodos.item(i).getNodeName().equals("fecha"))
				fecha = nodos.item(i).getTextContent();
			if (nodos.item(i).getNodeName().equals("hora"))
				hora = nodos.item(i).getTextContent();
		}
		System.out.println("Fecha y hora del concierto: " + fecha + " " + hora);
		recorrerParticipantes(participantes);

	}


	/**
	 * Método que recorre e imprime los valores del nodo pasado por parámetro
	 * @param participantes Parámetro de tipo Node, hijo de la raiz .
	 */
	private static void recorrerParticipantes(Node participantes) {
		NodeList nodos = participantes.getChildNodes();
		System.out.println("Participan lo siguientes grupos:");
		for (int i = 0; i < nodos.getLength(); i++) {

			Node participante = nodos.item(i);
			if (participante.getNodeType() == Node.ELEMENT_NODE) {

				String entrada = participante.getChildNodes().item(0).getTextContent();
				String grupo = participante.getChildNodes().item(1).getTextContent();

				System.out.print("    ");
				System.out.print(entrada + " " + grupo + " \n");
			}
		}
	}
}