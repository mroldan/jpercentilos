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
import java.util.EnumSet;
import java.util.Vector;
import jpercentilos.res.Dimensionizable.InvalidUnitException;
import jpercentilos.res.Length.HeadPerimeter;
import jpercentilos.res.Length.Height;
import jpercentilos.res.PatientProfile.Sexo;
import jpercentilos.res.TablaPercentilos.Tipo;
import jpercentilos.res.TextScanner.ResourceFile;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class Patient extends PatientProfile {

    private Vector tablas = new Vector(2);

    /**
     * Crea un objeto <code>Patient<code> con los parámetros de <code>sexo<code>,
     * <code>age<code>, <code>height<code>, <code>headPerimeter<code> y
     * <code>weight<code>, que representan el sexo, edad, perímetro cefálico y
     * peso del paciente.
     * @param sexo
     * @param age
     * @param height
     * @param headPerimeter
     * @param weight
     */
    public Patient(Sexo sexo, Age age, Height height, HeadPerimeter headPerimeter, Weight weight) {
        super(sexo, age, height, headPerimeter, weight);
        readTables();
    }

    /**
     * Lee las tablas que corresponden a éste apciente.
     */
    private void readTables() {
        if (!age.equals(Age.NA)) {
            ResourceFile file;
            for (Tipo tipo:EnumSet.complementOf(EnumSet.of(Tipo.PESO_A_TALLA))) {
                if (isTableAvailable(tipo)) {
                    file = this.getTableFile(tipo);
                    try {
                        System.out.println("Reading file: " + file.getPath());
                        tablas.addElement(new TablaPercentilos(file));
                        System.out.println(file.getPath() + " successfuly read.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }
        }
        if (!height.equals(Height.NA)) {
            ResourceFile file = getTableFile(Tipo.PESO_A_TALLA);
            if (isTableAvailable(Tipo.PESO_A_TALLA)) {
                    try {
                        System.out.println("Reading file: " + file.getPath());
                        tablas.addElement(new TablaPercentilos(file));
                        System.out.println(file.getPath() + " successfuly read.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }

    }

    /**
     * Devuelve el vector que contiene todas las tablas correspondientes a éste
     * paciente
     * @return
     */
    public Vector getTablas() {
        return tablas;
    }

    /**
     * Devuelve la tabla de percentilos especifiada en <code>tipo<code>.
     * @param tipo
     * @return
     */
    public TablaPercentilos getTabla(Tipo tipo) {
        ResourceFile file = this.getTableFile(tipo);
        for (int i = 0; i < tablas.size(); i++) {
            TablaPercentilos tablaPercentilos = (TablaPercentilos) tablas.elementAt(i);
            if (tablaPercentilos.getName().equals(this.getTableFile(tipo).getPath())) {
                return tablaPercentilos;
            }
        }
        return null;
    }

    /**
     * Devuelve el valor observado (en unidades correctas) para entrar en la
     * tabla especificada por <code>tipo<code>.
     * @param tipo
     * @return
     * @throws jpercentilos.res.Dimensionizable.InvalidUnitException
     * @throws jpercentilos.res.PatientProfile.DataNotFoundException
     */
    public double getValueFor(Tipo tipo) throws InvalidUnitException, DataNotFoundException {
        if (tipo == TablaPercentilos.Tipo.TALLA_A_EDAD) {
            return getHeight().getValueInUnit(Dimensionizable.LengthUnit.CM);
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_EDAD) {
            return getWeight().getValueInUnit(Dimensionizable.WeightUnit.KG);
        } else if (tipo == TablaPercentilos.Tipo.PC_A_EDAD) {
            return getHeadPerimeter().getValueInUnit(Dimensionizable.LengthUnit.CM); 
        } else if (tipo == TablaPercentilos.Tipo.IMC_A_EDAD) {
            return getIMC();
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_TALLA) {
            return getWeight().getValueInUnit(Dimensionizable.WeightUnit.KG);
        } else {
            return 0; // Should not happend
        }
    }

    /**
     * Obtiene el valor con el que se debe entrar a la tabla de percentilos
     * especificada por <code>tipo<code>. El valor se devuelve en la unidad
     * correcta.
     * @param tipo
     * @return
     * @throws jpercentilos.res.PatientProfile.DataNotFoundException
     * @throws jpercentilos.res.Dimensionizable.InvalidUnitException
     */
    public double getInputValueFor(Tipo tipo) throws DataNotFoundException, InvalidUnitException {
        if (tipo != TablaPercentilos.Tipo.PESO_A_TALLA) {
            return getAge().getValueInUnit(Dimensionizable.AgeUnit.MES);
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_TALLA) {
            return getHeight().getValueInUnit(Dimensionizable.LengthUnit.CM);
        } else {
            return 0; // Should not happend
        }
    }

    /**
     * Obtiene el estado para un valor dado de z-score.
     * @param z
     * @return Status
     */
    public Status getStatusForZScore(double z) {
        if (z < -3) {
            return Status.DEFICIT;
        } else  if (z < -2){
            return Status.LOW;
        } else if (z <= 2) {
            return Status.NORMAL;
        } else if (z < 3) {
            return Status.HIGH;
        } else {
            return Status.EXCEDED;
        }
    }

    /**
     * Enumeración de estados posibles para un parámetro dado.
     */
    public enum Status { 

        DEFICIT,
        LOW,
        NORMAL,
        HIGH,
        EXCEDED;
    }
}
