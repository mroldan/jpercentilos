/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

import java.io.IOException;
import java.io.InputStream;

/**
 * This class has methods for reading Text files as tables and parsing numbers.
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class TableReaderME extends TextFileReaderME {

    //Constants
    static final String NLDELIM = "\f\r\n";
    static final String TABDELIM = "\t";

    /**
     * Returns an row*column array of doubles initialized with zeros.
     * @param rows
     * @param columns
     * @return
     */
    private static double[][] initTable(int rows, int columns) {
        double[][] t = new double[rows][columns];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = 0;
            }
        }
        return t;
    }

    /**
     * Reads a String and retrieves a table of double values.
     * @param tableString - the string to be read as table.
     * @return two dimensional array containing the double values in the string.
     */
    public static double[][] readTable(TableReaderME.File file) throws IOException {
        return (new TableReaderME(file)).getTableAsArray();
    }

    /**
     * Reads specified line in input text
     * @param text
     * @param lineNum
     * @return the specified line in text
     */
    static String readLine(String text, int lineNum) {
        return (new TableReaderME(text)).readLine(lineNum);
    }

    String readNextLine() {
        lastLine = lineBreaker.nextToken();
        return lastLine;
    }

    String readLine(int lineNum) {
        //Reset line breaker.
        lineBreaker.reset();
        int line = 1;
        while (lineBreaker.hasMoreTokens()) {
            if (line == lineNum) {
                return lineBreaker.nextToken();
            }
            line++;
            lineBreaker.nextToken();
        }
        return null;
    }

    /**
     * Reads specified field in <code>line<code>
     * @param line
     * @param fieldNum
     * @return
     */
    static String readFieldInLine(String line, int fieldNum) {
        StringTokenizerME fieldBreaker = new StringTokenizerME(line.trim(), TABDELIM);
        int field = 1;
        while (fieldBreaker.hasMoreTokens()) {
            if (field == fieldNum) {
                return fieldBreaker.nextToken();
            }
            field++;
            fieldBreaker.nextToken();
        }
        return null;
    }

    String readNextFieldInLine() {
        if (fieldBreaker == null) {
            fieldBreaker = new StringTokenizerME(lastLine, TABDELIM);
        }
        String s = fieldBreaker.nextToken();
        if (!fieldBreaker.hasMoreTokens()) {
            fieldBreaker = null;
        }
        return s;
    }

    /**
     * Counts rows for the specified String to be read as a table. Ignoring the
     * first line as column names
     * @param s
     * @return
     */
    static int getRows(String s) {
        return getRows(s, 1);
    }

    /**
     * Counts Rows in a String, ignores the specified number of columns.
     * @param s
     * @param ignoreLines
     * @return
     */
    static int getRows(String s, int ignoreLines) {
        return (new StringTokenizerME(s, NLDELIM)).countTokens() - ignoreLines;
    }

    /**
     * Counts Columns in a String to be read as a table. Ignores the first
     * column by default. The string must have fields separated by the tab
     * character (<CODE>&#92;t<CODE>)
     * @param s
     * @return
     */
    static int getColumns(String s) {
        return getColumns(s, 1);
    }

    /**
     * Counts Columns in a String, ignores the specified number of columns.
     * @param s
     * @param ignoreColumns
     * @return
     */
    static int getColumns(String s, int ignoreColumns) {
        // First line in text.
        String line = new StringTokenizerME(s, NLDELIM).nextToken();
        // Counts tokens in the line
        return (new StringTokenizerME(line, TABDELIM)).countTokens() - ignoreColumns;
    }

    /**
     * Instance fields
     */
    String textRead;
    final StringTokenizerME lineBreaker;
    StringTokenizerME fieldBreaker = null;
    String lastLine;

    /**
     * Constructs a TableReaderME Object reading form specified InputStream.
     * @param file
     * @throws IOException
     */
    public TableReaderME(TextFileReaderME.File file) throws IOException {
        textRead = retrieveTextFromFile(file);
        lineBreaker = new StringTokenizerME(textRead, NLDELIM);
    }

    /**
     * Constructs a TableReaderME Object reading from specified <code>tableText<code>.
     * @param tableText String containing a table to be read.
     */
    public TableReaderME(String tableText) {
        textRead = tableText;
        lineBreaker = new StringTokenizerME(textRead, NLDELIM);
    }

    public double[][] getTableAsArray() {
        return readTable();
    }

    /**
     * Reads a String and retrieves a table of double values.
     * @param tableString - the string to be read as table.
     * @return two dimensional array containing the double values in the string.
     */
    private double[][] readTable() {
        String s = textRead.trim();
        // Count rows, skiping the first line
        int rows = getRows(s);
        // Count columns, skiping the first column /* Revisar!
        int columns = getColumns(s, 0);
        //Initialize table
        double[][] t = initTable(rows, columns);
        int row = 0;
        lineBreaker.reset();
        // Skip a number of rows
        for (int i = 0; i < 1; i++) {
            lineBreaker.nextToken();
        }
        for (; lineBreaker.hasMoreTokens(); row++) {
            String line = lineBreaker.nextToken();
            int column = 0;
            fieldBreaker = new StringTokenizerME(line, " \t");
//            // Skip a number of Columns
//            for (int i = 0; i < 1; i++) {
//                fieldBraker.nextToken();
//            }
            for (; fieldBreaker.hasMoreTokens(); column++) {
                t[row][column] = Double.parseDouble(fieldBreaker.nextToken());
            }
        }
        return t;
    }

    /**
     * Read table header for the units in each Column.
     * @return A String array containing the units in each column.
     */
    public String[] getTableUnits() {
        String[] units = new String[getColumns(textRead)];
        String header = readLine(1);
        fieldBreaker = new StringTokenizerME(header, TABDELIM);
        int i = 0;
        while (fieldBreaker.hasMoreTokens()) {
            units[i] = fieldBreaker.nextToken();
            i++;
        }
        return units;
    }
    
}
