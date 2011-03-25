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

    private static final double PRECISION = 1e-8;

    private JPMath() {
    }

    /**
     * Devuelve la función error de un valor real <code>z<code>.
     * @param z
     * @return erf(z)
     */
    public static double erf(double z) {
        double e;
        double res;
        res = z;
        e = res;
        for (int n = 1; n < 20 || e/res > PRECISION; n++) { //TODO Revisar el criterio de parada de acuerdo al error
            e = (z / (double) (2 * n + 1));
            double multiplicador = 1;
            for (int k = 1; k < n; k++) {
                multiplicador *= (-Math.pow(z, 2) / (double) k);
            } // fin del for anidado
            e *= multiplicador;
            res += e;
        } // fin del for
        return ((double) 2 / Math.sqrt(Math.PI)) * res;
    }

    /**
     * Devuelve la función error complementaria de un valor real <code>z<code>.
     * @param z
     * @return erfc(z) = 1 - erf(z)
     */
    public static double erfc(double z) {
        double erfc = (1 - erf(z));
        return erfc;
    }

    /**
     * Devuelve el factorial de un entero <code>n<code> positivo.
     * @param n
     * @return
     * @throws Exception - Si <code>n<code> es negativo.
     */
    public static long fact(int n) throws Exception {
        if (n <= 1 && n >= 0) {
            return 1;
        } else if (n > 1) {
            return n * fact(n - 1);
        } else {
            throw new Exception("Entero inválido para calcular factorial: " + n);
        }
    }

    /**
     * Devuelve la función de distribución de probabilidad normal estandar de un
     * valor real <code>z<code>.
     * @param z
     * @return phi(z)
     */
    public static double phi(double z) {
        double phi = ((double) 1 / (double) 2) * erfc(-z / Math.sqrt(2));
        return phi;
    }

    /**
     * Devuelve el logaritmo natural de la variable <code>x<code>.
     * @param x
     * @return ln(x)
     */
    public static double logn(double x) {
        return Math.log(x);
    }

    /**
     * Devuelve e^x para <code>x<code>.
     * @param x
     * @return e^x
     */
    public static double exp(double x) {
        return Math.exp(x);
    }

    /**
     * Devuelve el primer argumento elevado al segundo argumento.
     * @param x
     * @param y
     * @return x^y
     */
    public static double pow(double x, double y) {
        return Math.pow(x, y);
    }

    /**
     * Devuelve el valor absoluto del argunmento.
     * @param a
     * @return 'a' sin signo.
     */
    static double abs(double a) {
        return Math.abs(a);
    }
}
