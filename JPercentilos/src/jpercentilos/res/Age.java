/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Age(Date birthDate) {
        this((double) daysFromNow(birthDate), AgeUnit.DÍA);
    }

    private static long daysFromNow(Date date) {
        long dif = date.getTime() - Calendar.getInstance().getTime().getTime();
        if (Long.signum(dif) == -1) {
            dif = -dif;
        }
        long días = dif / (1000 * 60 * 60 * 24);
        return días;
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
    
    public Date getBirthDate() {
        long days = 0;
        try {
            days = (long) this.getValueInUnit(AgeUnit.DÍA);
        } catch (InvalidUnitException ex) {
            ex.printStackTrace();
        }
        days *= (1000 * 60 * 60 * 24);
        long dif = Calendar.getInstance().getTime().getTime() - days;
        return new Date(dif);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Age) {
            Age other = (Age) obj;
            if (this.unit == other.unit && this.getValue() == other.getValue()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
