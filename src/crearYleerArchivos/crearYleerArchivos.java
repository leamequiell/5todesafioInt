package crearYleerArchivos;

import java.io.*;
import java.util.Scanner;


public class crearYleerArchivos {

	 // Método principal que se ejecuta cuando se inicia el programa
	 public static void main(String ars[]) {

	     // Crear un objeto "entrada" de tipo Scanner para recibir entrada de usuario
	     Scanner entrada = new Scanner(System.in);

	     // Declarar dos arreglos de cadenas de texto llamados "nombre" y "apellido" con
	     // espacio para 3 elementos cada uno.
	     // Recordar: se define el tipo de array (String en este caso), luego se colocan
	     // corchetes [], despues el nombre del array (nombre, y apellido en los ejemplos
	     // de abajo), y del otro lado de la igualdad
	     //se coloca "new" "Tipo de array"[cantidad de elementos]
	   
	     String[] nombre = new String[3];
	     String[] apellido = new String[3];

	     // Mostrar un mensaje en la consola
	     System.out.println("INGRESA TRES NOMBRES Y APELLIDOS ");

	     // Iniciar un ciclo "for" que se ejecutara 3 veces
	     // "i" es una variable para recorrer los arrays.
	     // "i" comienza en 0, y termina en 2. Son tres elementos por array: 
	     // Primer elemento en la posicion 0, segundo en la posicion 1, y tercero
	     // en la posicion 2. 
	     for (int i = 0; i < 3; i++) {

	         // Mostrar un mensaje pidiendo al usuario ingresar un nombre y leer la entrada
	         System.out.println("Ingresa el nombre numero: " + (i + 1));
	         nombre[i] = entrada.next();

	         // Mostrar un mensaje pidiendo al usuario ingresar un apellido y leer la entrada
	         System.out.println("Ingresa el apellido numero: " + (i + 1));
	         // El (i+1) es porque los arrays comienzan a guardar en la posicion 0.
	         // Entonces (i+1) hace que al principio NO se muestre "numero 0" sino
	         // "numero 1". Recordar que "i" es una variable para recorrer los arrays.
	         apellido[i] = entrada.next();

	         // Mostrar una línea en blanco para separar las entradas de nombre y apellido
	         System.out.println("");
	     }

	     // ----------ESCRIBIR EL CONTENIDO EN UN ARCHIVO .TXT

	     // Iniciar un bloque "try-catch" para manejar posibles errores
	     // "Try" INTENTA ejecutar el codigo que contiene entre llaves {}.
	     // "Catch" CAPTURA errores.
	     //
	     try {
	         // Especificar la ruta del archivo en la que se guardaran los datos
	    	 // NO olvidarse de escribir el nombre del archivo, y luego .txt
	    	 // En este caso, si mi_archivo.txt no lo agregamos a la ruta, 
	    	 // Java NO va a identificar ningún archivo .txt
	         String ruta = "C:\\Users\\leand\\documents\\mi_archivo.txt";
	         // Crear un objeto "file" que representa el archivo en la ruta especificada
	         File file = new File(ruta);
	         // Verificar si el archivo no existe, y si es asi, crearlo
	         if (!file.exists()) {
	             file.createNewFile();
	         }

	         // Crear un objeto "fw" de tipo FileWriter para escribir en el archivo
	         // Este objeto nos permite llenar el archivo de información. 
	         FileWriter fw = new FileWriter(file);

	         // Crear un objeto "bw" de tipo BufferedWriter para escribir en el archivo de
	         // manera eficiente. Esto es como que "limpia" el archivo para ser escrito
	         // con los datos que se cargaron en los arrays "nombre" y "apellido".
	         BufferedWriter bw = new BufferedWriter(fw);

	         // Iniciar un ciclo "for" que se ejecutara 3 veces
	         for (int i = 0; i < 3; i++) {
	             // Escribir en el archivo una linea que contiene el nombre y el apellido
	             bw.write("Nombre: " + nombre[i] + ", Apellido: " + apellido[i]);

	             // Agregar una nueva linea (un salto de linea) despues de cada entrada
	             bw.newLine();
	         }

	         // Cerrar el BufferedWriter para finalizar la escritura en el archivo
	         // Si no se cierra el bufer, no se genera el archivo.
	         bw.close();

	         // Mostrar un mensaje en la consola para indicar que el archivo se creo con
	         // exito
	         System.out.println("Archivo creado con éxito.");
	     } catch (Exception e) {
	         // En caso de un error, mostrar informacion detallada sobre el error en la
	         // consola
	    	 // Aca en vez de "e.printStackTrace" se podría poner un "syso" 
	    	 // que indique "Error al escribir el archivo". 
	         e.printStackTrace();
	     }

	     // ----------LEER EL CONTENIDO DE UN ARCHIVO .TXT

	     // Intentamos hacer algo en este bloque de código
	     try {
	         // Abrimos un archivo llamado "mi_archivo.txt" ubicado en el escritorio de la
	         // computadora
	         // para leerlo (FileReader lo abre) y lo leemos linea por linea de manera
	         // eficiente (BufferedReader)
	         FileReader archivo = new FileReader("C:\\Users\\leand\\documents\\mi_archivo.txt");
	         BufferedReader lector = new BufferedReader(archivo);

	         // Declaramos una variable llamada "linea" para guardar cada linea que leemos
	         // del archivo
	         String linea;

	         // Usamos un bucle que se repite mientras haya lineas por leer en el archivo
	         while ((linea = lector.readLine()) != null) {
	             // Mostramos cada linea que leemos en la pantalla (en la consola)
	             System.out.println(linea);
	         }

	         // Cerramos el archivo después de leerlo para liberar recursos
	         lector.close();
	     } catch (IOException e) {
	         // En caso de que ocurra algún problema al abrir o leer el archivo,
	         // mostramos información detallada sobre el error en la pantalla (en la consola)
	         e.printStackTrace();
	     }

	 }
	}

	/*
	 * A CONTINUACION, SE DETALLAN ALGUNAS DEFINICIONES:
	 * 
	 * ARCHIVO: en informatica, un archivo es una coleccion de datos almacenados en
	 * una ubicacion especifica y con un nombre unico en un dispositivo de
	 * almacenamiento. stos datos pueden ser de diferentes tipos, como texto,
	 * imagenes, sonidos, videos, programas ejecutables y mas. Los archivos se
	 * utilizan para organizar, almacenar y acceder a informacion de manera
	 * estructurada.
	 * 
	 * 
	 * IMPORTANCIA DE LOS ARCHIVOS: la escritura y lectura de archivos en Java es
	 * importante en una amplia gama de aplicaciones y escenarios de desarrollo de
	 * software. Facilita la persistencia de datos, la interaccion con el usuario,
	 * la comunicacion entre aplicaciones, la recuperacion de datos y muchas otras
	 * tareas esenciales en la programacion. Por lo tanto, es una habilidad
	 * fundamental para los desarrolladores de Java.
	 * 
	 * 
	 * BUFFER: el termino "buffered" se refiere a la tecnica de almacenar datos en
	 * una memoria temporal llamada "buffer" antes de procesarlos o transferirlos a
	 * su destino final. En el contexto de la programacion, un "buffer" es un area
	 * de memoria que se utiliza para almacenar temporalmente datos antes de su
	 * lectura o escritura. En el codigo que proporcionaste, BufferedWriter se
	 * utiliza para escribir datos en un archivo de manera eficiente al almacenarlos
	 * primero en un buffer antes de escribirlos en el archivo fisico. Esta tecnica
	 * ofrece ventajas en terminos de rendimiento, ya que permite reducir el numero
	 * de operaciones de escritura directa en el archivo, lo que puede ser costoso
	 * en terminos de tiempo y recursos. En resumen, BufferedWriter se utiliza para
	 * optimizar la escritura de datos en archivos al utilizar un buffer intermedio
	 * que acumula los datos antes de escribirlos en el archivo, lo que puede
	 * mejorar la eficiencia y el rendimiento de las operaciones de escritura.
	 */