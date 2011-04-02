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
package jpercentilos.res;

import java.io.IOException;
import java.util.Vector;
import jpercentilos.res.Dimensionizable.InvalidUnitException;
import jpercentilos.res.Length.HeadPerimeter;
import jpercentilos.res.Length.Height;
import jpercentilos.res.PatientProfile.Sexo;
import jpercentilos.res.TablaPercentilos.Tipo;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class Patient extends PatientProfile {

    private Vector tablas = new Vector(2);

    public Patient(Sexo sexo, Age age, Height height, HeadPerimeter headPerimeter, Weight weight) {
        super(sexo, age, height, headPerimeter, weight);
        readTables();
    }

    private void readTables() {
        if (!age.equals(Age.NA)) {
            TextFileReaderME.ResourceFile file;
            TablaPercentilos.Tipo[] tipo = TablaPercentilos.Tipo.values();
            for (int i = 0; i < tipo.length; i++) {
                if (isTableAvailable(tipo[i])) {
                    file = this.getTableFile(tipo[i]);
                    try {
                        System.out.println("Reading file: " + file.getPath());
                        tablas.addElement(new TablaPercentilos(file));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(file.getPath() + " successfuly read.");
                }
            }
        }
    }

    public Vector getTablas() {
        return tablas;
    }

    public TablaPercentilos getTabla(TablaPercentilos.Tipo tipo) {
        TextFileReaderME.ResourceFile file = this.getTableFile(tipo);
        for (int i = 0; i < tablas.size(); i++) {
            TablaPercentilos tablaPercentilos = (TablaPercentilos) tablas.elementAt(i);
            if (tablaPercentilos.getName().equals(this.getTableFile(tipo).getPath())) {
                return tablaPercentilos;
            }
        }
        return null;
    }

    public double getValueFor(Tipo tipo) throws InvalidUnitException, DataNotFoundException {
        if (tipo == TablaPercentilos.Tipo.TALLA_A_EDAD) {
            return getHeight().getValueInUnit(Dimensionizable.LengthUnit.CM);
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_EDAD) {
            return getWeight().getValueInUnit(Dimensionizable.WeightUnit.KG);
        } else if (tipo == TablaPercentilos.Tipo.PC_A_EDAD) {
            return getHeadPerimeter().getValueInUnit(Dimensionizable.LengthUnit.CM); //TODO Chequear unidad
        } else if (tipo == TablaPercentilos.Tipo.IMC_A_EDAD) {
            return getIMC();
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_TALLA) {
            return getWeight().getValueInUnit(Dimensionizable.WeightUnit.KG);
        } else {
            return 0; // Should not happend
        }
    }

    public double getInputValueFor(Tipo tipo) throws DataNotFoundException, InvalidUnitException {
        if (tipo != TablaPercentilos.Tipo.PESO_A_TALLA) {
            return getAge().getValueInUnit(Dimensionizable.AgeUnit.MES);
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_TALLA) {
            return getHeight().getValueInUnit(Dimensionizable.LengthUnit.CM);
        } else {
        return 0; // Should not happend
    }
}

}
