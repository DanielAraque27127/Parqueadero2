package co.edu.uniquindio.parqueadero2.Controlador;

import co.edu.uniquindio.parqueadero2.Modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.HashMap;

public class RegistrarVehiculoController {
    @FXML
    private TextField codigoParqueaderoField;
    @FXML
    private TextField placaField;

    @FXML
    private TextField propietarioField;

    @FXML
    private TextField identificacionField;

    @FXML
    private TextField horaField;
    @FXML
    private TextField modeloField;
    @FXML
    private TextField tipoField;
    @FXML
    private TextField velocidadMaximaField;
    @FXML
    private TextField esHibridaField;
    @FXML
    private Label mensajeLabel;

    private HashMap<Integer, Parqueadero> parqueaderosRegistrados; // Debes inicializar esta variable con los parqueaderos registrados

    private HashMap<String, Vehiculo> vehiculosRegistrados = new HashMap<>();

    private Parqueadero obtenerParqueadero(int codigoParqueadero) {
        Parqueadero parqueadero = parqueaderosRegistrados.get(codigoParqueadero);
        if (parqueadero == null) {
            mensajeLabel.setText("No se encontró un parqueadero con el código " + codigoParqueadero);
        }
        return parqueadero;
    }

    @FXML
    private void registrarVehiculo() {
        int codigoParqueadero = Integer.parseInt(codigoParqueaderoField.getText());
        Parqueadero parqueadero = obtenerParqueadero(codigoParqueadero);
        if (parqueadero != null) {
            String placa = placaField.getText();
            String modelo = modeloField.getText();
            String tipo = tipoField.getText();
            String nombrePropietario = propietarioField.getText();
            String identificacion = identificacionField.getText();
            String hora = horaField.getText();
            Propietario propietario = new Propietario(nombrePropietario, identificacion);
            double tarifa = 0; // Inicializamos la tarifa en 0

            // Obtener la tarifa correspondiente según el tipo de vehículo
            if (tipo.equalsIgnoreCase("c")) {
                tarifa = parqueadero.getTarifaCarro();
            } else if (tipo.equalsIgnoreCase("m")) {
                boolean esHibrida = Boolean.parseBoolean(esHibridaField.getText());
                tarifa = esHibrida ? parqueadero.getTarifaMotoHibrida() : parqueadero.getTarifaMotoClasica();
            }

            // Crear el vehículo con la tarifa obtenida
            if (tarifa != 0) {
                if (tipo.equalsIgnoreCase("c")) {
                    Carro carro = new Carro(placa, modelo, propietario,tarifa);
                    carro.setHoraIngreso(hora);
                    vehiculosRegistrados.put(placa, carro);
                } else {
                    double velocidadMaxima = Double.parseDouble(velocidadMaximaField.getText());
                    boolean esHibrida = Boolean.parseBoolean(esHibridaField.getText());
                    Moto moto = new Moto(placa, modelo, propietario,tarifa, velocidadMaxima, esHibrida);
                    moto.setHoraIngreso(hora);
                    vehiculosRegistrados.put(placa, moto);
                }
                mostrarAlerta("Éxito", "Vehículo registrado correctamente.");
            } else {
                mensajeLabel.setText("Tipo de vehículo no válido.");
            }

        }
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}