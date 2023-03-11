import java.util.Random;

import javax.swing.JOptionPane;

// ? La gerencia de la empresa ABC, preocupada por las bajas remuneraciones de
// ? su personal, ha decidido entregar una bonificación ascendiente al 5% del sueldo
// ? a los 30 nEmp con más baja remuneración. El gerente desea tener una lista
// ? con el RUT de los beneficiados y, además, desea saber a cuánto asciende el
// ? costo total de las bonificaciones. La empresa almacenará los datos del personal
// ? en dos arreglos paralelos: uno contendrá el RUT de los 100 nEmp y otro
// ? estará en correspondencia con éste conteniendo el sueldo de cada uno.

public class EmpresaABC {
    int nEmp = 100, aux;
    int[] ruts = new int[nEmp];
    int[] sueldos = new int[nEmp];
    int rutI = 448;
    String text = "";
    Random random = new Random();

    public EmpresaABC() {
        rellenar();
        metodoBurbuja();
        imprimirArreglo();
        empleadoMasBonificacion();
        empleadoMenosBonificacion();
        busquedaEmpleado();

    }

    public void rellenar() {
        for (int i = 0; i < 100; i++) {
            ruts[i] = rutI;
            sueldos[i] = ((int) (Math.random() * 1_000_000));
            rutI += 2;
        }
    }

    public void metodoBurbuja() {
        // ? MÉTODO BURBUJA
        for (int i = 0; i < (nEmp - 1); i++) {
            for (int j = 0; j < (nEmp - 1); j++) {
                if (sueldos[j] > sueldos[j + 1]) {
                    aux = sueldos[j];
                    sueldos[j] = sueldos[j + 1];
                    sueldos[j + 1] = aux;
                }
            }
        }
    }

    public void imprimirArreglo() {
        String text = "";
        for (int i = 0; i < sueldos.length; i++) {
            if ((nEmp - 1) == i) {
                text += sueldos[i] + ".";
            } else {
                text += sueldos[i] + ", ";
            }
        }
        JOptionPane.showMessageDialog(null, "El arreglo es: \n" + text);

    }

    // ! Implemente funciones que permitan:

    // ? Encontrar el empleado con la mayor bonificación,
    private void empleadoMasBonificacion() {

    }

    // ? Encontrar el empleado con la menor bonificación,
    private void empleadoMenosBonificacion() {

    }

    // ? Encontrar un empleado a partir de su RUT
    private void busquedaEmpleado() {

    }

    public static void main(String[] args) {
        new EmpresaABC();

    }

}
