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

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class Paciente {

    private final Sexo sexo;
    private int age; // Edad en días (hasta 5 años)
    private double height;
    private double headPerimeter;
    private double weight;
    private double perHeight;
    private double perWeight;
    private double perIMC;
    private double perHp;

    public Paciente(Sexo sexo, int age, double height, double perCef, double weight) {
        this.sexo = sexo;
        this.age = age;
        this.height = height;
        this.headPerimeter = perCef;
        this.weight = weight;
        getCentiles();
    }


    public double getPerHeight() {
        return perHeight;
    }

    public double getPerIMC() {
        return perIMC;
    }

    public double getPerRC() {
        return perHp;
    }

    public double getPerWeight() {
        return perWeight;
    }

    /**
     * Lee los percentilos de las tablas correspondientes. Debe ser llamado
     * desde el constructor luego de establecer parámetros de edad peso, altura
     * y perímetro cefálico.
     */
    private void getCentiles() {
        this.perHeight = getHeightToAgeCentile(sexo, age, height);
        this.perWeight = getWeightToAgeCentile(sexo, age, weight);
        this.perHp = getHpToAgeCentile(sexo, age, headPerimeter);
//        this.perIMC;
    }

    /**
     * Calcula el percentilo de Peso para la Edad con los parámetros dados.
     * @param sexo
     * @param age
     * @param height
     * @return
     */
    public static double getWeightToAgeCentile(Sexo sexo, int age, double weight) {
        return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.PESO)).getCentile(age, weight);
    }

    /**
     * Calcula el percentilo de Perímetro Cefálico para la Edad con los parámetros dados.
     * @param sexo
     * @param age
     * @param pc
     * @return
     */
    public static double getHpToAgeCentile(Sexo sexo, int age, double pc) {
        return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.PC)).getCentile(age, pc);
    }

    /**
     * Calcula el percentilo de Talla para la Edad con los parámetros dados.
     * @param sexo
     * @param age
     * @param height
     * @return
     */
    public static double getHeightToAgeCentile(Sexo sexo, int age, double height) {
        return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.TALLA)).getCentile(age, height);
    }

    /**
     * Calcula el percentilo de Índice de masa corporal con los parámetros 
     * dados.
     * @param sexo
     * @param age
     * @param imc
     * @return
     */
    public static double getIMCToAgeCentile(Sexo sexo, int age, double imc) {
        return (new TablaPercentilos(sexo, TablaPercentilos.Tipo.IMC)).getCentile(age, imc);
    }

    /**
     * Calcula el Índice de masa corporal dados el peso en Kilogramos y la
     * altura en metros
     * @param heightM
     * @param weightKG
     * @return
     */
    public static double getIMC(double heightM, double weightKG) {
        return weightKG / (heightM * heightM);
    }

    public enum Sexo {

        VARÓN,
        MUJER;

        public String bitPath() {
            return this.toString().substring(0, 2).toLowerCase();
        }

        @Override
        public String toString() {
            String s = this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
            return s;
        }

    }

}