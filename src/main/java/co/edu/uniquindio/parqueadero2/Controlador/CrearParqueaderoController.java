package co.edu.uniquindio.parqueadero2.Controlador;

import co.edu.uniquindio.parqueadero2.Modelo.Parqueadero;
import co.edu.uniquindio.parqueadero2.Modelo.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;

public class CrearParqueaderoController {
    @FXML
    private TextField codigoParqueaderoField;
    @FXML
    private TextField filasField;
    @FXML
    private TextField columnasField;
    @FXML
    private TextField tarifaMotoClasicaField;
    @FXML
    private TextField tarifaMotoHibridaField;
    @FXML
    private TextField tarifaCarroField;
    @FXML
    private Label mensajeLabel;

    private static Map<Integer, Parqueadero> parqueaderosRegistrados = new HashMap<>();
    private static Map<String, Vehiculo> vehiculosRegistrados = new HashMap<>();
    @FXML
    private void crearParqueadero() {
        int codigoParqueadero = Integer.parseInt(codigoParqueaderoField.getText());
        int filas = Integer.parseInt(filasField.getText());
        int columnas = Integer.parseInt(columnasField.getText());
        double tarifaMotoClasica = Double.parseDouble(tarifaMotoClasicaField.getText());
        double tarifaMotoHibrida = Double.parseDouble(tarifaMotoHibridaField.getText());
        double tarifaCarro = Double.parseDouble(tarifaCarroField.getText());

        Parqueadero nuevoParqueadero = new Parqueadero(vehiculosRegistrados, tarifaMotoClasica, tarifaMotoHibrida, tarifaCarro, filas, columnas, codigoParqueadero);
        parqueaderosRegistrados.put(codigoParqueadero, nuevoParqueadero);
        mostrarAlerta("Éxito", "Parqueadero creado correctamente.");
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
