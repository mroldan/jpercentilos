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

package jpercentilos.res;

import java.io.IOException;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class TablaPercentilos extends Table {

    static final int S_T = 3;   // S(t) index in table
    static final int M_T = 2;   // M(t) index in table
    static final int L_T = 1;   // L(t) index in table
    static final int SD = 4;    // SD(t) index in table (not necesary?)
    static final int VALUE = 0;  // Unit index in table
//    private final Sexo sexo;
//    private final Tipo tipo;
//    static final TablaNormales TABLA_NORMALES;

    public TablaPercentilos(PatientProfile profile, Tipo tipo) throws IOException {
        super(profile.getTableFile(tipo));
    }

    public TablaPercentilos(TextFileReaderME.File file) throws IOException{
        super(file);
    }

    /**
     * Devuelve un array de 2 valores conteniendo el percentilo y el puntaje-z
     * para los valores especificados
     * @param index
     * @param value
     * @return
     */
//    public double[] getCentile(int index, double value) {
//
//    }

    /**
     *
     */
    public static final class Tipo {
        private final String name;

        public static final Tipo TALLA_A_EDAD = new Tipo("TALLA-EDAD");    //leido en cm
        public static final Tipo PESO_A_EDAD = new Tipo("PESO-EDAD");      // Leído en Kg
        public static final Tipo IMC_A_EDAD = new Tipo("IMC-EDAD");        //
        public static final Tipo PC_A_EDAD = new Tipo("PC-EDAD");          // Leído en mm
        public static final Tipo PESO_A_TALLA = new Tipo("PESO-TALLA");

        public Tipo(String name) {
            this.name = name;
        }

        public String bitPath() {
            return toString();
        }

        public String toString() {
            return name;
        }

        public static Tipo[] values() {
            Tipo[] t = {TALLA_A_EDAD, PESO_A_EDAD, IMC_A_EDAD, PC_A_EDAD, PESO_A_TALLA};
            return t;
        }

    }

}
