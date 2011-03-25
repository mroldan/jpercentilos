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

/**
 * Clase con métodos para cálculo de funciones complejas.
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 * @autor Zielinski Leonardo Daniel <leonardo_03z@hotmail.com>
 */


public final class JPMath {

    int k = 1;
    int n = 0;
    double sumatoria;
    double fin;
    double iteracion1;
    double multiplicador;

    public double erf(double z) {

        multiplicador = (2 / Math.sqrt(Math.PI));

        iteracion1 = (2 / Math.sqrt(Math.PI)) * (z / 2 * n) * ((Math.pow(-z, 2)) / k);

        for (n = 1; n < 20; n++) {

            sumatoria = (z / 2 * n);

            for (k = 1; k < n; k++) {

                fin = (sumatoria) * ((Math.pow(-z, 2)) / k);


            } // fin del for anidado

        } // fin del for
        return fin;
    }
} // fin de la clase JPMath
/*
 *
 */
/*

<<< .mine
=======
    
    /**
     * Devuelve el factorial de un entero <code>n<code> positivo.
     * @param n
     * @return
     * @throws Exception - Si <code>n<code> es negativo.
     */
        /*
    public static long

fact(int n) throws Exception {
        if (n <= 1) {
            return 1;








} else {
            return n * fact(n - 1);




}
    }



>>>>>>> .r50
*/
