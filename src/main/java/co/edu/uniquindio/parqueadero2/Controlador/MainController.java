package co.edu.uniquindio.parqueadero2.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    @FXML
    void crearParqueadero(ActionEvent event) throws IOException {
        cargarEscena("crearParqueadero.fxml");
    }

    @FXML
    void registrarVehiculo(ActionEvent event) throws IOException {
        cargarEscena("registrarVehiculo.fxml");
    }

    @FXML
    void verPuestos(ActionEvent event) throws IOException {
        cargarEscena("verPuestos.fxml");
    }

    @FXML
    void calcularCosto(ActionEvent event) throws IOException {
        cargarEscena("calcularCosto.fxml");
    }

    @FXML
    void generarReporte(ActionEvent event) throws IOException {
        cargarEscena("generarReporte.fxml");
    }

    @FXML
    void salir(ActionEvent event) {
        System.exit(0);
    }

    private void cargarEscena(String fxml) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/co/edu/uniquindio/parqueadero2/Vista/" + fxml)));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
