/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

import jpercentilos.res.Dimensionizable.InvalidUnitException;
import jpercentilos.res.Magnitude.*;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class PatientProfile {

    protected final Sexo sexo;
    protected final Age age; // Edad
    protected final Height height;  // Altura
    protected final HeadPerimeter headPerimeter; // Perímetro
    protected final Weight weight; // Peso

    /**
     * Constructs a <code>PatientProfile<code> object with all parameters set.
     * @param sexo
     * @param age
     * @param height
     * @param headPerimeter
     * @param weight
     */
    public PatientProfile(Sexo sexo, Age age, Height height, HeadPerimeter headPerimeter, Weight weight) {
        this.sexo = sexo;
        this.age = age;
        this.height = height;
        this.headPerimeter = headPerimeter;
        this.weight = weight;
    }

    public PatientProfile(Sexo sexo, Age age, Height height, Weight weight) {
        this(sexo, age, height, (HeadPerimeter) HeadPerimeter.NA, weight);
    }

    public PatientProfile(Height height, Weight weight) {
        this(Sexo.NA, Age.NA, height, weight);
    }

    public PatientProfile(Sexo sexo, Age age, Height height) {
        this(sexo, age, height, Weight.NA);
    }

    public PatientProfile(Sexo sexo, Age age, Weight weight) {
        this(sexo, age, (Height) Height.NA, weight);
    }

    public PatientProfile(Sexo sexo, Age age, HeadPerimeter headPerimeter) {
        this(sexo, age, (Height) Height.NA, headPerimeter, Weight.NA);
    }

    public final Age getAge() {
        return age;
    }

    public final HeadPerimeter getHeadPerimeter() {
        return headPerimeter;
    }

    public final Height getHeight() {
        return height;
    }

    public final Sexo getSex() {
        return sexo;
    }

    public final Weight getWeight() {
        return weight;
    }

    public final TextFileReaderME.File getTableFile(TablaPercentilos.Tipo tipo) {
        StringBuffer sb = new StringBuffer("tables/");
        sb.append(tipo.toString()).append("-");
        sb.append(getAgeRange()).append("-");
        sb.append(sexo.toString());
        return new TextFileReaderME.File(sb.toString());
    }

    public final String getAgeRange() {
        String range;
        double year;
        try {
            year = age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO);
        } catch (InvalidUnitException ex) {
            year = 0;
        }
        if (year < 2 && year >= 0) {
            range = "0to2";
        } else if (year >=2 && year < 5) {
            range = "2to5";
        } else {
            range = "2to19";
        }
        return range;
    }

    public static final class Sexo {

        private final String name;
        public static final Sexo VARÓN = new Sexo("VARÓN");
        public static final Sexo MUJER = new Sexo("MUJER");
        public static final Sexo NA = new Sexo("ND");

        public Sexo(String name) {
            this.name = name;
        }

        public final String bitPath() {
            return this.toString();
        }

        public final String toString() {
            return name;
        }
    }

    public static final class DataNotFoundException extends Exception {

        public DataNotFoundException(String message) {
            super(message);
        }
    }
}
