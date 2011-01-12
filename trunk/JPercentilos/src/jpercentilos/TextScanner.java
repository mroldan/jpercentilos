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
package jpercentilos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Joaquín Ignacio Aramendía <samsagax@gmail.com>
 */
public class TextScanner {

    private String fFileName;
    private String fEncoding;

    public TextScanner(String fFileName){
        this(fFileName, "UTF-8");
    }

    public TextScanner(String fFileName, String fEncoding) {
        this.fFileName = fFileName;
        this.fEncoding = fEncoding;
    }


    /**
     * Read the contents of the given file.
     */
    private String read() throws IOException {
        System.out.println("Reading from file: " + fFileName);
        StringBuilder sb = new StringBuilder();
        String NL = System.getProperty("line.separator");
        Scanner scanner = new Scanner(new FileInputStream(fFileName), fEncoding);
        try {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(NL);
            }
        } finally {
            scanner.close();
        }
        //Ésta línea tiene propósitos de testeo solamente
//        System.out.println("Text read in:\n" + sb);
        return sb.toString();
    }

    public String retrieveText() throws IOException {
        return read();
    }
}
