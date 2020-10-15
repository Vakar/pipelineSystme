module com.dbbest {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dbbest to javafx.fxml;
    exports com.dbbest;
}