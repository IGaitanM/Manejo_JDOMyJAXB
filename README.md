
## REQUERIMIENTO 1
La clase **Principal** de la aplicación crea un archivo llamado **concierto.xml** con el siguiente contenido:

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



## REQUERIMIENTO 2

El objetivo es trabajar con un XML, pero con las librerías de JAXB

Se crearán al menos 2 clases (entidades). Entre dichas clases habrá una relación de 1 a N . Las clases llevarán anotaciones JAXB para poder serializar sus objetos a XML y a la inversa.

La clase main creará objetos y los serializará a un fichero XML. También a partir de un XML, creará los objetos.


# información JDOM
JDOM son librerias java que estan incluidas en la jdk, y nos sirven para trabajar con el arbol DOM. Todo documento xml se suele transforman en los navegadores en un arbol de nodos u objetos (como el DOM de XML HTML). 
Cada etiqueta XML se transforma en un nodo elemento, los textos en un nodo texto y los atributos se transforman en un nodo atributo

# JAXB
Java JAXB o Java XML API Binding nos permite trabajar con XML y JSON de una forma cómoda usando Java.

Si usamos la versión 1.8 de Java, las clases necesarias para utilizar JAXB estan dentro de la JDK, para versiones siguientes se eliminaron.



## Bibliografia
https://www.w3schools.com/js/js_htmldom.asp