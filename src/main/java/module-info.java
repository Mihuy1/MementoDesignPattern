module com.example.mementodesignpattern {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mementodesignpattern to javafx.fxml;
    exports com.example.mementodesignpattern;
}