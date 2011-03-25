/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class has methods for reading Text files as tables and parsing numbers.
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class TableReader extends TextScanner {

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
    public static double[][] readTable(ResourceFile file) throws IOException {
        return (new TableReader(file)).getTableAsArray();
    }

    /**
     * Reads specified line in input text
     * @param text
     * @param lineNum
     * @return the specified line in text
     */
    static String readLine(String text, int lineNum) {
        return (new TableReader(text)).readLine(lineNum);
    }

    String readNextLine() {
        lastLine = lineBreaker.next();
        return lastLine;
    }

    String readLine(int lineNum) {
        //Reset line breaker.
        lineBreaker.reset();
        int line = 1;
        while (lineBreaker.hasNextLine()) {
            if (line == lineNum) {
                return lineBreaker.nextLine();
            }
            line++;
            lineBreaker.nextLine();
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
        Scanner fieldBreaker = new Scanner(line.trim()).useLocale(Locale.US);
        int field = 1;
        while (fieldBreaker.hasNext()) {
            if (field == fieldNum) {
                return fieldBreaker.next();
            }
            field++;
            fieldBreaker.next();
        }
        return null;
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
        return (new StringTokenizer(s, "\n")).countTokens() - ignoreLines;
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
        String line = new StringTokenizer(s, "\n").nextToken();
        // Counts tokens in the line
        return (new StringTokenizer(line, "\t")).countTokens() - ignoreColumns;
    }

    /**
     * Instance fields
     */
    String textRead;
    final Scanner lineBreaker;
    String lastLine;

    /**
     * Constructs a TableReader Object reading form specified InputStream.
     * @param file
     * @throws IOException
     */
    public TableReader(ResourceFile file) throws IOException {
        textRead = retrieveText(file);
        lineBreaker = new Scanner(textRead);
    }

    /**
     * Constructs a TableReader Object reading from specified <code>tableText<code>.
     * @param tableText String containing a table to be read.
     */
    public TableReader(String tableText) {
        textRead = tableText;
        lineBreaker = new Scanner(textRead);
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
        lineBreaker.reset().useLocale(Locale.US);
        // Skip a number of rows
        for (int i = 0; i < 1; i++) {
            lineBreaker.nextLine();
        }
        for (; lineBreaker.hasNextLine(); row++) {
            String line = lineBreaker.nextLine();
            int column = 0;
            Scanner fieldBreaker = new Scanner(line).useLocale(Locale.US);
//            // Skip a number of Columns
//            for (int i = 0; i < 1; i++) {
//                fieldBraker.nextToken();
//            }
            for (; fieldBreaker.hasNext(); column++) {
                t[row][column] = fieldBreaker.nextDouble();
            }
        }
        return t;
    }
    
}