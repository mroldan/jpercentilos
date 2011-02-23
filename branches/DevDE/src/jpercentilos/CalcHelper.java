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
package jpercentilos;

import java.text.DecimalFormat;
import jpercentilos.res.Dimensionizable.InvalidUnitException;
import jpercentilos.res.Patient;
import jpercentilos.res.PatientProfile.DataNotFoundException;
import jpercentilos.res.TablaPercentilos.Tipo;

/**
 * Class containing methods to calculate and get strings to be shown in the main
 * GUI.
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class CalcHelper {

    private Patient patient;
    private final DecimalFormat percentFormat = initPercentFormat();
    private final DecimalFormat doubleFormat = initDoubleFormat();

    private DecimalFormat initPercentFormat() {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getPercentInstance();
        df.setMinimumFractionDigits(1);
        return df;
    }

    private DecimalFormat initDoubleFormat() {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getNumberInstance();
        df.setMaximumFractionDigits(3);
        df.setGroupingUsed(false);
        return df;
    }

    public CalcHelper(Patient patient) {
        this.patient = patient;
    }

    String getIMCString() {
        String s;
        try {
            s = doubleFormat.format(patient.getIMC());
        } catch (DataNotFoundException dataNotFoundException) {
            s = "--";
        }
        return s;
    }

    String getCentileStringForType(Tipo tipo) {
        String s;
        if (patient.isTableAvailable(tipo)) {
            try {
                double observedValue = patient.getValueFor(tipo);
                double forInputValue = patient.getInputValueFor(tipo);
                double zScore = patient.getTabla(tipo).getZScore(observedValue, forInputValue);
                double centile = patient.getTabla(tipo).getCentile(zScore);
                s = percentFormat.format(centile);
            } catch (InvalidUnitException invalidUnitException) {
                s = "--";
            } catch (DataNotFoundException dataNotFoundException) {
                s = "--";
            }
        } else {
            s = "--";
        }
        return s;
    }

    String getStatusStringForType(Tipo tipo) {
        return "SIN DETERMINAR";
    }

    String getZScoreStringForType(Tipo tipo) {
        String s;
        if (patient.isTableAvailable(tipo)) {
            try {
                double observedValue = patient.getValueFor(tipo);
                double forInputValue = patient.getInputValueFor(tipo);
                double zScore = patient.getTabla(tipo).getZScore(observedValue, forInputValue);
                s = doubleFormat.format(zScore);
            } catch (InvalidUnitException invalidUnitException) {
                s = "--";
            } catch (DataNotFoundException dataNotFoundException) {
                s = "--";
            }
        } else {
            s = "--";
        }
        return s;
    }
}
