package javafx.aplicacionfxml.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Ejemplo {
	@FXML
	private Button btCerrar;
	
	@FXML
	private void cerrar() {
		((Stage) btCerrar.getParent().getScene().getWindow()).close();
	}

}
