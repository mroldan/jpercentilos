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
 * Objeto que contiene datos de paciente y métodos para manejarlos. Es un objeto
 * inmutable para ser seguro y confiable, es decir, los datos no inicializados
 * en el constructor no pueden ser agregados luego y tampoco se pueden modificar
 * datos inicializados.
 * 
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class PatientProfile {

    protected final Sexo sexo;
    protected final Age age; // Edad
    protected final Height height;  // Altura
    protected final HeadPerimeter headPerimeter; // Perímetro cefálico
    protected final Weight weight; // Peso
    protected Vector availableTable = new Vector(2);

    /**
     * Crea un objeto <code>PatientProfile<code> con todos los datos.
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

    /**
     * Crea un objeto <code>PatientProfile<code> con los datos especificados. El
     * resto se inicializa a <code>NA<code> y su búsqueda lanza una exepción.
     * @param sexo
     * @param age
     * @param height
     * @param weight
     */
    public PatientProfile(Sexo sexo, Age age, Height height, Weight weight) {
        this(sexo, age, height, (HeadPerimeter) HeadPerimeter.NA, weight);
    }

    /**
     * Crea un objeto <code>PatientProfile<code> con los datos especificados. El
     * resto se inicializa a <code>NA<code> y su búsqueda lanza una exepción.
     * @param height
     * @param weight
     */
    public PatientProfile(Height height, Weight weight) {
        this(Sexo.NA, Age.NA, height, weight);
    }

    /**
     * Crea un objeto <code>PatientProfile<code> con los datos especificados. El
     * resto se inicializa a <code>NA<code> y su búsqueda lanza una exepción.
     * @param sexo
     * @param age
     * @param height
     */
    public PatientProfile(Sexo sexo, Age age, Height height) {
        this(sexo, age, height, Weight.NA);
    }

    /**
     * Crea un objeto <code>PatientProfile<code> con los datos especificados. El
     * resto se inicializa a <code>NA<code> y su búsqueda lanza una exepción.
     * @param sexo
     * @param age
     * @param weight
     */
    public PatientProfile(Sexo sexo, Age age, Weight weight) {
        this(sexo, age, (Height) Height.NA, weight);
    }

    /**
     * Crea un objeto <code>PatientProfile<code> con los datos especificados. El
     * resto se inicializa a <code>NA<code> y su búsqueda lanza una exepción.
     * @param sexo
     * @param age
     * @param headPerimeter
     */
    public PatientProfile(Sexo sexo, Age age, HeadPerimeter headPerimeter) {
        this(sexo, age, (Height) Height.NA, headPerimeter, Weight.NA);
    }

    /**
     * Devuelve el objeto <code>Age<code> representando la edad del paciente.
     * @return
     * @throws jpercentilos.res.PatientProfile.DataNotFoundException
     */
    public final Age getAge() throws DataNotFoundException {
        if (age.equals(Age.NA)) {
            throw new DataNotFoundException("Edad no especificada");
        } else {
            return age;
        }
    }

    /**
     * Devuelve el objeto <code>HeadPerimeter<code> representando el perímetro
     * cefálico de éste paciente. Si el dato no está presente (<code>NA<code>)
     * lanza una exepción.
     * @return
     * @throws jpercentilos.res.PatientProfile.DataNotFoundException
     */
    public final HeadPerimeter getHeadPerimeter() throws DataNotFoundException {
        if (headPerimeter.equals(HeadPerimeter.NA)) {
            throw new DataNotFoundException("PC no especificado");
        } else {
            return headPerimeter;
        }
    }

    /**
     * Devuelve el objeto <code>Height<code> representando la talla de éste
     * paciente. Si el dato no está presente se lanza una exepción.
     * @return
     * @throws jpercentilos.res.PatientProfile.DataNotFoundException
     */
    public final Height getHeight() throws DataNotFoundException {
        if (height.equals(Height.NA)) {
            throw new DataNotFoundException("Talla no especificada");
        } else {
            return height;
        }
    }

    /**
     * Devuelve el objeto <code>Sexo<code> representando el sexo de éste
     * paciente. Si el dato no está presente se lanza una exepción.
     * @return
     * @throws jpercentilos.res.PatientProfile.DataNotFoundException
     */
    public final Sexo getSex() throws DataNotFoundException {
        if (sexo.equals(Sexo.NA)) {
            throw new DataNotFoundException("Sexo no especificado");
        } else {
            return sexo;
        }
    }

    /**
     * Devuelve el objeto <code>Weight<code> representando el peso de éste
     * paciente. Si el dato no está presente se lanza una exepción.
     * @return
     * @throws jpercentilos.res.PatientProfile.DataNotFoundException
     */
    public final Weight getWeight() throws DataNotFoundException {
        if (weight.equals(Weight.NA)) {
            throw new DataNotFoundException("Peso no especificado");
        } else {
            return weight;
        }
    }

    /**
     * Devuelve el Índice de Masa Corporal de éste paciente. Si el dato no se
     * puede calcular por faltar el peso o la talla se lanza una exepción.
     * @return
     * @throws jpercentilos.res.PatientProfile.DataNotFoundException
     */
    public final double getIMC() throws DataNotFoundException {
        double w = 0;
        double h = 0;
        try {
            w = getWeight().getValueInUnit(Dimensionizable.WeightUnit.KG);
            h = getHeight().getValueInUnit(Dimensionizable.LengthUnit.M);
        } catch (InvalidUnitException invalidUnitException) {
            throw new DataNotFoundException("Error de unidades"); // Should not happend
        } catch (DataNotFoundException dataNotFoundException) {
            throw new DataNotFoundException("No se puede calcular IMC con los datos actuales");
        }
        double IMC = w / (h * h);
        return IMC;
    }

    /**
     * Devuelve un objeto <code>ResourceFile<code> con la ruta del archivo de
     * recurso que contiene la tabla del <code>tipo<code> especificado.
     * @param tipo
     * @return
     */
    protected final TextScanner.ResourceFile getTableFile(TablaPercentilos.Tipo tipo) {
        StringBuilder sb = new StringBuilder("tables/");
        sb.append(tipo.toString()).append("-");
        sb.append(getAgeRange(tipo)).append("-");
        sb.append(sexo.toString());
        return new TextScanner.ResourceFile(sb.toString());
    }

    /**
     * Devuelve la cadena correspondiente al rango de edades para el <code>tipo<code>
     * especificado
     * @param tipo
     * @return
     */
    protected final String getAgeRange(TablaPercentilos.Tipo tipo) {
        if (tipo == TablaPercentilos.Tipo.TALLA_A_EDAD) {
            return getAgeRangeHeightToAge();
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_EDAD) {
            return getAgeRangeWeightToAge();
        } else if (tipo == TablaPercentilos.Tipo.IMC_A_EDAD) {
            return getAgeRangeBMIToAge();
        } else if (tipo == TablaPercentilos.Tipo.PC_A_EDAD) {
            return getAgeRangeHPToAge();
        } else if (tipo == TablaPercentilos.Tipo.PESO_A_TALLA) {
            return getAgeRangeWeightToHeight();
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
        } else if (year >= 2 && year < 5) {
            range = "2a5";
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
        } else if (year >= 2 && year < 5) {
            range = "2a5";
        } else {
            range = "5a19";
        }
        return range;
    }

    private String getAgeRangeHPToAge() {
        String range;
        range = "0a5";
        return range;
    }

    private String getAgeRangeWeightToHeight() {
        String range;
        range = "0a2";
        return range;
    }

    /**
     * Busca las tablas que se pueden utilizar para éste paciente con los datos
     * ingresados
     */
    private void lookForAvailableTables() {
        try {
            if (!age.equals(Age.NA) && age.getValueInUnit(Dimensionizable.AgeUnit.AÑO) <= 19) {
                availableTable.addElement(TablaPercentilos.Tipo.IMC_A_EDAD);
                availableTable.addElement(TablaPercentilos.Tipo.TALLA_A_EDAD);
                if (age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO) <= 10) {
                    availableTable.addElement(TablaPercentilos.Tipo.PESO_A_EDAD);
                }
                if (age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO) <= 5) {
                    availableTable.addElement(TablaPercentilos.Tipo.PC_A_EDAD);
                }
                if (age.getValueInUnit(age.getValue(), Dimensionizable.AgeUnit.AÑO) <= 2) {
                    availableTable.addElement(TablaPercentilos.Tipo.PESO_A_TALLA);
                }
            }
        } catch (InvalidUnitException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Devuelve <code>true<code> si la tabla del <code>tipo<code> especificado
     * corresponde para éste paciente
     * @param tipo
     * @return
     */
    public boolean isTableAvailable(TablaPercentilos.Tipo tipo) {
        return availableTable.contains(tipo);
    }

    /**
     * Enumeración de sexos incluyendo un marcador <code>NA<code> utilizado
     * cuando no hay información.
     */
    public static final class Sexo {

        private final String name;
        public static final Sexo VARON = new Sexo("VARON");
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

    /**
     * Exepción que se debe lanzar cuando no se encuentra un dato en éste
     * <code>PatientProfile<code>.
     */
    public static final class DataNotFoundException extends Exception {

        public DataNotFoundException(String message) {
            super(message);
        }
    }
}
