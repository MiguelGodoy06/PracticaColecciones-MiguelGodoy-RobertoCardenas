# Practica de colecciones Estructura de Datos
## Miguel Godoy y Roberto Cárdenas
### Link repositorio github:
https://github.com/MiguelGodoy06/PracticaColecciones-MiguelGodoy-RobertoCardenas.git
### Enunciado:
La práctica consiste en la creación de un programa que permita gestionar una colección de ciudades.

Para ello crearemos lo siguiente:

- Clase `Ciudad` que tenga como parámetros nombre, país y número de habitantes.
- Necesito almacenar en una estructura de datos una colección de ciudades. Dicha estructura no va almacenar elementos duplicados. Elegid qué tipo de estructura es la adecuada.
- Realizar un programa principal en donde comprobar que el tratamiento de duplicados se hace de manera correcta.
- Una vez hecho esto, vamos a modificar el funcionamiento para que sea más completo.
- Para ello, necesito un menú por pantalla con las siguientes opciones: 
   1. Añadir ciudad
   2. Listar ciudades (se mostrarán ordenadas por número de habitantes)
   3. Buscar ciudades
   4. Terminar y salir

Gestionaremos las excepciones que se produzcan en el programa.

### Explicación del trabajo:
En primer lugar hemos hecho el programa de forma que al ejecutarlo se pudiera hacer lo requerido en la propia consola, pero después de eso, hemos pensado que sería mejor implementar todo el programa a un menú interactivo
Dentro del código también hemos pensado que era adecutado que, al añadir una ciudad, una vez se introduzca el número de habitantes, en vez de poner 25.000.000 para decir 25 millones, hemos logrado que simplemente con poner 25 millones, al listar la ciudad indique el número normal.
Es decir si al incluir la ciudad ponemos 2 millones de habitantes, al mostrar la lista de ciudades veremos que indica a los habitantes como 2.000.000 de habitantes.



