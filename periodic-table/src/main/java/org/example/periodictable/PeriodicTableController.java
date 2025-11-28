package org.example.periodictable;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PeriodicTableController implements Initializable {

    public static ArrayList<Element> elementsArray = new ArrayList<>();
    public String searchString = "";
    public String filterString = "all";
    @FXML public GridPane periodicGrid;
    @FXML public TextField searchTextField;
    @FXML public ComboBox comboBox;

    public static int[][] periodicTableLayout = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6, 7, 8, 9, 10},
            {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 34, 36},
            {37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54},
            {55, 56, 0, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86},
            {87, 88, 0, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118},
            {0, 0, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 0},
            {0, 0, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 0},
    };

    public String hexExamine(String hex) {

        if (hex.charAt(0) != '#') hex = "#" + hex;

        if (hex.length() == 4) {
            return "#" + hex.charAt(1) + hex.charAt(1) + hex.charAt(2) + hex.charAt(2) + hex.charAt(3) + hex.charAt(3);
        }

        if (hex.length() == 5) {
            return "#" + hex.charAt(1) + hex.charAt(1) + hex.charAt(2) + hex.charAt(2) + hex.charAt(3) + hex.charAt(3) + hex.charAt(4) + hex.charAt(4);
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

    public void drawPeriodicTable() {
        periodicGrid.getChildren().clear();

        for (int row = 0; row < periodicTableLayout.length; row++) {

            for (int column = 0; column < periodicTableLayout[row].length; column++) {

                for (Element element : elementsArray) {

                    if (periodicTableLayout[row][column] == element.getAtomicNumber()) {
                        Label atomicNumber = new Label();
                        Label name = new Label();
                        Label symbol = new Label();
                        Rectangle rectangle = new Rectangle();
                        StackPane stackPane = new StackPane();

                        if (filterString.equalsIgnoreCase("all")) {
                            name.setText(element.getName());
                            symbol.setText(element.getSymbol());
                            name.setStyle("-fx-font-size: 10px;");
                            name.setWrapText(true);
                            GridPane.setRowIndex(name, 1);

                            symbol.setTranslateY(-12.0);
                            symbol.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

                            rectangle.setArcHeight(8.0);
                            rectangle.setArcWidth(8.0);
                            rectangle.setHeight(50);
                            rectangle.setWidth(60);
                            rectangle.setStroke(Paint.valueOf("BLACK"));
                            rectangle.setStrokeType(StrokeType.valueOf("OUTSIDE"));
                            GridPane.setRowIndex(stackPane, row);
                            GridPane.setColumnIndex(stackPane, column);
                        }

                        if (!filterString.equalsIgnoreCase("all") && filterString.equalsIgnoreCase(element.getGroupBlock())) {
                            name.setText(element.getName());
                            symbol.setText(element.getSymbol());
                            name.setStyle("-fx-font-size: 10px;");
                            name.setWrapText(true);
                            GridPane.setRowIndex(name, 1);

                            symbol.setTranslateY(-12.0);
                            symbol.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

                            rectangle.setArcHeight(8.0);
                            rectangle.setArcWidth(8.0);
                            rectangle.setHeight(50);
                            rectangle.setWidth(60);
                            rectangle.setStroke(Paint.valueOf("BLACK"));
                            rectangle.setStrokeType(StrokeType.valueOf("OUTSIDE"));
                            GridPane.setRowIndex(stackPane, row);
                            GridPane.setColumnIndex(stackPane, column);
                        }

                        if (!searchString.isEmpty()) {
                            String nameToLower = element.getName().toLowerCase();
                            String symbolToLower = element.getSymbol().toLowerCase();

                            if (nameToLower.contains(searchString) || symbolToLower.contains(searchString)) {
                                DropShadow dropShadow = new DropShadow();
                                dropShadow.setRadius(5.0);
                                dropShadow.setOffsetX(3.5);
                                dropShadow.setOffsetY(3.5);
                                dropShadow.setColor(Color.RED);

                                ScaleTransition scale = new ScaleTransition();
                                scale.setNode(rectangle);
                                scale.setDuration(Duration.millis(900));
                                scale.setInterpolator(Interpolator.LINEAR);

                                scale.setFromX(1.0);
                                scale.setFromY(1.0);
                                scale.setToX(1.05);
                                scale.setToY(1.05);

                                scale.setCycleCount(Animation.INDEFINITE);
                                scale.setAutoReverse(true);
                                scale.play();

                                rectangle.setEffect(dropShadow);
                            }
                        }

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

                        stackPane.getChildren().add(rectangle);
                        stackPane.getChildren().add(name);
                        stackPane.getChildren().add(symbol);
                        stackPane.setOnMouseClicked(event -> openDialog(element));

                        periodicGrid.getChildren().add(stackPane);
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        elementsArray = LoadFromCSV.filereader("periodic-table-data.csv");
        ArrayList<String> comboBoxOptions = new ArrayList<>();
        comboBoxOptions.add("All");

        for (Element element : elementsArray) {

            if (!element.getGroupBlock().isEmpty() && !comboBoxOptions.contains(element.getGroupBlock())) {
                comboBoxOptions.add(element.getGroupBlock());
            }
        }

        comboBox.getItems().addAll(comboBoxOptions);
        comboBox.setValue("All");

        drawPeriodicTable();
    }

    @FXML public void search() {
        searchString = searchTextField.getText().toLowerCase();
        drawPeriodicTable();
    }

    @FXML public void openDialog (Element element) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle(element.getName() + " details");

        Label title = new Label();
        title.setText(element.getName() + " (" + element.getSymbol() + ") ");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        TableView<PropertyRow> table = new TableView<>();

        TableColumn<PropertyRow, String> col1 = new TableColumn<>("Property");
        col1.setCellValueFactory(new PropertyValueFactory<>("key"));
        TableColumn<PropertyRow, String> col2 = new TableColumn<>("Value");
        col2.setCellValueFactory(new PropertyValueFactory<>("value"));

        table.getColumns().addAll(col1, col2);

        ObservableList<PropertyRow> rows = FXCollections.observableArrayList();

        rows.add(new PropertyRow("Atomic number", String.valueOf(element.getAtomicNumber())));
        if (!element.getAtomicMass().isEmpty()) rows.add(new PropertyRow("Atomic mass", element.getAtomicMass()));
        if (!element.getElectronicConfiguration().isEmpty()) rows.add(new PropertyRow("Electronic Configuration", element.getElectronicConfiguration()));
        if (!element.getElectronegativity().isEmpty()) rows.add(new PropertyRow("Electronegravity", element.getElectronegativity()));
        if (!element.getElectronAffinity().isEmpty()) rows.add(new PropertyRow("Electron affinity", element.getElectronAffinity()));
        if (!element.getAtomicRadius().isEmpty()) rows.add(new PropertyRow("Atomic radius", element.getAtomicRadius()));
        if (!element.getIonRadius().isEmpty()) rows.add(new PropertyRow("ION radius", element.getIonRadius()));
        if (!element.getIonizationEnergy().isEmpty()) rows.add(new PropertyRow("Ionization energy", element.getIonizationEnergy()));
        if (!element.getVanDelWaalsRadius().isEmpty()) rows.add(new PropertyRow("Van Del Waals Radius", element.getVanDelWaalsRadius()));
        if (!element.getOxidationStates().isEmpty()) rows.add(new PropertyRow("Oxidation states", element.getOxidationStates()));
        if (!element.getStandardState().isEmpty()) rows.add(new PropertyRow("Standard state", element.getStandardState()));
        if (!element.getBondingType().isEmpty()) rows.add(new PropertyRow("Bonding type", element.getBondingType()));
        if (!element.getMeltingPoint().isEmpty()) rows.add(new PropertyRow("Melting point", element.getMeltingPoint()));
        if (!element.getBoilingPoint().isEmpty()) rows.add(new PropertyRow("Boiling point", element.getBoilingPoint()));
        if (!element.getDensity().isEmpty()) rows.add(new PropertyRow("Density", element.getDensity()));
        if (!element.getGroupBlock().isEmpty()) rows.add(new PropertyRow("Group block", element.getGroupBlock()));
        if (!element.getYearDiscovered().isEmpty()) rows.add(new PropertyRow("Year discovered", element.getYearDiscovered()));

        table.getItems().addAll(rows);

        VBox container = new VBox();
        container.getChildren().add(title);
        container.getChildren().add(table);

        Scene scene = new Scene(container);
        dialog.setScene(scene);
        dialog.showAndWait();

    }

    public void comboBoxFilter() {
        filterString = comboBox.getValue().toString();
        drawPeriodicTable();
    }
}
