package co.edu.uniquindio.parqueadero2.Controlador;

import co.edu.uniquindio.parqueadero2.Modelo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GenerarReporteController {

    @FXML
    private Label reporteLabel;

    @FXML
    void generarReporteDiario(ActionEvent event) {

    }

    @FXML
    void generarReporteMensual(ActionEvent event) {

    }

    @FXML
    void volver(ActionEvent event) {
        Stage stage = (Stage) reporteLabel.getScene().getWindow();
        stage.close();
    }
}
