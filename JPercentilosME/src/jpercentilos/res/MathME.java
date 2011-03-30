/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class MathME {

    public static final double DEFAULT_PRECISION = 1e-8;

    private MathME() {
    }

    public static double exp(double a) {
        return exp(a, DEFAULT_PRECISION);
    }

    private static double exp(double a, double precision) {
        int iterMax = 50;
        double sum = 1 + a;
        double e = a;
        int i = 2;
        do {            
            e = realPow(a, i) / fact(i);
            sum += e;
            i++;
        } while (i < iterMax && Math.abs(e / sum) > precision);
        return sum;
    }

    /**
     * Devuelve el factorial de un entero <code>n<code> positivo.
     * @param n
     * @return
     */
    public static long fact(int n) {
        if (n <= 1 && n >= 0) {
            return 1;
        } else if (n > 1) {
            return n * fact(n - 1);
        } else {
            return 0;
        }
    }

    /**
     * Devuelve el logaritmo natural de un valor <code>a<code>. El criterio de
     * paro es el dado por el parámetro <code>precision<code>.
     * @param a
     * @param precision
     * @return ln(a)
     */
    public static double log(double a, double precision) { //TODO Agregar situaciones excepcionales
        if (a == 1) {
            return 0;
        }
        int iterMax = 50;
        // true if a is greater than 1
        boolean gt1 = (Math.sqrt((a - 1) * (a - 1)) <= 1) ? false : true;
        double e, sum;
        int sign = -1; // used to switch signs
        if (gt1) {
            sum = 1 / (a / a - 1);
            e = sum;
            for (int i = 2; (i <= iterMax) && (Math.abs(e / sum) > precision); i++) {
                e = 1 / realPow((a / a - 1), i);
                sum += e;
            }
        } else {
            sum = a - 1;
            e = sum;
            for (int i = 2; (i <= iterMax) && (Math.abs(e / sum) > precision); i++) {
                e = sign * realPow((a - 1), i) / (double) i;
                sum += e;
                sign *= -1; // change sign
            }
        }
        return sum;
    }

    /**
     * Devuelve el logaritmo natural de un valor <code>a<code> con la precisión
     * por defecto de 8 cifras significativas.
     * @param a
     * @return
     */
    public static double log(double a) {
        return log(a, DEFAULT_PRECISION);
    }

    /**
     * Devuelve el primer argumento elevado al segundo argumento.
     * @param a
     * @param b
     * @return a^b
     */
    public static double pow(double a, double b) {
        // es exponente negativo?
        if (b < 0) {
            a = 1 / a;
            b *= -1;
        }
        // el exponente es un número entero?
        if ((b - Math.floor(b)) == 0) {
            return realPow(a, (int) b);
        }
        return realPow(a, b);
    }

    private static double realPow(double a, int b) {
        double p = a;
        if (b == 0 && a != 0) {
            return 1;
        } else if (b == 1 && a != 0){
            return a;
        } else {
            for (int i = 1; i < b; i++) {
                p *= a;
            }
            return p;
        }
    }

    private static double realPow(double a, double b) {
        return exp(b * log(a));
    }

    public static double rint(double a) {
        double floor = Math.floor(a);
        double ceil = Math.ceil(a);
        if (ceil - a <= 0.5) {
            return ceil;
        } else {
            return floor;
        }
    }

    /**
     * Devuelve 1 si el signo si <code>(a >= 0)<code>, -1 si <code>(a <= 0)<code>.
     * @param a
     * @return
     */
    public static double signum(double a) {
        if (a >= 0) {
            return 1.0;
        } else {
            return -1.0;
        }
    }
}
