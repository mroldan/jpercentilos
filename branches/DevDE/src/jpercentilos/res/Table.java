/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpercentilos.res;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.NoSuchElementException;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class Table {

    final double[][] tabla;
//    final String[] units;

    public Table(File fromFile) throws IOException {
        TableReader tr = new TableReader(fromFile);
        tabla = tr.getTableAsArray();
//        units = tr.getTableUnits();
    }

    public double getElementAt(int row, int column) {
        return tabla[row][column];
    }

    /**
     * Looks in the specified column for <code>value<code>
     * @param value
     * @param column
     * @return The line number of the occurrence of <code>value<code>
     * @throws NoSuchElementException
     */
    public int searchValue(double value, int column, boolean sorted) throws NoSuchElementException {
        if (sorted) {
            return binarySearch(value, column);
        } else {
            return secuentialSearch(value, column);
        }
    }

    /**
     * Searchs for <code>value<code> in the specified <code>column<code> by performing a
     * binary search. The table must be sorted in ascendent order in that column.
     * @param value
     * @param column
     * @return Index of the row containing <code>value<code>
     * @throws NoSuchElementException
     */
    public int binarySearch(double value, int column) throws NoSuchElementException {
        int fin = tabla.length - 1;
        int prin = 0;
        do {
            int index = (fin - prin) / 2 + prin;
            if (tabla[index][column] == value) {
                return index;
            } else {
                if (tabla[index][column] > value) {
                    fin = index - 1;
                } else {
                    prin = index + 1;
                }
            }
        } while (fin >= prin);
        throw new NoSuchElementException("Value not found");
    }

    /**
     * Searchs for the first occurence of <code>value<code> in the specified <code>column<code>
     * of the table in a secuential form.
     *
     * @param value
     * @param column
     * @return Index of the first occurence of <code>value<code>
     * @throws NoSuchElementException
     */
    public int secuentialSearch(double value, int column) throws NoSuchElementException {
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i][column] == value) {
                return i;
            }
        }
        throw new NoSuchElementException("Value Not Found");
    }

    /**
     * Searchs for the nearest lower <code>value<code> in the specified <code>column<code>.
     * The table must be sorted in an ascendent way in that column. If not found
     * throws an exeption.
     * @param value
     * @param column
     * @return Index of the nearest lower of <code>value<code> in the specified column.
     * @throws ArrayIndexOutOfBoundsException
     */
    public int searchFloorValue(double value, int column) {
        int row = 0;
        while (tabla[row][column] <= value) {
            row++;
        }
        return row;
    }

    /**
     * Searchs for the nearest higher <code>value<code> in the specified <code>column<code>.
     * The table must be sorted in an ascendent way in that column. If not found
     * throws an exeption.
     * @param value
     * @param column
     * @return Index of the nearest higher of <code>value<code> in the specified column.
     * @throws ArrayIndexOutOfBoundsException
     */
    public int searchCeilValue(double value, int column) {
        int row = tabla.length - 1;
        while (tabla[row][column] >= value) {
            row--;
        }
        return row;
    }

    /**
     * Interpolates value y in the interval (<code>y1<code>, <code>y2<code>) for the <code>x<code>
     * value in the interval (<code>x1<code>, <code>x2<code>).
     * @param x
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return Interpolated value in the interval (<code>y1<code>, <code>y2<code>).
     */
    protected double interpolateValue(double x, double x1, double x2, double y1, double y2) {
        double dx = x2 - x1, dy = y2 - y1;
        return y1 + (dy / dx) * (x - x1);
    }

}
