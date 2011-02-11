/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

import java.util.Vector;
import jpercentilos.res.Dimensionizable.InvalidUnitException;
import jpercentilos.res.Length.HeadPerimeter;
import jpercentilos.res.Length.Height;
import jpercentilos.res.Magnitude.*;

/**
 * Class containing Patient info and methods to handle data retrieving.
 * 
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class PatientProfile {

    protected final Sexo sexo;
    protected final Age age; // Edad
    protected final Height height;  // Altura
    protected final HeadPerimeter headPerimeter; // Perímetro
    protected final Weight weight; // Peso
    protected Vector availableTable = new Vector(2);

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
        lookForAvailableTables();
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

    public final double getIMC() {
        double w = 0;
        double h = 0;
        try {
            w = getWeight().getValueInUnit(Dimensionizable.WeightUnit.KG);
            h = getHeight().getValueInUnit(Dimensionizable.LengthUnit.M);
        } catch (InvalidUnitException invalidUnitException) {
            return 0; // Should not happend
        }
        return w / MathME.pow(h, 2);
    }

    public final TextFileReaderME.File getTableFile(TablaPercentilos.Tipo tipo) {
        StringBuffer sb = new StringBuffer("tables/");
        sb.append(tipo.toString()).append("-");
        sb.append(getAgeRange(tipo)).append("-");
        sb.append(sexo.toString());
        return new TextFileReaderME.File(sb.toString());
    }

    public final String getAgeRange(TablaPercentilos.Tipo tipo) { //TODO Establecer rangos segun tipo de tabla.
        if (tipo == TablaPercentilos.Tipo.TALLA_A_EDAD) {
            return getAgeRangeHeightToAge();
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_EDAD) {
            return getAgeRangeWeightToAge();
        } else if (tipo == TablaPercentilos.Tipo.IMC_A_EDAD) {
            return getAgeRangeBMIToAge();
        } else if (tipo == TablaPercentilos.Tipo.PC_A_EDAD) {
            return getAgeRangeHPToAge();
        } else {
            return null;
        }
    }

    private String getAgeRangeHeightToAge() {
        String range;
        double year;
        try {
            year = age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO);
        } catch (InvalidUnitException ex) {
            year = -1;
        }
        if (year < 2 && year >= 0) {
            range = "0a2";
        } else if (year >=2 && year < 5) {
            range = "0a5";
        } else {
            range = "5a19";
        }
        return range;
    }

    private String getAgeRangeWeightToAge() {
        String range;
        double year;
        try {
            year = age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO);
        } catch (InvalidUnitException ex) {
            year = -1;
        }
        if (year < 5 && year >= 0) {
            range = "0a5";
        } else {
            range = "5a10";
        }
        return range;
    }

    private String getAgeRangeBMIToAge() {
        String range;
        double year;
        try {
            year = age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO);
        } catch (InvalidUnitException ex) {
            year = -1;
        }
        if (year < 2 && year >= 0) {
            range = "0a2";
        } else if (year >=2 && year < 5) {
            range = "0a5";
        } else {
            range = "5a19";
        }
        return range;
    }

    private String getAgeRangeHPToAge() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void lookForAvailableTables() {
        try {
            if (!age.equals(Age.NA) && age.getValueInUnit(Dimensionizable.AgeUnit.AÑO) <= 19) {
                availableTable.addElement(TablaPercentilos.Tipo.IMC_A_EDAD);
                availableTable.addElement(TablaPercentilos.Tipo.TALLA_A_EDAD);
                try {
                    if (age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO) <= 10) {
                        availableTable.addElement(TablaPercentilos.Tipo.PESO_A_EDAD);
                    }
                } catch (InvalidUnitException ex) {
                    ex.printStackTrace();
                }
                try {
                    if (age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO) <= 5) {
                        availableTable.addElement(TablaPercentilos.Tipo.PC_A_EDAD);
                        availableTable.addElement(TablaPercentilos.Tipo.PESO_A_TALLA);
                    }
                } catch (InvalidUnitException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (InvalidUnitException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isTableAvailable(TablaPercentilos.Tipo tipo) {
        return availableTable.contains(tipo);
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
