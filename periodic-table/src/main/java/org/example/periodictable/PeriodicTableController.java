package org.example.periodictable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PeriodicTableController implements Initializable {

    public static ArrayList<Element> elementsArray = new ArrayList<>();

    public static int[][] periodicTableLayout = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6, 7, 8, 9, 10},
            {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 34, 36},
            {37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54},
            {55, 56, 0, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86},
            {87, 88, 0, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 0},
            {0, 0, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 0},
    };

    public String hexExamine(String hex) {

        if (hex.charAt(0) != '#') hex = "#" + hex;

        if (hex.length() == 4) {
            return "#" + hex.charAt(1) + hex.charAt(1) + hex.charAt(2) + hex.charAt(2) + hex.charAt(3) + hex.charAt(3);
        }

        if (hex.length() == 7) return hex;
        else return "#000000";
    }

    public boolean isColorDark (String hexColor) {
        hexColor = hexExamine(hexColor).replace("#", "");
        int r = Integer.parseInt(hexColor.substring(0, 2), 16);
        int g = Integer.parseInt(hexColor.substring(2, 4), 16);
        int b = Integer.parseInt(hexColor.substring(4, 6), 16);
        double luminance = (0.299 * r + 0.587 * g + 0.114 * b);
        return luminance < 128;
    }

    @FXML public GridPane periodicGrid;

    public void drawPeriodicTable() {
        periodicGrid.getChildren().clear();

        for (int row = 0; row < periodicTableLayout.length; row++) {

            for (int column = 0; column < periodicTableLayout[row].length; column++) {

                for (Element element : elementsArray) {

                    if (periodicTableLayout[row][column] == element.getAtomicNumber()) {
                        Label name = new Label();
                        name.setText(element.getName());
                        name.setStyle("-fx-font-size: 10px;");
                        name.setWrapText(true);
                        GridPane.setRowIndex(name, 1);

                        Label symbol = new Label();
                        symbol.setText(element.getSymbol());
                        symbol.setTranslateY(-12.0);
                        symbol.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

                        Rectangle rectangle = new Rectangle();
                        rectangle.setArcHeight(8.0);
                        rectangle.setArcWidth(8.0);
                        rectangle.setHeight(50);
                        rectangle.setStroke(Paint.valueOf("BLACK"));
                        rectangle.setStrokeType(StrokeType.valueOf("OUTSIDE"));
                        rectangle.setWidth(60);

                        if (!element.getCpkHexColor().isEmpty() && !element.getCpkHexColor().equals("0.00E+00")) {
                            String hexColor = "#" + element.getCpkHexColor();
                            Color textColor = isColorDark(hexColor) ? Color.WHITE : Color.BLACK;
                            symbol.setTextFill(textColor);
                            name.setTextFill(textColor);
                            rectangle.setFill(Paint.valueOf(hexColor));
                        } else {
                            symbol.setTextFill(Paint.valueOf("BLACK"));
                            name.setTextFill(Paint.valueOf("BLACK"));
                            rectangle.setFill(Paint.valueOf("WHITE"));
                        }

                        StackPane stackPane = new StackPane();
                        stackPane.getChildren().add(rectangle);
                        stackPane.getChildren().add(name);
                        stackPane.getChildren().add(symbol);

                        GridPane.setRowIndex(stackPane, row);
                        GridPane.setColumnIndex(stackPane, column);
                        periodicGrid.getChildren().add(stackPane);
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        elementsArray = LoadFromCSV.filereader("periodic-table-data.csv");
        drawPeriodicTable();

    }
}
