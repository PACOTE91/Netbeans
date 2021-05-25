package javafx.panelesdiseno;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class PanelFlujo extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			FlowPane raiz = new FlowPane();
			raiz.setPadding(new Insets(10));
			raiz.setAlignment(Pos.CENTER);
			
			Button bt1 = new Button("Botón 1");
			Button bt2 = new Button("Botón 2");
			Button bt3 = new Button("Botón 3");
			Button bt4 = new Button("Botón 4");
			Button bt5 = new Button("Botón 5");
			
			raiz.getChildren().addAll(bt1, bt2, bt3, bt4, bt5);
			
			Scene escena = new Scene(raiz, 400, 70);
			escenarioPrincipal.setTitle("Panel de flujo");
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