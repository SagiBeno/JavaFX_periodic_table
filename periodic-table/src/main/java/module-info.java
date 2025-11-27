module org.example.periodictable {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.periodictable to javafx.fxml;
    exports org.example.periodictable;
}