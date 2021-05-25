package javafx.comunicacionventanas.controladores;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ControladorVentana1 {
	
	@FXML private Button btSaluda;
	@FXML private ComboBox<String> cbAcciones;
	
	private Label lbMensajes;
	
	public void setLBMensajes(Label lbMensajes) {
		this.lbMensajes = lbMensajes;
	}
	
	@FXML 
	private void initialize() {
		cbAcciones.setItems(FXCollections.observableArrayList("Accion 1 Ventana 1", "Accion 2 Ventana 1"));
	}
	
	@FXML
	private void saluda() {
		lbMensajes.setText("Hola desde la ventana 1");
	}
	
	@FXML
	private void muestraEleccion() {
		lbMensajes.setText("Has elegido " + cbAcciones.getSelectionModel().getSelectedItem());
	}
}
