package org.example.periodictable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PeriodicTableApplication extends Application {
    public static boolean isRunningTest = false;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = null;
        if (!isRunningTest) fxmlLoader = new FXMLLoader(PeriodicTableApplication.class.getResource("periodic-table-view.fxml"));
        Scene scene =  null;
        if (!isRunningTest) scene = new Scene(fxmlLoader.load(), 1280, 720);
        if (!isRunningTest) stage.getIcons().add(new Image("file:icon.png"));
        if (!isRunningTest) stage.setTitle("Periodic table");
        if (!isRunningTest) stage.setScene(scene);
        if (!isRunningTest) stage.show();
    }
}
