package javafx.manejadores;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ManejadorLambda2 extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			HBox raiz = new HBox();
			raiz.setAlignment(Pos.CENTER);
			
			Button btEjemplo = new Button("Púlsame!!!!");
			btEjemplo.setOnAction(e -> System.out.println("Botón pulsado!!!"));
			
			raiz.getChildren().add(btEjemplo);
			
			Scene escena = new Scene(raiz, 350, 100);
			escenarioPrincipal.setTitle("Manejador Función lambda");
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
