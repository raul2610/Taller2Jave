package uniandes.dpoo.estructuras.logica;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.UnaryOperator;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
        
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        int[] copia = arregloEnteros.clone();
        return copia;

    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] copia = arregloCadenas.clone();
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int cantidad = arregloEnteros.length;
        return cantidad;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int cantidad = arregloCadenas.length;
        return cantidad;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int size = arregloEnteros.length + 1;
    	int[] arregloGrande = new int[size];
    	
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		arregloGrande[i] = arregloEnteros[i];
    	}
    	arregloGrande[size-1] = entero;
    	arregloEnteros = arregloGrande;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	int size = arregloCadenas.length+1;
    	String[] arregloGrande = new String[size];
    	
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		arregloGrande[i] = arregloCadenas[i];
    	}
    	arregloGrande[size-1] = cadena;
    	arregloCadenas = arregloGrande;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int cantidad = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
        	if (arregloEnteros[i] == valor) {
        		cantidad += 1;
        	}
        }
    	
    	int[] arregloNuevo = new int[arregloEnteros.length-cantidad];
    	int pos = 0;
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] != valor) {
    			arregloNuevo[pos] = arregloEnteros[i];
    			pos++;
    		}
    	}
    	arregloEnteros = arregloNuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        int contador = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
        	if (arregloCadenas[i].compareToIgnoreCase(cadena) == 0) {
        		contador += 1;
        	}
        }
    	String[] arregloNuevo = new String[arregloCadenas.length-contador];
    	int pos = 0;
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		if (arregloCadenas[i] != cadena) {
    			arregloNuevo[pos] = arregloCadenas[i];
    			pos++;
    		}
    	}
    	arregloCadenas = arregloNuevo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int size = arregloEnteros.length + 1;
    	int[] arregloGrande = new int[size];
    	
    	if (posicion < 0) {
    		arregloGrande[0] = entero;
    		for (int i = 0; i < arregloEnteros.length; i++) {
    			arregloGrande[i+1] = arregloEnteros[i];
    		}
    	} else if (posicion > arregloEnteros.length){
    		for (int i = 0; i < arregloEnteros.length; i++) {
    	    	arregloGrande[i] = arregloEnteros[i];
    	    arregloGrande[arregloEnteros.length] = entero;
    		}
    	} else {
    		for (int i = 0; i < posicion; i++) {
    			arregloGrande[i] = arregloEnteros[i];
    		}
    		arregloGrande[posicion] = entero;
    		for (int i = posicion+1; i < size; i++) {
    			arregloGrande[i] = arregloEnteros[i-1];
    		}
    	}
    	arregloEnteros = arregloGrande;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int[] arregloNuevo = new int[arregloEnteros.length-1];
    	if (posicion > 0 && posicion < arregloEnteros.length) {
    		for (int i = 0; i < posicion; i ++) {
    			arregloNuevo[i] = arregloEnteros[i];
    		}
    		for (int i = posicion+1; i < arregloNuevo.length; i++) {
    			arregloNuevo[i] = arregloEnteros[i];
    		}
    		arregloEnteros = arregloNuevo;
    	} else if (posicion == 0) {
    		for (int i = 0; i < arregloNuevo.length; i++) {
    			arregloNuevo[i] = arregloEnteros[i+1];
    		}
    		arregloEnteros = arregloNuevo;
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] arregloNuevo = new int[valores.length];
    	for (int i = 0; i < valores.length; i++) {
    		int valor = (int) valores[i];
    		arregloNuevo[i] = valor;
    	}
    	arregloEnteros = arregloNuevo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] arregloNuevo = new String[objetos.length];
    	for (int i = 0; i < objetos.length; i++) {
    		String cadena = objetos[i].toString();
    		arregloNuevo[i] = cadena;
    	}
    	arregloCadenas = arregloNuevo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int[] arregloPositivo = new int[arregloEnteros.length];
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] < 0) {
    			arregloPositivo[i] = arregloEnteros[i]*-1;
    		} else {
    			arregloPositivo[i] = arregloEnteros[i];
    		}
    	}
    	arregloEnteros = arregloPositivo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int contador = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
        	if (arregloEnteros[i] == valor) {
        		contador += 1;
        	}
        }
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int contador = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
        	if (arregloCadenas[i].compareToIgnoreCase(cadena) == 0) {
        		contador += 1;
        	}
        }
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int cantidad = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
        	if (arregloEnteros[i] == valor) {
        		cantidad += 1;
        	}
        }
    	
    	int[] arregloPosiciones = new int[cantidad];
    	int pos = 0;
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] == valor) {
    			arregloPosiciones[pos] = i;
    			pos++;
    		}
       	}

    	return arregloPosiciones;	
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    
    public int[] calcularRangoEnteros( )
    {
    	if (arregloEnteros.length == 0) {
    		return new int[0];
    	}
    	int[] arregloMinMax = new int[2];
		int min = arregloEnteros[0];
    	int max = arregloEnteros[0];
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] < min) {
    			min = arregloEnteros[i];
    		}
    		if (arregloEnteros[i] > max) {
    			max = arregloEnteros[i];
    		}
    	}
    	arregloMinMax[0] = min;
		arregloMinMax[1] = max;

    	return arregloMinMax;
    }

    

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (mapa.get(arregloEnteros[i]) == null) {
    			mapa.put(arregloEnteros[i], 1);
    		} else {
    			int entry = mapa.get(arregloEnteros[i]);
    			mapa.put(arregloEnteros[i], entry+1);
    		}
    	}	
        return mapa;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	Arrays.sort(arregloEnteros);
    	int cantidad = 0;
    	int i = 0;
    	
    	while (i < arregloEnteros.length) {
    		int actual = arregloEnteros[i];
    		int contador = 0;
    		
    		while (i < arregloEnteros.length && arregloEnteros[i] == actual) {
    			contador += 1;
    			i++;
    		}
    		if (contador > 1) {
    			cantidad += 1;
    		}
    	}
    	return cantidad;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean decision = true;
    	int i = 0;
    	if (arregloEnteros.length == 0) {
    		decision = false;
    	}
    	
    	while (i < arregloEnteros.length && arregloEnteros.length == otroArreglo.length) {
    		if (arregloEnteros[i] != otroArreglo[i]) {
    			System.out.println("FALSO");
    			decision = false;
    			break;
    		}
    		i++;
    	}
    	return decision;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	boolean decision = true;
    	if (arregloEnteros.length != otroArreglo.length) {
    		   decision = false;
       	} else {
       		Arrays.sort(arregloEnteros);
       		Arrays.sort(otroArreglo);
       		int i = 0;
        	while (i < arregloEnteros.length) {
        		if (arregloEnteros[i] != otroArreglo[i]) {
        			decision = true;
        		}
        		i++;
        	}
       	}
    	return decision;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	if (arregloEnteros.length != cantidad) {
    		arregloEnteros = new int[cantidad];
        }
        for (int i = 0; i < arregloEnteros.length; i++) {
        	arregloEnteros[i] = minimo + (int) (Math.random() * (maximo - minimo + 1));
        }   	
    	
    }

}
