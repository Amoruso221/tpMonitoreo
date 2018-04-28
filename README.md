# tpMonitoreo

*Maven
mvn clean: limpia todas las clases compiladas del proyecto
mvn compile: compila el proyecto
mvn package: realiza el empaquetado del proyecto. En el caso de que sea un proyecto simple genera una .jar
mvn install: instala el artefacto en el repositorio local

*Scopes
compile: Si no se especifica Scope esta por defecto. Indica que la dependencia es necesaria para poder compilar. Ademas, la dependencia se propaga en los proyectos dependientes.
provided: Es como compile pero espera que el contenedor ya tenga la libreria.
runtime: Esta dependencia es necesaria en tiempo de ejecucion pero no para compilar
test: Esta dependencia es solo para testing
system: Es como provided pero hay que incluir la dependencia explicitamente. Maven no va a realizar la busqueda en su repositorio local. Hay que expecificar la ruta de la dependencia con la etiqueta <systemPath>
import: Es utilizado para importar otras dependencias.

* Un arquetipo es una "plantilla". Cuando se crea un proyecto hay que especificar uno y este arma la estructura del proyecto, el contenido del "pom", la estructura de las carpetas y ficheros que incluyen por defecto.

*Estructura base de proyecto maven
src-main-java: Contiene el código fuente con nuestras clases Java incluida la estructura de paquetes
src-main-resources :Contiene ficheros de recursos como imagenes ficheros .properties etc
src-test-java: Contiene el código fuente con nuestras clases Java para realizar test
src-test-resource: Contiene ficheros de recursos como imagenes ficheros .properties etc para nuestros test
target :Contiene los desplegables que generamos con Maven jar,war,ear etc
pom.xml : Ya hemos hablado de el y es el fichero encargado de definir el concepto de Artefacto.

* La diferencia entre arquetipo y artifact es que el primero se encarga de crear la estructura y la configuracion inicial del proyecto mientras que el segundo es la unidad minima que maneja el repositorio. Estos son agrupados e identificados mediante un ID propio y de grupo,
ademas de una version y un clasificador. Estos son administrador en el pom.
