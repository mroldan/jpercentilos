/*
 *  Copyright (C) 2011 Joaquín Ignacio Aramendía <samsagax@gmail.com>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jpercentilos;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import jpercentilos.Paciente.Sexo;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class TablaPercentilos {

    static final int P50 = 0;
    static final int SD = 1;
    private final Sexo sexo;
    private final Tipo tipo;
    static final TablaNormales TABLA_NORMALES = new TablaNormales();
    private final double[][] TABLA;

    public TablaPercentilos(Sexo sexo, Tipo tipo) {
        this.sexo = sexo;
        this.tipo = tipo;
        this.TABLA = readTable(getFileName(sexo, tipo));
    }

    static String getFileName(Sexo sexo, Tipo tipo) {
        StringBuilder fn = new StringBuilder();
        fn.append(sexo.bitPath()).append(tipo.bitPath());
        return fn.toString();
    }

    /**
     * Lee la tabla contenida en el archivo especificado
     * @param fromFile
     * @return
     */
    private static double[][] readTable(String fromFile) { //TODO Leer tablas
        double[][] t = initializeTable();
        String s = TextScanner.retrieveText(TablaNormales.class.getResourceAsStream("tables/" + fromFile));
            Scanner scan = new Scanner(s);
            scan.useLocale(Locale.US);
            try {
                scan.nextLine(); //Ignora la primer línea.
                for (int i = 0; i < t.length; i++) {
                    scan.nextDouble(); //Ignora el primer número
                    for (int j = 0; j < t[i].length; j++) {
                        if (scan.hasNextDouble()) {
                            t[i][j] = scan.nextDouble();
                        }
                    }
                }
            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                scan.close();
            }
        return t;
    }

    public double getCentile(int index, double value) {
        double Px = TABLA[index][P50];
        double Sx = TABLA[index][SD];
        return TABLA_NORMALES.getPx(value, Px, Sx);
    }

    private static double[][] initializeTable() {
        double[][] t = new double[1857][2];
        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i], 0);
        }
        return t;
    }
    
    public enum Tipo {
        
        TALLA,  // Leída en cm
        PESO,   // Leído en kg
        IMC,    //
        PC;     // Leído en mm

        public String bitPath() {
            return this.toString().substring(0, 2).toLowerCase();
        }

        @Override
        public String toString() {
            return this.name();
        }

    }

}
