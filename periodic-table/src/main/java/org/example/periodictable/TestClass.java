package org.example.periodictable;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestClass {

    @Before
    public void testBefore () {
        PeriodicTableApplication.isRunningTest = true;
        Launcher.isRunningTest = true;
    }

    @Test
    public void testLauncher () {
        Launcher.main(null);
    }

    @Test
    public void applicationTest () {
        PeriodicTableApplication app = new PeriodicTableApplication();
        try {
            app.start(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadFromCSV () {

    }
}
