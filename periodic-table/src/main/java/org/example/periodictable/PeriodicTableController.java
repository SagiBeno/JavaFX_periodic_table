package org.example.periodictable;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PeriodicTableController implements Initializable {

    public static ArrayList<Element> elementsArray = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        elementsArray = LoadFromCSV.filereader("periodic-table-data.csv");
    }
}
