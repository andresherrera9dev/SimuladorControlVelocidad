module com.ITCelaya.simuladorcontrolvelocidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome6;
    requires mysql.connector.j;
    requires java.desktop;
    opens com.ITCelaya.simuladorcontrolvelocidad to javafx.fxml;
    exports com.ITCelaya.simuladorcontrolvelocidad;
    exports com.ITCelaya.simuladorcontrolvelocidad.controllers;
    opens com.ITCelaya.simuladorcontrolvelocidad.controllers to javafx.fxml;
}