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
import java.util.NoSuchElementException;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public final class TablaPercentilos extends Table {

    private final String name;
    static final int S_T = 3;   // S(t) index in table
    static final int M_T = 2;   // M(t) index in table
    static final int L_T = 1;   // L(t) index in table
//    static final int SD = 4;    // SD(t) index in table (not necesary?)
    static final int VALUE = 0;  // Unit index in table
    private double lastValue;
    private LMS lastLMS;
    private static TablaNormales TABLA_NORMALES = initializeTablaNormales();

    public TablaPercentilos(PatientProfile profile, Tipo tipo) throws IOException {
        this(profile.getTableFile(tipo));
    }

    public TablaPercentilos(TextFileReaderME.File file) throws IOException {
        super(file);
        this.name = file.getPath();
    }

    private static TablaNormales initializeTablaNormales() {
        if (TABLA_NORMALES == null) {
            try {
                TABLA_NORMALES = new TablaNormales();
            } catch (Exception e) {
                return null;
            }
        }
        return TABLA_NORMALES;

    }

    public double getCentile(double zScore) {
        return TABLA_NORMALES.getPz(zScore);
    }

    public String getName() {
        return name;
    }

    public double getZScore(double observedValue, double forInputValue) {
        LMS lms = getLms(forInputValue);
        System.out.println("LMS: " + lms.getL() + ", " + lms.getM() + ", " + lms.getS());
        double L = lms.getL(),
                M = lms.getM(),
                S = lms.getS();
        double pow = MathME.pow(observedValue / M, L);
        double zS = (pow - 1) / (L * S);
        if (Math.abs(zS) > 3) { //TODO revisar.
            if (zS < -3) {
                double s23neg = M * (MathME.pow(1 + L * S * (-2), L) - MathME.pow(1 + L * S * (-3), L));
                double s3neg = M * MathME.pow(1 + L * S * (-3), L);
                zS = -3 + (observedValue - s3neg) / (s23neg);
            } else {
                double s23pos = M * (MathME.pow(1 + L * S * 3, L) - MathME.pow(1 + L * S * 2, L));
                double s3pos = M * MathME.pow(1 + L * S * 3, L);
                zS = 3 + (observedValue - s3pos) / (s23pos);
            }
        }
        return zS;
    }

    public double getCentile(double observedValue, double forInputValue) {
        double zScore = getZScore(observedValue, forInputValue);
        return TABLA_NORMALES.getPz(zScore);
    }

    private LMS getLms(double value) {
        if (value != lastValue || value == 0) {
            double L, M, S;
            try {
                int index = binarySearch(value, VALUE);
                L = tabla[index][L_T];
                M = tabla[index][M_T];
                S = tabla[index][S_T];
            } catch (NoSuchElementException e) {
                try {
                    int lower = searchFloorValue(value, VALUE);
                    int higher = searchCeilValue(value, VALUE);
                    L = interpolateValue(value, tabla[lower][VALUE], tabla[higher][VALUE], tabla[lower][L_T], tabla[higher][L_T]);
                    M = interpolateValue(value, tabla[lower][VALUE], tabla[higher][VALUE], tabla[lower][M_T], tabla[higher][M_T]);
                    S = interpolateValue(value, tabla[lower][VALUE], tabla[higher][VALUE], tabla[lower][S_T], tabla[higher][S_T]);
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    throw arrayIndexOutOfBoundsException;
                }
            }
            lastValue = value;
            lastLMS = new LMS(L, M, S);
        }
        return lastLMS;
    }

    private static class LMS {

        private final double L, M, S;

        public LMS(double L, double M, double S) {
            this.L = L;
            this.M = M;
            this.S = S;
        }

        public double getL() {
            return L;
        }

        public double getM() {
            return M;
        }

        public double getS() {
            return S;
        }
    }

    /**
     * Enumeración de tupos de tablas.
     */
    public static final class Tipo {

        private final String name;
        public static final Tipo TALLA_A_EDAD = new Tipo("TALLA-EDAD");    //leido en cm
        public static final Tipo PESO_A_EDAD = new Tipo("PESO-EDAD");      // Leído en Kg
        public static final Tipo IMC_A_EDAD = new Tipo("IMC-EDAD");        //
        public static final Tipo PC_A_EDAD = new Tipo("PC-EDAD");          // Leído en mm
        public static final Tipo PESO_A_TALLA = new Tipo("PESO-TALLA");

        public Tipo(String name) {
            this.name = name;
        }

        public String bitPath() {
            return toString();
        }

        public String toString() {
            return name;
        }

        public static Tipo[] values() {
            Tipo[] t = {
                TALLA_A_EDAD,
                PESO_A_EDAD,
                IMC_A_EDAD,
                PC_A_EDAD,
                PESO_A_TALLA
            };
            return t;
        }
    }
}
