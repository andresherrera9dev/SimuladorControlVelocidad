module com.ITCelaya.simuladorcontrolvelocidad {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome6;
    opens com.ITCelaya.simuladorcontrolvelocidad to javafx.fxml;
    exports com.ITCelaya.simuladorcontrolvelocidad;
    exports com.ITCelaya.simuladorcontrolvelocidad.controllers;
    opens com.ITCelaya.simuladorcontrolvelocidad.controllers to javafx.fxml;
}