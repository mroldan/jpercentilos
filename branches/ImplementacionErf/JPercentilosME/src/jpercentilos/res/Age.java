/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpercentilos.res;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class Age extends Magnitude implements Dimensionizable {

        private final AgeUnit unit;
        public static final Age NA = new Age(-1, AgeUnit.AÑO);

        public Age(double value, AgeUnit unit) {
            super(value);
            this.unit = unit;
        }

        public double getValueInUnit(Unit anotherUnit) throws InvalidUnitException {
            return getValueInUnit(value, anotherUnit);
        }

        public double getValueInUnit(double value, Unit anotherUnit) throws InvalidUnitException {
            if (anotherUnit instanceof AgeUnit) {
                AgeUnit ageUnit = (AgeUnit) anotherUnit;
                return (value * unit.getMultiplier()) / ageUnit.getMultiplier();
            } else {
                throw new InvalidUnitException("Invalid unit: " + anotherUnit.toString()
                        + " not an instance of " + unit.getClass().toString());
            }
        }

        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + (this.unit != null ? this.unit.hashCode() : 0);
            return hash;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Age) {
                Age other = (Age) obj;
                if (this.unit == other.unit && this.getValue() == other.getValue()) {
                    return true;
                } else return false;
            } else return false;
        }
}
