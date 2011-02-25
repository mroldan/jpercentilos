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

import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
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
//
//    private double[] getPerHeight() throws DataNotFoundException {
//        return getHeightToAgeCentileAndPz(sexo, age, height);
//    }
//
//    private double[] getPerIMC() throws DataNotFoundException {
//        return getIMCToAgeCentileAndPz(sexo, age, getIMC(height / 100, weight));
//    }
//
//    private double[] getPerHp() throws DataNotFoundException {
//        return getHpToAgeCentileAndPz(sexo, age, headPerimeter);
//    }
//
//    private double[] getPerWeight() throws DataNotFoundException {
//        return getWeightToAgeCentileAndPz(sexo, age, weight);
//    }
//
//    public final double getWeightCentile() throws DataNotFoundException {
//        return getPerWeight()[0];
//    }
//
//    public final double getPCCentile() throws DataNotFoundException {
//        return getPerHp()[0];
//    }
//
//    public final double getIMCCentile() throws DataNotFoundException {
//        return getPerIMC()[0];
//    }
//
//    public final double getHeightCentile() throws DataNotFoundException {
//        return getPerHeight()[0];
//    }
//
//    public final double getWeightPz() throws DataNotFoundException {
//        return getPerWeight()[1];
//    }
//
//    public final double getPCPz() throws DataNotFoundException {
//        return getPerHp()[1];
//    }
//
//    public final double getIMCPz() throws DataNotFoundException {
//        return getPerIMC()[1];
//    }
//
//    public final double getHeightPz() throws DataNotFoundException {
//        return getPerHeight()[1];
//    }

    /**
     * Calcula el percentilo y el puntaje-z de Peso para la Edad con los
     * parámetros dados.
     * @param sexo
     * @param age
     * @param height
     * @return
     */
//    public static double[] getWeightToAgeCentileAndPz(Sexo sexo, int age, double weight)
//            throws DataNotFoundException {
////        if (age != -1 && weight != -1) {
////            try {
////                return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.PESO)).getCentile(age, weight);
////            } catch (Exception e) {
////                throw new DataNotFoundException("Error en tabla de percentilos");
////            }
////        } else {
////            throw new DataNotFoundException("Faltan datos para cálculo de Percentilo y Pz");
////        }
//    }
    /**
     * Calcula el percentilo de Perímetro Cefálico para la Edad con los parámetros dados.
     * @param sexo
     * @param age
     * @param pc
     * @return
     */
//    public static double[] getHpToAgeCentileAndPz(Sexo sexo, int age, double pc)
//            throws DataNotFoundException {
////        if (age != -1 && pc != -1) {
////            try {
////                return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.PC)).getCentile(age, pc);
////            } catch (Exception e) {
////                throw new DataNotFoundException("Error en Tabla");
////            }
////        } else {
////            throw new DataNotFoundException("Faltan datos para el cálculo de Percentilo y Pz");
////        }
//    }
    /**
     * Calcula el percentilo de Talla para la Edad con los parámetros dados.
     * @param sexo
     * @param age
     * @param height
     * @return
     */
//    public static double[] getHeightToAgeCentileAndPz(Sexo sexo, int age, double height)
//            throws DataNotFoundException {
////        if (age != -1 && height != -1) {
////            try {
////                return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.TALLA)).getCentile(age, height);
////            } catch (Exception e) {
////                throw new DataNotFoundException("Error en Tabla");
////            }
////        } else {
////            throw new DataNotFoundException("Faltan datos para cálculo de Percentilo y Pz");
////        }
//    }
    /**
     * Calcula el percentilo de Índice de masa corporal con los parámetros 
     * dados.
     * @param sexo
     * @param age
     * @param imc
     * @return
     */
//    public static double[] getIMCToAgeCentileAndPz(Sexo sexo, int age, double imc)
//            throws DataNotFoundException {
//        if (age != -1) {
//            try {
//                return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.IMC)).getCentile(age, imc);
//            } catch (Exception e) {
//                throw new DataNotFoundException("Error en Tabla");
//            }
//        } else {
//            throw new DataNotFoundException("Faltan datos para cálculo de Percentilo y Pz");
//        }
//    }
    /**
     * Calcula el Índice de masa corporal dados el peso en Kilogramos y la
     * altura en metros
     * @param heightM
     * @param weightKG
     * @return
     */
//    public static double getIMC(double heightM, double weightKG)
//            throws DataNotFoundException {
//        if (heightM != -1 && weightKG != -1) {
//            try {
//                return weightKG / (heightM * heightM);
//            } catch (Exception e) {
//                throw new DataNotFoundException("Error en Cálculo de IMC");
//            }
//        } else {
//            throw new DataNotFoundException("Faltan datos para el cálculo de IMC");
//        }
//    }
    private void readTables() {
        if (!age.equals(Age.NA)) {
            File file;
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
            File file = getTableFile(Tipo.PESO_A_TALLA);
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

    public Vector getTablas() {
        return tablas;
    }

    public TablaPercentilos getTabla(TablaPercentilos.Tipo tipo) {
        File file = this.getTableFile(tipo);
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
