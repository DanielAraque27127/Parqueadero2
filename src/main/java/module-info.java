module co.edu.uniquindio.parqueadero2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.parqueadero2.Controlador to javafx.fxml;
    exports co.edu.uniquindio.parqueadero2;
}