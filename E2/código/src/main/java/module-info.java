module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.controller;
    opens org.example.controller to javafx.fxml;
    exports org.example.database;
    opens org.example.database to javafx.fxml;
    exports org.example.module;
    opens org.example.module to javafx.fxml;
}
