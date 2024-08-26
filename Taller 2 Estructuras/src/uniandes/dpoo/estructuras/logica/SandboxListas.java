package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas
{
    /**
     * Una lista de enteros para realizar varias de las siguientes operaciones.
     */
    private List<Integer> listaEnteros;

    /**
     * Una lista de cadenas para realizar varias de las siguientes operaciones
     */
    private List<String> listaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    /**
     * Retorna una copia de la lista de enteros, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de enteros
     */
    public List<Integer> getCopiaEnteros( )
    {
    	List<Integer> listaCopiaEnteros = new ArrayList<Integer>();
    	for (Integer valor : listaEnteros) {
    		listaCopiaEnteros.add(valor);
    	}
        return listaCopiaEnteros;
    }

    /**
     * Retorna una copia de la lista de cadenas, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de cadenas
     */
    public List<String> getCopiaCadenas( )
    {
    	List<String> listaCopiaCadenas = new LinkedList<String>();
    	for (String cadena : listaCadenas) {
    		listaCopiaCadenas.add(cadena);
    	}
        return listaCopiaCadenas;
    }

    /**
     * Retorna un arreglo con los valores de la lista de enteros, es decir un arreglo del mismo tamaño que contiene copias de los valores de la lista
     * @return Una arreglo de enteros
     */
    public int[] getEnterosComoArreglo( )
    {
    	int[] arreglo = new int[listaEnteros.size()];
    	for (int i = 0; i < listaEnteros.size(); i++) {
    		arreglo[i] = listaEnteros.get(i);
    	}
        return arreglo;
    }

    /**
     * Retorna la cantidad de valores en la lista de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int cantidad = listaEnteros.size();
        return cantidad;
    }

    /**
     * Retorna la cantidad de valores en la lista de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int cantidad = listaCadenas.size();
        return cantidad;
    }

    /**
     * Agrega un nuevo valor al final de la lista de enteros. Es decir que este método siempre debería aumentar en 1 el tamaño de la lista.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	listaEnteros.addLast(entero);

    }

    /**
     * Agrega un nuevo valor al final de la lista de cadenas. Es decir que este método siempre debería aumentar en 1 la capacidad de la lista.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	listaCadenas.addLast(cadena);

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	listaEnteros.removeIf(n -> n == valor);
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	listaCadenas.removeIf(c -> c == cadena);
    }

    /**
     * Inserta un nuevo entero en la lista de enteros
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en la lista aumentada. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño de la lista, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion < 0) {
    		listaEnteros.addFirst(entero);
    	} else if (posicion > listaEnteros.size()) {
    		listaEnteros.addLast(entero);
    	} else {
    		listaEnteros.add(posicion, entero);
    	}
    }

    /**
     * Elimina un valor de la lista de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición de la lista de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (listaEnteros.size() > posicion && posicion >= 0) {
    		listaEnteros.remove(posicion);
    	}
    }

    /**
     * Reinicia la lista de enteros con los valores contenidos en el parámetro 'valores', pero truncados.
     * 
     * Es decir que si el valor fuera 3.67, en la nueva lista debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	listaEnteros.clear();
    	for (int i = 0; i < valores.length; i++) {
    		int valor = (int) valores[i];
    		listaEnteros.add(valor);
    	}
    }

    /**
     * Reinicia la lista de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarArregloCadenas( List<Object> objetos )
    {
        listaCadenas.clear();
        
        for (Object objeto : objetos) {
            listaCadenas.add(objeto.toString());
        }
    }

    /**
     * Modifica la lista de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < listaEnteros.size(); i++) {
    		if (listaEnteros.get(i) < 0) {
    			listaEnteros.set(i, listaEnteros.get(i)*-1);
    		}
    	}
    }

    /**
     * Modifica la lista de enteros para que todos los valores queden organizados de MAYOR a MENOR.
     */
    public void organizarEnteros( )
    {
    	listaEnteros.sort(Comparator.reverseOrder());
    }

    /**
     * Modifica la lista de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	listaCadenas.sort(Comparator.naturalOrder());
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en la lista de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	Iterator<Integer> iterator = listaEnteros.iterator();
    	int contador = 0;
    	while (iterator.hasNext()) {
    		int i = iterator.next();
    		if (i == valor) {
    			contador += 1;
    		}
    	}
    	return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en la lista de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	Iterator<String> iterator = listaCadenas.iterator();
    	int contador = 0;
    	cadena = cadena.toLowerCase();
    	while (iterator.hasNext()) {
    		String i = iterator.next();
    		i = i.toLowerCase();
    		if (i.equals(cadena)) {
    			contador += 1;
    		}
    	}
    	return contador;
    }

    /**
     * Cuenta cuántos valores dentro de la lista de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	ArrayList<Integer> listaEnterosRevisados = new ArrayList<Integer>();
    	ArrayList<Integer> listaRepetidos = new ArrayList<Integer>();
    	for (int i = 0; listaEnteros.size() > i; i++) {
    		int valor = listaEnteros.get(i);
    		if (!listaEnterosRevisados.contains(valor)) {
    			listaEnterosRevisados.add(valor);
    		} else if (!listaRepetidos.contains(valor)) {
    			listaRepetidos.add(valor);
    		}
    	}
        return listaRepetidos.size();
    }

    /**
     * Compara la lista de enteros con un arreglo de enteros y verifica si contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos son los mismos y en el mismo orden y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean decision = true;
    	
    	if (otroArreglo.length == listaEnteros.size()) {
    		for (int i= 0; otroArreglo.length > i; i++) {
	    		int valorArreglo = otroArreglo[i];
	    		int valorLista = listaEnteros.get(i);
	    		if (valorArreglo != valorLista) {
	    			decision = false;
	    		}	
    		}
    	} else {
    		decision = false;
    	}
    	
        return decision;
    }

    /**
     * Cambia los elementos de la lista de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en la lista deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en la lista
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	if (cantidad > listaEnteros.size()) {
    		for (int i = 0; i < listaEnteros.size(); i++) {
    			listaEnteros.set(i, minimo + (int) (Math.random() * (maximo - minimo + 1)));
    		}
    		while (cantidad > listaEnteros.size()) {
    			listaEnteros.add(minimo + (int) (Math.random() * (maximo - minimo + 1)));
    		}
        } else {
        	while (cantidad < listaEnteros.size()) {
        		listaEnteros.clear();
        		listaEnteros.add(minimo + (int) (Math.random() * (maximo - minimo + 1)));
        	}
        }

    }
}