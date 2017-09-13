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

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author John Miru <AEFictionDev@gmail.com>
 */

/*
EXIT CODES:
0 All's well.
1 Couldn't load required file.
*/
public class AESimBrothel extends Application {
    @Override
    public void start(final Stage primaryStage) throws IOException {
        FileHandler errorLogHandler;
        File logDir;

        logDir = new File("logs");
        logDir.mkdir();
        errorLogHandler = new FileHandler("logs/error.log");
        Logger.getLogger("errorLog").addHandler(errorLogHandler);
        MainController.setEventStage(primaryStage);
        switchScene(primaryStage, "Main Menu");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }

    public static void switchScene(final Stage stage, final String title) {
        final Logger errorLog = Logger.getLogger("errorLog");
        switch(title) {
            case "Credits":
                try {
                    SceneList.showCredits(stage);
                } catch (IOException ex) {
                    errorLog.log(Level.SEVERE, "Could not load Credits", ex);
                    System.exit(1);
                }
                break;
            case "License":
                try {
                    SceneList.showLicense(stage);
                } catch (IOException ex) {
                    errorLog.log(Level.SEVERE, "Could not load License", ex);
                    System.exit(1);
                }
                break;
            case "Main Menu":
            default:
                try {
                    SceneList.mainMenu(stage);
                } catch (IOException ex) {
                    errorLog.log(Level.SEVERE, "Could not load Main Menu", ex);
                    System.exit(1);
                }
                break;
        }
    }
}

