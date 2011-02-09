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

    private final double value;

    public Magnitude(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static class Age extends Magnitude implements Dimensionizable {

        private final AgeUnit unit;
        public static final Age NA = new Age(-1, AgeUnit.AÑO);

        public Age(double value, AgeUnit unit) {
            super(value);
            this.unit = unit;
        }

//        public double getValueInUnit(Unit anotherUnit) throws InvalidUnitException {
//            return getValueInUnit(value, anotherUnit);
//        }

        public double getValueInUnit(double value, Unit anotherUnit) throws InvalidUnitException {
            if (anotherUnit instanceof AgeUnit) {
                AgeUnit ageUnit = (AgeUnit) anotherUnit;
                return value / unit.getMultiplier() * ageUnit.getMultiplier();
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

    public static class Length extends Magnitude implements Dimensionizable {

        private LengthUnit unit;
        public static final Length NA = new Length(-1, LengthUnit.M);

        public Length(double value, LengthUnit unit) {
            super(value);
            this.unit = unit;
        }

//        public double getValueInUnit(Unit anotherUnit) throws InvalidUnitException {
//            return getValueInUnit(value, anotherUnit);
//        }

        public double getValueInUnit(double value, Unit anotherUnit) throws InvalidUnitException {
            if (anotherUnit instanceof LengthUnit) {
                LengthUnit lengthUnit = (LengthUnit) anotherUnit;
                return value / unit.getMultiplier() * lengthUnit.getMultiplier();
            } else {
                throw new InvalidUnitException("Invalid unit: " + anotherUnit.toString()
                        + " not an instance of " + unit.getClass().toString());
            }
        }
    }

    public static class Weight extends Magnitude implements Dimensionizable {

        private WeightUnit unit;
        public static final Weight NA = new Weight(-1, WeightUnit.KG);

        public Weight(double value, WeightUnit unit) {
            super(value);
            this.unit = unit;
        }

//        public double getValueInUnit(Unit anotherUnit) throws InvalidUnitException {
//            return getValueInUnit(value, anotherUnit);
//        }


        public double getValueInUnit(double value, Unit anotherUnit) throws InvalidUnitException {
            if (anotherUnit instanceof WeightUnit) {
                WeightUnit weightUnit = (WeightUnit) anotherUnit;
                return value / unit.getMultiplier() * weightUnit.getMultiplier();
            } else {
                throw new InvalidUnitException("Invalid unit: " + anotherUnit.toString()
                        + " not an instance of " + unit.getClass().toString());
            }
        }
    }

    public static class Height extends Length {

        public Height(double value, LengthUnit unit) {
            super(value, unit);
        }
    }

    public static class HeadPerimeter extends Length {

        public HeadPerimeter(double value, LengthUnit unit) {
            super(value, unit);
        }
    }
}
