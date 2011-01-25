/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpercentilos.res;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class Table {

    private final double[][] table;

    public Table(double[][] table) {
        this.table = table;
    }

    public Table(String fromFile) throws IOException {
        this(new TableReaderME(fromFile).getTable());
    }

    public double getElementAt(int row, int column) {
        return table[row][column];
    }

    public int searchValue(double value, int column) throws NoSuchElementException {
        for (int i = 0; i < table.length; i++) {
            if (getElementAt(i, column) == value) {
                return i;
            }
        }
        throw new NoSuchElementException("NotFound");
    }

    public int searchFloorValue(double value, int column) throws ArrayIndexOutOfBoundsException{
        int row = 0;
        for (int i = 0; i < table.length; i++) {
            if (getElementAt(i, column) <= value) {
                row = i;
            } else {
                return row;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Reached the end of table");
    }

    public int searchCeilValue(double value, int column) throws ArrayIndexOutOfBoundsException{
        int row = 0;
        for (int i = table.length; i >= 0; i--) {
            if (getElementAt(i, column) >= value) {
                row = i;
            } else {
                return row;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Reached the end of table");
    }

}
