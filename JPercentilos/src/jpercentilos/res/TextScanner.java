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

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class TextScanner {

    public static String retrieveText(InputStream is) {
        StringBuilder sb = new StringBuilder();
        String NL = System.getProperty("line.separator");
        Scanner tx = new Scanner(is);
        try {
            while (tx.hasNextLine()) {
                sb.append(tx.nextLine()).append(NL);
            }
        } finally {
            tx.close();
        }
        //Ésta línea tiene propósitos de testeo solamente
//        System.out.println("Text read in:\n" + sb);
        return sb.toString();
    }
}
