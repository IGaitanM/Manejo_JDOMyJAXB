
#### Implementaci�n de un programa Java que utiliza el parser JDOM para crear un nuevo documento XML y despu�s lee su contenido .Tambi�n se utilizar�n las librerias JAXB para crear objetos y serializarlos a un fichero XML.

## REQUERIMIENTO 1 (JDOM)
La clase **Principal** de la aplicaci�n crea un archivo llamado **concierto.xml** con el siguiente contenido:

```

<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<concierto>
	<fecha>20-oct-2018</fecha>
	<hora>21:30</hora>
	<participantes>
		<participante>
			<entrada>21:30</entrada>
			<grupo>Las Ardillas de Dakota</grupo>
		</participante><participante>
			<entrada>22:15</entrada>
			<grupo>Fito y Fitipaldis</grupo>
		</participante><participante>
			<entrada>23:00</entrada>
			<grupo>ColdPLay</grupo>
			</participante>
		</participantes>
</concierto>

```

Dentro del mismo proyecto, la clase llamada **LecturaXML** lee el fichero anteriormente creado, generando la siguiente salida en pantalla:

```
Fecha y hora del concierto: 20-oct-2018 21:30
Participan lo siguientes grupos:
    21:30 Las Ardillas de Dakota 
    22:15 Fito y Fitipaldis 
    23:00 ColdPLay 

```



## REQUERIMIENTO 2 (JAXB)

El objetivo es trabajar con un XML, pero con las librer�as de JAXB

Se crear�n al menos 2 clases (entidades). Entre dichas clases habr� una relaci�n de 1 a N . Las clases llevar�n anotaciones JAXB para poder serializar sus objetos a XML y a la inversa.

La clase main crear� objetos y los serializar� a un fichero XML. Tambi�n a partir de un XML, crear� los objetos.

**Vista de xml creado (libreria.xml) serializando los objetos para cumplir con el requisito**

```

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<libreria id="1">
    <nombre>Libreria Koreander</nombre>
    <nombre_due�o>Karl Konrad Koreander</nombre_due�o>
    <direcion>Calle Fujur</direcion>
    <libros id="1">
        <titulo>La Historia Interminable</titulo>
        <escritor id="1">
            <nombre>Michael</nombre>
            <apellidos>Ende</apellidos>
            <fechaNacimiento>10-12-1929</fechaNacimiento>
        </escritor>
        <editorial id="1">
            <nombre>Alfaguara</nombre>
            <direcion>Calle Alfaguara</direcion>
        </editorial>
        <precio>12.50</precio>
    </libros>
    <libros id="4">
        <titulo>Elantris</titulo>
        <escritor id="3">
            <nombre>Brandon</nombre>
            <apellidos>Sanderson</apellidos>
            <fechaNacimiento>19-11-1975</fechaNacimiento>
        </escritor>
        <editorial id="2">
            <nombre>Planeta</nombre>
            <direcion>Av Diagonal 662</direcion>
        </editorial>
        <precio>23.30</precio>
    </libros>
    <libros id="5">
        <titulo>El Camino de los Reyes</titulo>
        <escritor id="3">
            <nombre>Brandon</nombre>
            <apellidos>Sanderson</apellidos>
            <fechaNacimiento>19-11-1975</fechaNacimiento>
        </escritor>
        <editorial id="2">
            <nombre>Planeta</nombre>
            <direcion>Av Diagonal 662</direcion>
        </editorial>
        <precio>17.50</precio>
    </libros>
    <libros id="0">
        <titulo>El Imperio Final</titulo>
        <escritor id="3">
            <nombre>Brandon</nombre>
            <apellidos>Sanderson</apellidos>
            <fechaNacimiento>19-11-1975</fechaNacimiento>
        </escritor>

```

**Vista de la salida por consola al deserializar libreria.xml**

```
Libreria [id_libreria=1, nombre=Libreria Koreander, nombre_due�o=Karl Konrad Koreander, direcion=Calle Fujur, libros=[Libro [id=1, titulo=La Historia Interminable, precio=12.50, editorial=Editorial [id=0, nombre=Alfaguara, direcion=Calle Alfaguara, libros=null], escritor=Escritor [id=1, nombre=Michael, apellidos=Ende, fechaNacimiento=10-12-1929, libros=null]], Libro [id=4, titulo=Elantris, precio=23.30, editorial=Editorial [id=0, nombre=Planeta, direcion=Av Diagonal 662, libros=null], escritor=Escritor [id=3, nombre=Brandon, apellidos=Sanderson, fechaNacimiento=19-11-1975, libros=null]], Libro [id=5, titulo=El Camino de los Reyes, precio=17.50, editorial=Editorial [id=0, nombre=Planeta, direcion=Av Diagonal 662, libros=null], escritor=Escritor [id=3, nombre=Brandon, apellidos=Sanderson, fechaNacimiento=19-11-1975, libros=null]], Libro [id=0, titulo=El Imperio Final, precio=22.10, editorial=Editorial [id=0, nombre=Planeta, direcion=Av Diagonal 662, libros=null], escritor=Escritor [id=3, nombre=Brandon, apellidos=Sanderson, fechaNacimiento=19-11-1975, libros=null]]]]
```

# informaci�n JDOM
JDOM son librerias java que estan incluidas en la jdk, y nos sirven para trabajar con el arbol DOM. Todo documento xml se suele transforman en los navegadores en un arbol de nodos u objetos (como el DOM de XML HTML). 
Cada etiqueta XML se transforma en un nodo elemento, los textos en un nodo texto y los atributos se transforman en un nodo atributo

**PRINCIPALES CLASES Y M�TODOS USADOS para crear un archivo XML** **(Principal.java)**

-  **DocumentBuilderFactory :** con su m�todo para instanciarlo **newInstance()** Factoria que crea los objetos a trav�s del m�todo **newDocumentBuilder()** . Su funcion es evitar el acoplamiento de clases
-  **DocumentBuilder :** y su m�todo **newDocument()** Crea objetos complejos de manera simple.
-  **Document :** y su m�todo **getDocumentElement()** para crear el nodo document.
-  **Node :** para crear un nodo.
-  **Element :** crea un nodo Elemento con a rav�s del objeto de la clase Document y de su m�todo **createElement("")**. Con el m�todo de Document **appendChild("")** agregamos e hijos a los nodos.
-  **Text :** para cear nodos texto a grav�s del m�todo de la clase Document createTextNode("");

Para guardar el archivo xml utilizaremos:

-  **TransformerFactory :** se instacia con newInstance() y es una f�brica de transformers:
-  **Transformer :** a trav�s del m�todo de TransformerFactory **newTransformer()** Crea el objeto Transfomer, que nos permite serializar el arbol dom a un fichero.
-  **DOMSource :** Crea la fuente de la cual sacaremos el arbol dom.
-  **StreamResult :** Crea el flujo de salida, al fichero que queremos, utilizando **new File("")** para crear el fichero con la extensi�n que indiquemos.
-  Por �ltimo el m�todo de la clase Transformer **transform(fuente, resultado)** serializa los datos al pasarle como par�metros un objeto de la clase DOMSource y otro objeto de la clase StreamResult.

**PRINCIPALES CLASES Y M�TODOS USADOS para leer un archivo XML** **(LecturaXML.java)**

Adem�s de los usados para crear el XML usaremos:

-  **Nodelist :** Para obtener la lista de nodos del documento a trav�s del m�todo del objeto Node de la raiz **getChildNodes()**. 
-  El m�todo **getNodeName()** de Nodelist que usamos para obtener el nombre de cada nodo si lo recorremos con un for. 
-  El m�todo **getTextContent()** de Nodelist lo usamos para obtener el String contenido en el nodo.

# informaci�n JAXB
Java JAXB o Java XML API Binding nos permite trabajar con XML y JSON de una forma c�moda usando Java.

Antes de Java 11, las librer�as de JAXB estaban dentro de la JDK de Java, pero para esta versi�n las sacaron de ella, por lo que hay que descargarlas y agregarlas al classpath de nuestro proyecto. En este caso se ha utilizado MAven para gestionar las dependencias.
<https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/2.4.0-b180830.0359>

**ANOTACIONES USADAS **

-  **@XmlRootElement(name=" ")** : anotaci�n obligatoria que establece el nombre del nodo raiz en XML.
-  **@XmlType(propOrder = {	})** : para que las etiquetas salgan en el orden que pongamos.
-  **@XmlAttribute(name = " ")** : en vez de pasarsar el atributo como element del XML lo pasar�a como atributo.
-  **@XmlElement(name=" ")** : para cambiar el nombre del elemento en el XML.
-  **@XmlElementWrapper(name = " ")** : envuelve el la etiqueta en una etiqueta elemento con el nombre que le pongamos.

**PRINCIPALES CLASES Y M�TODOS USADOS para serializar un objeto a XML** **(ObjectToXML.java)**

-  **JAXBContext :** con el m�todo **newInstance(Clase.class)** Obtiene el contexto asociado a la clase indicada, con dicho contexto podremos convertir el objeto a un xml y a la inversa.Provoca una excepci�n de tipo JAXBException si la clase indicada no cumple los requisitos para la conversi�n a XML, si no contiene las anotaciones necesarias y no cuenta con un constructor sin argumentos.
-  **Marshaller :** junto al m�todo de JAXBCOntext **createMarshaller()** Obtiene el objeto Marshaller asociado al contexto.Con dicho objeto podremos convertir un objeto en xml, es decir, lo serializaremos.
-  Con el m�todo de Marshaller **setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)** con valor true permite que en la conversi�n a formato XML se incluyan retornos de carro e indentaci�n (sangrado del texto). Est� pensado si el archivo resultante lo van a leer personas. Dejarlo false para leerlo desde java para que no cuente los como nodos los retornos de carro. 
-  Con el m�todo de Marshaller **marshal(p, System.out)** podemos imprimir por pantalla	y tambien podemos crear un fichero con .marshal(p, new File(""));

PRINCIPALES CLASES Y M�TODOS USADOS para deserializar un XML a un objeto** **(XMLToObject.java)**

-  **Unmarshaller :** junto al m�todo de JAXBCOntext **createUnmarshaller()** Para convertir un XML en objeto, es decir, lo deserializaremos.

## Bibliografia
-  <https://www.w3schools.com/js/js_htmldom.asp>
-  <https://github.com/fdepablo/WorkspaceJava>
