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
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class TablaPercentilos {

    static final int P50 = 0;
    static final int SD_MINUS = 1;
    static final int SD_PLUS = 2;
    private final Sexo sexo;
    private final Tipo tipo;
    static final TablaNormales TABLA_NORMALES = new TablaNormales();
    private final double[][] TABLA;

    public TablaPercentilos(Sexo sexo, Tipo tipo) {
        this.sexo = sexo;
        this.tipo = tipo;
        this.TABLA = readTable(getFileName(sexo, tipo));
    }

    static File getFileName(Sexo sexo, Tipo tipo) {
        StringBuilder fn = new StringBuilder();
        fn.append(sexo.bitPath()).append(tipo.bitPath());
        return new File(fn.toString());
    }

    /**
     *
     * @param fromFile
     * @return
     */
    private static double[][] readTable(File fromFile) { //TODO Leer tablas
        double[][] t = initializeTable();
        TextScanner tx = new TextScanner(fromFile.getPath());
        try {    
            String s = tx.retrieveText();
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
        } catch (IOException ex) {
            System.out.println("Error archivo normaltable");
            ex.printStackTrace();
            Logger.getLogger(TablaNormales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    private static double[][] initializeTable() {
        double[][] t = new double[181][3];
        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i], 0);
        }
        return t;
    }

    static void saveTable(File toFile) {

    }
    
    public enum Sexo {

        VARÓN,
        MUJER;

        public String bitPath() {
            return this.toString().substring(0, 1).toLowerCase();
        }

        @Override
        public String toString() {
            return this.name();
        }

    }
    
    public enum Tipo {
        
        TALLA,
        PESO,
        IMC,
        PC;

        public String bitPath() {
            return this.toString().substring(0, 1).toLowerCase();
        }

        @Override
        public String toString() {
            return this.name();
        }

    }

}
