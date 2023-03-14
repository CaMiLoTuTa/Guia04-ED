import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public EmpresaABC() {
        rellenar();
        imprimirArreglo(sueldos);
        ordenar();
        masBonificacion();
        empleadoMasBonificacion();
        empleadoMenosBonificacion();
        busquedaEmpleado();
        gastosTotales();
    }

    int nEmp, aux, rutI = 448, cont, rutEmpMasBon, rutEmpMenosBon;
    Double bonTotal = 0.0, bonEmpMin = 0.0, bonEmpMax = 10_000_000.0;

    Map<Integer, Double> sueldos = new HashMap<>();
    Map<Integer, Double> sueldosOrdenados = new LinkedHashMap<>();
    Map<Integer, Double> primerosTreinta = new LinkedHashMap<>();

    Random random = new Random();

    public void rellenar() {
        nEmp = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos empleados desea agregar? "));
        for (int i = 0; i < nEmp; i++) {
            sueldos.put((rutI += 2), (double) random.nextInt(1_000_000, 10_000_000));
        }
    }

    public void ordenar() {
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(sueldos.entrySet());

        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Double> i : list) {
            sueldosOrdenados.put(i.getKey(), i.getValue());
        }
        imprimirArreglo(sueldosOrdenados);
    }

    public void imprimirArreglo(Map<Integer, Double> diccionario) {
        cont = 0;
        String text = "";
        for (int i : diccionario.keySet()) {
            cont++;
            if (cont == (nEmp / 10)) {
                text += (i + ": $" + diccionario.get(i)) + "\n";
                cont = 0;
            } else {
                text += (i + ": $" + diccionario.get(i)) + ",   ";
            }
        }
        JOptionPane.showMessageDialog(null, text);
    }

    public void masBonificacion() {
        int rut;
        Double sueldoBonificacion;
        cont = 0;

        for (int i : sueldosOrdenados.keySet()) {
            cont++;
            rut = i;
            sueldoBonificacion = (sueldosOrdenados.get(i) + (sueldosOrdenados.get(i) * 0.05));

            bonTotal += (sueldosOrdenados.get(i) * 0.05);

            if ((sueldosOrdenados.get(i) * 0.05) > bonEmpMin) {
                rutEmpMasBon = i;
                bonEmpMin = (sueldosOrdenados.get(i) * 0.05);
            }
            if ((sueldosOrdenados.get(i) * 0.05) < bonEmpMax) {
                rutEmpMenosBon = i;
                bonEmpMax = (sueldosOrdenados.get(i) * 0.05);
            }
            primerosTreinta.put(rut, sueldoBonificacion);

            if (cont == (nEmp * 0.3)) {
                break;
            }
        }
        imprimirArreglo(primerosTreinta);
    }

    // ? Encontrar el empleado con la mayor bonificación,
    public void empleadoMasBonificacion() {
        JOptionPane.showMessageDialog(null,
                "El empleado con más bonificación es: " + rutEmpMasBon + " con: +$" + bonEmpMin);
    }

    // ? Encontrar el empleado con la menor bonificación,
    public void empleadoMenosBonificacion() {
        JOptionPane.showMessageDialog(null,
                "El empleado con menos bonificación es: " + rutEmpMenosBon + " con: +$" + bonEmpMax);
    }

    // ? Encontrar un empleado a partir de su RUT
    public void busquedaEmpleado() {
        for (;;) {
            String buscarRut = JOptionPane.showInputDialog("Escriba el RUT del empleado o \"salir\"");

            if (buscarRut.equals("salir")) {
                break;

            } else {
                Double buscarSueldo = sueldosOrdenados.get(Integer.parseInt(buscarRut));

                JOptionPane.showMessageDialog(null,
                        "El empleado con el RUT: " + buscarRut + "\nTiene un sueldo de: $" + buscarSueldo);
            }
        }
    }

    // ? Encontrar cuánto se gasta la empresa finalmente
    public void gastosTotales() {
        JOptionPane.showMessageDialog(null,
                "La empresa gasta un total de: $" + bonTotal);
    }

    public static void main(String[] args) {
        new EmpresaABC();

    }

}
