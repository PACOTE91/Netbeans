package javafx.panelesdiseno;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelCuadricula extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			GridPane raiz = new GridPane();
			raiz.setHgap(20);
			raiz.setVgap(20);
			raiz.setPadding(new Insets(20));
			
			Label lbNombre = new Label("Nombre:");
			Label lbApellidos = new Label("Apellidos:");
			Label lbDni = new Label("DNI:");
			TextField tfNombre = new TextField();
			TextField tfApellidos = new TextField();
			TextField tfDni = new TextField();
			
			raiz.add(lbNombre, 0, 0);
			GridPane.setHalignment(lbNombre, HPos.RIGHT);
			raiz.add(tfNombre, 1, 0);
			raiz.add(lbApellidos, 0, 1);
			GridPane.setHalignment(lbApellidos, HPos.RIGHT);
			raiz.add(tfApellidos, 1, 1);
			raiz.add(lbDni, 0, 2);
			GridPane.setHalignment(lbDni, HPos.RIGHT);
			raiz.add(tfDni, 1, 2);
			
			Scene escena = new Scene(raiz, 300, 160);
			escenarioPrincipal.setTitle("Panel en cuadrícula");
			escenarioPrincipal.setScene(escena);
			escenarioPrincipal.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
