/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

/**
 * This class contains inner classes to wrap values and it's units. Also contains
 * methods to convert between units.
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class Magnitude {

    protected final double value;

    public Magnitude(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}