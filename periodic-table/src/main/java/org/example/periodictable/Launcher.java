package org.example.periodictable;

import javafx.application.Application;

public class Launcher {

    public static boolean isRunningTest = false;

    public static void main(String[] args) {
        if (!isRunningTest) Application.launch(PeriodicTableApplication.class, args);
    }
}
