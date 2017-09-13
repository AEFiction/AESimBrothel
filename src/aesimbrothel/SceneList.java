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

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author John Miru <AEFictionDev@gmail.com>
 */
public final class SceneList extends AESimBrothel {
    private SceneList() {
        super();
    }
    public static void mainMenu(final Stage stage) throws IOException {
        Parent mainMenuXML;
        Scene mainMenuScene;

        mainMenuXML = FXMLLoader.load(SceneList.class.getResource("mainMenuScreen.fxml"));
        mainMenuScene = new Scene(mainMenuXML, 1024, 768);
        stage.setTitle(makeTitle("Main Menu"));
        stage.setScene(mainMenuScene);
    }

    public static void showCredits(final Stage stage) throws IOException {
        Parent showCreditsXML;
        Scene showCreditsScene;

        showCreditsXML = FXMLLoader.load(SceneList.class.getResource("showCredits.fxml"));
        showCreditsScene = new Scene(showCreditsXML, 1024, 768);
        stage.setTitle(makeTitle("Credits"));
        stage.setScene(showCreditsScene);
    }

    public static void showLicense(final Stage stage) throws IOException {
        Parent showLicenseXML;
        Scene showLicenseScene;

        showLicenseXML = FXMLLoader.load(SceneList.class.getResource("showLicense.fxml"));
        showLicenseScene = new Scene(showLicenseXML, 1024, 768);
        stage.setTitle(makeTitle("License"));
        stage.setScene(showLicenseScene);
    }

    private static String makeTitle(final String subTitle) {
        return "AESimBrothel - " + subTitle;
    }
}
