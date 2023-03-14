import java.util.Random;

import javax.swing.JOptionPane;

/**
 *
 * @author cristof
 */

public class Cine {

    // ? El gerente de las salas de cine Cinemax desea conocer algunas estadísticas
    // ? respecto de las películas más vistas. Las mismas 15 películas son exhibidas
    // ? en cada una de las 7 salas de cine. Para cada sala se requiere almacenar el
    // ? total de personas que han asistido a ver cada película.

    public static void main(String[] args) {
        new Cine();
    }

    int nSalas = 7, nPel = 15, aforoTotal[][], perMaxPel = 0, perMaxSal = 0, totalPerPel[], totalPerSal[], posPel,
            posSal;
    String lPel[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };

    Random random = new Random();

    public Cine() {
        rellenar();
        mostrar(aforoTotal);
        totalPerPel();
        totalPerSal();
        pelMasVista();
        salaMasVisitada();
        combiSalPel();
    }

    public void rellenar() {
        aforoTotal = new int[nSalas][nPel];
        for (int i = 0; i < aforoTotal.length; i++) {
            for (int j = 0; j < aforoTotal[i].length; j++) {
                int num = random.nextInt(30, 300);
                aforoTotal[i][j] = num;
            }
        }
    }

    public void mostrar(int matriz[][]) {
        String text = "PELÍCULA        A         B         C         D         E         F        G        H        I         J        K        L         M         N         O";
        int c = 0;
        for (int[] i : matriz) {
            c++;
            text += "\nSala " + c + ":            ";
            for (int j : i) {
                if (j < 100) {
                    text += j + "       ";
                } else {
                    text += j + "    ";
                }
            }
        }
        JOptionPane.showMessageDialog(null, text, "CINEMAX", 1);
    }

    public void totalPerPel() {
        String text = "PELÍCULA      A          B          C          D          E          F          G          H          I          J          K          L          M          N          O\nTOTAL:       ";
        totalPerPel = new int[nPel];
        for (int i = 0; i < aforoTotal.length; i++) {
            for (int j = 0; j < aforoTotal[i].length; j++) {
                totalPerPel[j] += aforoTotal[i][j];
            }
        }
        for (int i : totalPerPel) {
            if (i < 1000) {
                text += i + "     ";
            } else {
                text += i + "   ";
            }
        }
        JOptionPane.showMessageDialog(null, text, "AFORO TOTAL POR PELÍCULA", 1);
    }

    public void totalPerSal() {
        int cont = 0;
        String text = "SALA   TOTAL\n";
        totalPerSal = new int[nSalas];

        for (int i = 0; i < aforoTotal.length; i++) {
            for (int j = 0; j < aforoTotal[i].length; j++) {
                totalPerSal[i] += aforoTotal[i][j];
            }
        }
        for (int i : totalPerSal) {
            cont++;
            text += "    " + cont + ":       " + i + "\n";
        }
        JOptionPane.showMessageDialog(null, text, "AFORO TOTAL POR SALA", 1);

    }

    // ? Cual fue la película más vista.
    public void pelMasVista() {
        for (int i = 0; i < totalPerPel.length; i++) {
            if (totalPerPel[i] > perMaxPel) {
                perMaxPel = totalPerPel[i];
                posPel = i;
            }
        }
        JOptionPane.showMessageDialog(null,
                "La película más vista fué la: " + lPel[posPel] + " con " + perMaxPel + " personas",
                "PELÍCULA MÁS VISTA", 1);
    }

    public void salaMasVisitada() {
        for (int i = 0; i < totalPerSal.length; i++) {
            if (totalPerSal[i] > perMaxSal) {
                perMaxSal = totalPerSal[i];
                posSal = i;
            }
        }
        JOptionPane.showMessageDialog(null,
                "La sala más visitada fué la: Sala " + (posSal + 1) + " con " + perMaxSal + " personas",
                "SALA MÁS VISITADA", 1);
    }

    // ? Se requiere saber cuál es la mejor combinación sala-película, más vista.
    public void combiSalPel() {
        String text = "La combinación sala-película más vista es: Sala " + (posSal + 1) + " Película " + lPel[posPel];
        JOptionPane.showMessageDialog(null, text, "COMBINACIÓN", 1);

    }

}
