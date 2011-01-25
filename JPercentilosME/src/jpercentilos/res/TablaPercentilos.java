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
import jpercentilos.res.Paciente.Sexo;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class TablaPercentilos extends Table {

    static final int P50 = 0;
    static final int SD = 1;
    private final Sexo sexo;
    private final Tipo tipo;
    static TablaNormales TABLA_NORMALES;

    public TablaPercentilos(Sexo sexo, Tipo tipo) throws IOException {
        super("tables/" + getFileName(sexo, tipo));
        TABLA_NORMALES = new TablaNormales();
        this.sexo = sexo;
        this.tipo = tipo;

    }

    private static String getFileName(Sexo sexo, Tipo tipo) {
        StringBuffer fn = new StringBuffer();
        fn.append(sexo.bitPath()).append(tipo.bitPath());
        return fn.toString();
    }

    /**
     * Devuelve un array de 2 valores conteniendo el percentilo y el puntaje-z
     * para los valores especificados
     * @param index
     * @param value
     * @return
     */
    public double[] getCentile(int index, double value) {
        double Px = getElementAt(index, P50);
        double Sx = getElementAt(index, P50);
        double[] centiles = { TABLA_NORMALES.getPx(value, Px, Sx), TablaNormales.getStandardZ(value, Px, Sx)};
         return centiles;
    }

    public static final class Tipo {
        private final String name;

        public static final Tipo TALLA = new Tipo("Talla");    //leido en cm
        public static final Tipo PESO = new Tipo("Peso");      // Leído en Kg
        public static final Tipo IMC = new Tipo("IMC");        //
        public static final Tipo PC = new Tipo("PC");          // Leído en mm

        public Tipo(String name) {
            this.name = name;
        }

        public String bitPath() {
            return this.toString().substring(0, 2).toLowerCase();
        }

        public String toString() {
            return this.name;
        }

    }

}
