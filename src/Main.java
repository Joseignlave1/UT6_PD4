import java.util.HashMap;
import java.util.Map;

public class Main {
     /*
        Utilizaría un HashMap, debido a qué tanto la búsqueda como la actualización tienen un tiempo de ejecución constante O(1),
        lo que lo hace eficiente para manejar grandes cantidades de entradas.
     */

    public static void contarOcurrenciasPalabras(String[] texto) {
        HashMap<String, Integer> ocurrenciasDePalabras = new HashMap<>();
        int mayorOcurrencia = 0;
        for(String palabra : texto) {
            String[] palabras = palabra.split( " ");
            for(String palabraDividida : palabras) {
                palabraDividida = limpiarPalabra(palabraDividida.toLowerCase());
                if(ocurrenciasDePalabras.containsKey(palabraDividida)) {
                    ocurrenciasDePalabras.put(palabraDividida, ocurrenciasDePalabras.get(palabraDividida) + 1);
                } else {
                    ocurrenciasDePalabras.put(palabraDividida, 1);
                }
            }
        }

        for(Map.Entry<String, Integer> entrada : ocurrenciasDePalabras.entrySet()) {
            System.out.println("Palabra"  + " " +  entrada.getKey() + " "  + "Ocurrencias"+ " " +  entrada.getValue());
        }

    }

    //Método auxiliar para "limpiar" la palabra, eliminando los signos de puntuación"

    public static String limpiarPalabra(String palabra) {
        String signosDePuntuacion = ".,;:!?()[]{}'\"";
        for(char c : signosDePuntuacion.toCharArray()) {
            palabra = palabra.replace(Character.toString(c), "");
        }
        return palabra;
    }

    public static void main(String[] args) {
        String[] leerArchivo = ManejadorArchivosGenerico.leerArchivo("src/libro.txt");
        contarOcurrenciasPalabras(leerArchivo);
    }
}