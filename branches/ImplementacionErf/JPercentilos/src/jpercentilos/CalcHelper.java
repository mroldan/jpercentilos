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
 * Objeto que contiene métodos para obtener cadenas a partir de datos obtenidos
 * del paciente y mostrarlos en el IGU
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

    /**
     * Crea un objeto <code>CalcHelper<code> para el paciente especificado.
     * @param patient
     */
    public CalcHelper(Patient patient) {
        this.patient = patient;
    }

    /**
     * Obtiene la cadena a mostrar en el campo de IMC.
     * @return
     */
    String getIMCString() {
        String s;
        try {
            s = doubleFormat.format(patient.getIMC());
        } catch (DataNotFoundException dataNotFoundException) {
            s = "--";
        }
        return s;
    }

    /**
     * Obtiene la cadena a mostrar en el campo de percentilo para un tipo dado.
     * @param tipo
     * @return
     */
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

    /**
     * Obtiene la cadena a mostrar en la etiqueta de estado para cada tipo.
     * @param tipo
     * @return
     */
    String getStatusStringForType(Tipo tipo) {
        final String NA = "SIN DETERMINAR";
        String s;
        if (patient.isTableAvailable(tipo)) {
            try {
                double observedValue = patient.getValueFor(tipo);
                double forInputValue = patient.getInputValueFor(tipo);
                double zScore = patient.getTabla(tipo).getZScore(observedValue, forInputValue);
                s = patient.getStatusForZScore(zScore).name();
            } catch (InvalidUnitException invalidUnitException) {
                s = NA;
            } catch (DataNotFoundException dataNotFoundException) {
                s = NA;
            }
        } else {
            s = NA;
        }
        return s;
    }

    /**
     * Obtiene la cadena a mostrar en el campo de zScore para un tipo dado.
     * @param tipo
     * @return
     */
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
