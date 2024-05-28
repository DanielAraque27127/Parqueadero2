package co.edu.uniquindio.parqueadero2.Controlador;

import co.edu.uniquindio.parqueadero2.Modelo.Main;
import co.edu.uniquindio.parqueadero2.Modelo.Parqueadero;
import co.edu.uniquindio.parqueadero2.Modelo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalcularCostoController {

    @FXML
    private TextField codigoParqueaderoField;

    @FXML
    private TextField placaVehiculoField;

    @FXML
    private TextField horasEstacionadoField;

    @FXML
    private Label costoLabel;

    @FXML
    void calcularCosto(ActionEvent event) {
        int codigoParqueadero = Integer.parseInt(codigoParqueaderoField.getText());
        String placaVehiculo = placaVehiculoField.getText();
        int horasEstacionado = Integer.parseInt(horasEstacionadoField.getText());

        if (Main.parqueaderosRegistrados.containsKey(codigoParqueadero)) {
            Parqueadero parqueadero = Main.parqueaderosRegistrados.get(codigoParqueadero);
            Vehiculo vehiculo = Main.vehiculosRegistrados.get(placaVehiculo);

            if (vehiculo != null) {
                double costo = parqueadero.calcularCosto(vehiculo, horasEstacionado);
                costoLabel.setText("Costo: $" + Main.decimal.format(costo));
            } else {
                costoLabel.setText("Vehículo no encontrado.");
            }
        } else {
            costoLabel.setText("Parqueadero no encontrado.");
        }
    }

    @FXML
    void volver(ActionEvent event) {
        Stage stage = (Stage) codigoParqueaderoField.getScene().getWindow();
        stage.close();
    }
}
