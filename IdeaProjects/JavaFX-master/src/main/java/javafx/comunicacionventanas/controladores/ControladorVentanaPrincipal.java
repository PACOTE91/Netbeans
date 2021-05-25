package javafx.comunicacionventanas.controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.recursos.LocalizadorRecursos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorVentanaPrincipal {
	
	@FXML private Button btVentana1;
	@FXML private Button btVentana2;
	@FXML private Label lbMensajes;
	
	private Stage escenarioVentana1;
	private Stage escenarioVentana2;

	private void crearVentana1() throws IOException {
		if (escenarioVentana1 == null) {
			escenarioVentana1 = new Stage();
			FXMLLoader cargadorVentana1 = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/Ventana1.fxml"));
			VBox raizVentana1 = cargadorVentana1.load();
			ControladorVentana1 controladorVentana1 = cargadorVentana1.getController();
			controladorVentana1.setLBMensajes(lbMensajes);
			Scene ventana1 = new Scene(raizVentana1);
			escenarioVentana1.setTitle("Ventana 1");
			escenarioVentana1.initModality(Modality.APPLICATION_MODAL); 
			escenarioVentana1.setScene(ventana1);
		}
	}
	
	private void crearVentana2() throws IOException {
		if (escenarioVentana2 == null) {
			escenarioVentana2 = new Stage();		
			FXMLLoader cargadorVentana2 = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/Ventana2.fxml"));
			VBox raizVentana2 = cargadorVentana2.load();
			ControladorVentana2 controladorVentana2 = cargadorVentana2.getController();
			controladorVentana2.setLBMensajes(lbMensajes);	
			Scene ventana2 = new Scene(raizVentana2);
			escenarioVentana2.setTitle("Ventana 2");
			escenarioVentana2.initModality(Modality.APPLICATION_MODAL);
			escenarioVentana2.setScene(ventana2);
		}
	}
	
	@FXML
	private void abrirVentana1() throws IOException {
		crearVentana1();
		escenarioVentana1.showAndWait();
	}
	
	@FXML
	private void abrirVentana2() throws IOException {
		crearVentana2();
		escenarioVentana2.showAndWait();
	}
	
}
