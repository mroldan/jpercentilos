/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

/**
 * Interface containing Enum classes for unit conversion and assignment.
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public interface Dimensionizable {

    double getValueInUnit(double value, Unit anotherUnit) throws InvalidUnitException;

    static class Unit {

        protected final double multiplier;
        protected final String name;

        Unit(String name, double multiplier) {
            this.name = name;
            this.multiplier = multiplier;
        }

        public String toString() {
            return name;
        }

        public String getName() {
            return name;
        }

        public double getMultiplier() {
            return multiplier;
        }
    }

    static final class AgeUnit extends Unit {

        public static final AgeUnit AÑO = new AgeUnit("AÑO", (30.4375 * 12));
        public static final AgeUnit MES = new AgeUnit("MES", 30.4375);
        public static final AgeUnit SEMANA = new AgeUnit("SEMANA", 7);
        public static final AgeUnit DÍA = new AgeUnit("DÍA", 1);

        private AgeUnit(String name, double multiplier) {
            super(name, multiplier);
        }
    }

    static final class LengthUnit extends Unit {

        public static final LengthUnit M = new LengthUnit("M", 1000);
        public static final LengthUnit CM = new LengthUnit("CM", 10);
        public static final LengthUnit MM = new LengthUnit("MM", 1);

        private LengthUnit(String name, double multiplier) {
            super(name, multiplier);
        }

    }

    static final class WeightUnit extends Unit {

        public static final WeightUnit G = new WeightUnit("G", 1);
        public static final WeightUnit KG = new WeightUnit("KG", 1000);

        private WeightUnit(String name, double multiplier) {
            super(name, multiplier);
        }

    }

    public static class InvalidUnitException extends Exception {

        public InvalidUnitException(String message) {
            super(message);
        }
    }
}
