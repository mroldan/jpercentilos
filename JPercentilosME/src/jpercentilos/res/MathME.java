/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class MathME {


//    static double ln(double a) {
//
//    }

    static double pow(double a, double b) {
        // is exponent a negative number
        if (b < 0) {
            return realPow((double)1 / a, b);
        }
        // is exponent a whole number?
        if ((b - Math.floor(b)) == 0) {
            return realPow(a, (int) b);
        }
        return realPow(a, b);
    }

    private static double realPow(double a, int b) {
        double p = a;
        if (b == 0 && a != 0) {
            return 1;
        } else {
            for (int i = 1; i < b; i++){
                p *= a;
            }
            return p;
        }
    }

    private static double realPow(double a, double b) {
        // true if base is greater than 1
        boolean gt1 = (Math.sqrt((a - 1) * (a - 1)) <= 1) ? false : true;
        int oc = -1; // used to alternate math symbol (+,-)
        int iter = 20; // number of iterations
        double p, x, x2, sumX, sumY;
        x = (gt1)
                ? (a / (a - 1)) : // base is greater than 1
                (a - 1); // base is 1 or less
        sumX = (gt1)
                ? (1 / x) : // base is greater than 1
                x; // base is 1 or less
        for (int i = 2; i < iter; i++) {
            // find x^iteration
            p = x;
            for (int j = 1; j < i; j++) {
                p *= x;
            }
            double xTemp = (gt1)
                    ? (1 / (i * p)) : // base is greater than 1
                    (p / i); // base is 1 or less
            sumX = (gt1)
                    ? (sumX + xTemp) : // base is greater than 1
                    (sumX + (xTemp * oc)); // base is 1 or less
            oc *= -1; // change math symbol (+,-)
        }
        x2 = b * sumX;
        sumY = 1 + x2; // our estimate
        for (int i = 2; i <= iter; i++) {
            // find x2^iteration
            p = x2;
            for (int j = 1; j < i; j++) {
                p *= x2;
            }
            // multiply iterations (ex: 3 iterations = 3*2*1)
            int yTemp = 2;
            for (int j = i; j > 2; j--) {
                yTemp *= j;
            }
            // add to estimate (ex: 3rd iteration => (x2^3)/(3*2*1) )
            sumY += p / yTemp;
        }
        return sumY; // return our estimate
    }

    static double rint(double a) {
        double floor = Math.floor(a);
        double ceil = Math.ceil(a);
        if (ceil - a <= 0.5) {
            return ceil;
        } else {
            return floor;
        }
    }

}
