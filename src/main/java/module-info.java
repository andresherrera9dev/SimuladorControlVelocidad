module com.andresherreraoett.simuladorcontrolvelocidad {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.andresherreraoett.simuladorcontrolvelocidad to javafx.fxml;
    exports com.andresherreraoett.simuladorcontrolvelocidad;
}