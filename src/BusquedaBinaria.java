import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author tutaa
 */

public class BusquedaBinaria {

    // ? Elabore un programa en lenguaje de programación Java que permita realizar
    // ? una búsqueda binaria sobre un conjunto de datos ordenados. Defina un valor
    // ? y realice pruebas de búsqueda para arreglos de tamaño 100, 1000, 5000,
    // ? 10000 y 100000 (recuerde que los arreglos deben estar ordenados). Tome los
    // ? tiempos en cada caso y realice una gráfica.

    public static void main(String[] args) {
        new BusquedaBinaria();
    }

    int nEl, arreglo[], num, cont;

    Random random = new Random();

    public BusquedaBinaria() {
        // búsqueda binaria: El arreglo debe estar ordenado, divide en dos arreglos y
        // verifica en cual es mayor...

        llenarArreglo();
        ordenandoArreglo();
        // imprimiendoArreglo();

        int elemento = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Número a buscar en el arreglo: ", "BUSCAR", 3));
        long startTime = System.currentTimeMillis();
        int pos = buscarEnArreglo(elemento);
        if (pos != -1) {
            System.out.println("Elemento " + elemento + " encontrado en la posición " + pos);
        } else {
            System.out.println("Elemento " + elemento + " no encontrado");
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        JOptionPane.showMessageDialog(null,
                "El tiempo total de la búsqueda binaria es: " + totalTime + " mili-segundos.", "TIEMPO DE EJECUCIÓN",
                1);
    }

    public void llenarArreglo() {
        nEl = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el número de datos que desea agregar: ",
                "NÚMERO DE DATOS", 3));
        arreglo = new int[nEl];

        for (int i = 0; i < arreglo.length; i++) {
            num = random.nextInt(nEl);
            arreglo[i] = num;
        }
    }

    public void ordenandoArreglo() {
        for (int i = nEl / 2; i > 0; i /= 2) {
            for (int j = i; j < nEl; j += 1) {
                int temp = arreglo[j];
                int k;
                for (k = j; k >= i && arreglo[k - i] > temp; k -= i) {
                    arreglo[k] = arreglo[k - i];
                }
                arreglo[k] = temp;
            }
        }
    }

    public int buscarEnArreglo(int elemento) {
        int centro, primero, ultimo, valorCentro;
        primero = 0;
        ultimo = nEl - 1;
        while (primero <= ultimo) {
            centro = (primero + ultimo) / 2;
            valorCentro = arreglo[centro];
            if (elemento == valorCentro) {
                return centro;
            } else if (elemento < valorCentro) {
                ultimo = centro - 1;
            } else {
                primero = centro + 1;
            }
        }
        return -1;
    }

    public void imprimiendoArreglo() {
        String text = "";
        for (int i : arreglo) {
            cont++;
            if (cont == 20) {
                text += i + "\n";
                cont = 0;

            } else {
                text += i + "   ";
            }
        }
        JOptionPane.showMessageDialog(null, text, "DATOS", 1);
    }
}
