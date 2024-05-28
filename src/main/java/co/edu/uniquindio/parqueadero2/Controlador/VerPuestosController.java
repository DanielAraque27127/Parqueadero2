package co.edu.uniquindio.parqueadero2.Controlador;

import co.edu.uniquindio.parqueadero2.Modelo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VerPuestosController {

    @FXML
    private Label puestosLabel;

    @FXML
    void actualizarPuestos(ActionEvent event) {

    }

    @FXML
    void volver(ActionEvent event) {
        Stage stage = (Stage) puestosLabel.getScene().getWindow();
        stage.close();
    }
}
