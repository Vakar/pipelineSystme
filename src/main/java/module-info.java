module com.dbbest {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.h2database;
    requires java.sql;

    opens com.dbbest to javafx.fxml;
    exports com.dbbest;
}