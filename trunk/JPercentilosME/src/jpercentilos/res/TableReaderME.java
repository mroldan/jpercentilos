/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

import java.io.IOException;

/**
 * This class has methods for reading Text files as tables and parsing numbers.
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class TableReaderME extends TextFileReaderME {

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
    public static double[][] readTable(String tableString) {
        String s = tableString.trim();
        // Count rows, skiping the first line
        int rows = getRows(s);
        // Count columns, skiping the first column
        int columns = getColumns(s);
        //Initialize table
        double[][] t = initTable(rows, columns);
        int row = 0;
        StringTokenizerME lineBreaker = new StringTokenizerME(s, "\n\r\f");
        // Skip a number of rows
        for (int i = 0; i < 1; i++) {
            lineBreaker.nextToken();
        }
        for (; lineBreaker.hasMoreTokens(); row++) {
            String line = lineBreaker.nextToken();
            int column = 0;
            StringTokenizerME fieldBraker = new StringTokenizerME(line, " \t");
            // Skip a number of Columns
            for (int i = 0; i < 1; i++) {
                fieldBraker.nextToken();
            }
            for (; fieldBraker.hasMoreTokens(); column++) {
                t[row][column] = Double.parseDouble(fieldBraker.nextToken());
            }
        }
        return t;
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
        return (new StringTokenizerME(s, "\f\r\n")).countTokens() - ignoreLines;
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
        final String NLDELIM = "\f\r\n";
        final String TABDELIM = "\t";
        // First line in text.
        String line = new StringTokenizerME(s, NLDELIM).nextToken();
        // Counts tokens in the line
        return (new StringTokenizerME(line, TABDELIM)).countTokens() - ignoreColumns;
    }
    private String textRead;

    /**
     * Constructs a TableReaderME Object reading form specified file.
     * @param file
     * @throws IOException
     */
    public TableReaderME(String file) throws IOException {
        textRead = retrieveTextFromFile(file);
    }

    public double[][] getTable() {
        return readTable(textRead);
    }
}
