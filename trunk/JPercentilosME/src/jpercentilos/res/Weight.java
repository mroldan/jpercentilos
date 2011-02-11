/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpercentilos.res;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class Weight extends Magnitude implements Dimensionizable {

        private WeightUnit unit;
        public static final Weight NA = new Weight(-1, WeightUnit.KG);

        public Weight(double value, WeightUnit unit) {
            super(value);
            this.unit = unit;
        }

        public double getValueInUnit(Unit anotherUnit) throws InvalidUnitException {
            return getValueInUnit(value, anotherUnit);
        }


        public double getValueInUnit(double value, Unit anotherUnit) throws InvalidUnitException {
            if (anotherUnit instanceof WeightUnit) {
                WeightUnit weightUnit = (WeightUnit) anotherUnit;
                return value * unit.getMultiplier() / weightUnit.getMultiplier();
            } else {
                throw new InvalidUnitException("Invalid unit: " + anotherUnit.toString()
                        + " not an instance of " + unit.getClass().toString());
            }
        }
    }
