# JMC

###Descripción general

Utileria escrita en Java para obtener URL's y su contenido, en el cual obtenemos dos tipos de salida JSON o XML, en salida estándar o bien dirigida a un archivo.
<br/>
Hace las siguientes tareas:<br/>
- Se conecta a la URL solicitada.
- Guarda el archivo de la URL.
- Recupera todas las URL's y "tags" de acuerdo a los folders de la URL (ejemplo: http://www.ejemplo.com/noticias/morelia/una-noticia-morelia/1, las tags serián "www.ejemplo.com","noticias","morelia","una-noticia-morelia","1" ). Solo recupera las del "host" de la URL.
- Se conecta de una por una a cada URL obtenida.
- Guarda el archivo de la URL.
- Trata de obtener el titulo, el contenido y el autor con la busqueda de clases CSS, ejemplo:<br/>

```
<h3 class="titulo">Soy el titulo de la noticia</h3>
<p class="textoNoticia">
Una noticia con muchos caracteres....
</p>
<span class="autor">Autor: Miguel</span>
<span class="fecha">2015-12-14</span>
```
- Obtiene el texto de las etiquetas que tenga como propiedad class="titulo" esto para el titulo.
- Obtiene el texto de las etiquetas que tengan como propiedad class="textoNoticia", para el contenido de la noticia.
- Obtiene el texto de las etiquetas que tengan como propiedad class="autor" para el autor.
- Obtiene el texto de las etiquetas que tenga como propiedad class="fecha" para las fecha.

Si se quiere obtener de varios valores de class, deben estar separadas por "," en el archivo de configuración (props_config.properties) que se muestra a continuacion.

```
navegador='Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11'
archive_html=/home/miguel/temp/
sitio=http://www.ejemplo.com/noticias/morelia/1/
class_titulo=newsTitle
class_texto=notebody,adDescription,trimmedText
class_fecha=time
class_autor=time,adContactInfo
```

### Ejemplo de ejecución

```
$ java -jar jmc.jar [json | xml] opcional (nombre_archivo_salida)
```

### Librerías requeridas (o versiones posteriores)
- JSON
```
http://central.maven.org/maven2/org/json/json/20151123/json-20151123.jar
```
- JSOUP
```
http://central.maven.org/maven2/org/jsoup/jsoup/1.8.3/jsoup-1.8.3.jar
```


### Autores:
- Miguel Angel Cedeño Garcidueñas &nbsp;&nbsp;  miguecg[at]gmail.com
- Jesse Williams Madriz Chavez &nbsp;&nbsp;	    madrizjesse[at]gmail.com
- José Gerardo Moreno García &nbsp;&nbsp;        mgtigmoreno[at]gmail.com 


 
