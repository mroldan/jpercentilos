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

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class Paciente {

    private final Sexo sexo;
    private int age = -1; // Edad en días (hasta 5 años)
    private double height = -1;  // Altura en cm
    private double headPerimeter = -1; // Perímetro cefálico en cm
    private double weight = -1; // Peso en kilogramos

    public Paciente(Sexo sexo, int age, double height, double HP, double weight) {
        this.sexo = sexo;
        this.age = age;
        this.height = height;
        this.headPerimeter = HP;
        this.weight = weight;
    }

    private double[] getPerHeight() throws DataNotFoundException {
        return getHeightToAgeCentileAndPz(sexo, age, height);
    }

    private double[] getPerIMC() throws DataNotFoundException {
        return getIMCToAgeCentileAndPz(sexo, age, getIMC(height / 100, weight));
    }

    private double[] getPerHp() throws DataNotFoundException {
        return getHpToAgeCentileAndPz(sexo, age, headPerimeter);
    }

    private double[] getPerWeight() throws DataNotFoundException {
        return getWeightToAgeCentileAndPz(sexo, age, weight);
    }

    public final double getWeightCentile() throws DataNotFoundException {
        return getPerWeight()[0];
    }

    public final double getPCCentile() throws DataNotFoundException {
        return getPerHp()[0];
    }

    public final double getIMCCentile() throws DataNotFoundException {
        return getPerIMC()[0];
    }

    public final double getHeightCentile() throws DataNotFoundException {
        return getPerHeight()[0];
    }

    public final double getWeightPz() throws DataNotFoundException {
        return getPerWeight()[1];
    }

    public final double getPCPz() throws DataNotFoundException {
        return getPerHp()[1];
    }

    public final double getIMCPz() throws DataNotFoundException {
        return getPerIMC()[1];
    }

    public final double getHeightPz() throws DataNotFoundException {
        return getPerHeight()[1];
    }

    public final int getAge() {
        return age;
    }

    public final double getHeadPerimeter() {
        return headPerimeter;
    }

    public final double getHeight() {
        return height;
    }

    public final Sexo getSexo() {
        return sexo;
    }

    public final double getWeight() {
        return weight;
    }

    /**
     * Calcula el percentilo y el puntaje-z de Peso para la Edad con los
     * parámetros dados.
     * @param sexo
     * @param age
     * @param height
     * @return
     */
    public static double[] getWeightToAgeCentileAndPz(Sexo sexo, int age, double weight)
            throws DataNotFoundException {
        if (age != -1 && weight != -1) {
            try {
                return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.PESO)).getCentile(age, weight);
            } catch (Exception e) {
                throw new DataNotFoundException("Error en tabla de percentilos");
            }
        } else {
            throw new DataNotFoundException("Faltan datos para cálculo de Percentilo y Pz");
        }
    }

    /**
     * Calcula el percentilo de Perímetro Cefálico para la Edad con los parámetros dados.
     * @param sexo
     * @param age
     * @param pc
     * @return
     */
    public static double[] getHpToAgeCentileAndPz(Sexo sexo, int age, double pc)
            throws DataNotFoundException {
        if (age != -1 && pc != -1) {
            try {
                return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.PC)).getCentile(age, pc);
            } catch (Exception e) {
                throw new DataNotFoundException("Error en Tabla");
            }
        } else {
            throw new DataNotFoundException("Faltan datos para el cálculo de Percentilo y Pz");
        }
    }

    /**
     * Calcula el percentilo de Talla para la Edad con los parámetros dados.
     * @param sexo
     * @param age
     * @param height
     * @return
     */
    public static double[] getHeightToAgeCentileAndPz(Sexo sexo, int age, double height)
            throws DataNotFoundException {
        if (age != -1 && height != -1) {
            try {
                return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.TALLA)).getCentile(age, height);
            } catch (Exception e) {
                throw new DataNotFoundException("Error en Tabla");
            }
        } else {
            throw new DataNotFoundException("Faltan datos para cálculo de Percentilo y Pz");
        }
    }

    /**
     * Calcula el percentilo de Índice de masa corporal con los parámetros 
     * dados.
     * @param sexo
     * @param age
     * @param imc
     * @return
     */
    public static double[] getIMCToAgeCentileAndPz(Sexo sexo, int age, double imc)
            throws DataNotFoundException {
        if (age != -1) {
            try {
                return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.IMC)).getCentile(age, imc);
            } catch (Exception e) {
                throw new DataNotFoundException("Error en Tabla");
            }
        } else {
            throw new DataNotFoundException("Faltan datos para cálculo de Percentilo y Pz");
        }
    }

    /**
     * Calcula el Índice de masa corporal dados el peso en Kilogramos y la
     * altura en metros
     * @param heightM
     * @param weightKG
     * @return
     */
    public static double getIMC(double heightM, double weightKG)
            throws DataNotFoundException {
        if (heightM != -1 && weightKG != -1) {
            try {
                return weightKG / (heightM * heightM);
            } catch (Exception e) {
                throw new DataNotFoundException("Error en Cálculo de IMC");
            }
        } else {
            throw new DataNotFoundException("Faltan datos para el cálculo de IMC");
        }
    }

    public static final class Sexo {

        private final String name;
        public static final Sexo VARÓN = new Sexo("Varón");
        public static final Sexo MUJER = new Sexo("Mujer");

        public Sexo(String name) {
            this.name = name;
        }

        public final String bitPath() {
            return this.toString().substring(0, 2).toLowerCase();
        }

        public final String toString() {
            return this.name;
        }
    }

//    public enum Estado {
//        NORMAL,
//        EXCEDIDO,
//        POR_DEBAJO;
//
//    }
    public static final class DataNotFoundException extends Exception {

        public DataNotFoundException(String message) {
            super(message);
        }
    }
}
