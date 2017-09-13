/*
 * Copyright (C) 2017 John Miru <AEFictionDev@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package aesimbrothel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Text;

/**
 *
 * @author John Miru <AEFictionDev@gmail.com>
 */
public class FileText extends Text {
    private final StringProperty location = new SimpleStringProperty(this, "location", "");
    
    public FileText() {
        super();
        location.addListener((property, oldValue, newValue) -> super.setText(loadContent(newValue)));
    }
    
    private String loadContent(final String uri) {
        String fileString = "";
        InputStream textFile;
        try {
            textFile = new URL(uri).openStream();
            final ByteArrayOutputStream fileContentBuffer = new ByteArrayOutputStream(textFile.available());
            int current;
            do {
                current = textFile.read();
                if(current != -1) {
                    fileContentBuffer.write(current);
                }
            } while(current != -1);
            fileString = fileContentBuffer.toString();
        } catch (IOException ex) {
            final Logger errorLog = Logger.getLogger("errorLog");
            errorLog.log(Level.SEVERE, "Could not load file", ex);
            System.exit(1);
        }
        return fileString;
    }
    
    public String getLocation() {
        return location.get();
    }
    
    public void setLocation(final String newUrl) {
        location.set(newUrl);
    }
}