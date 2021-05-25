package javafx.manejadores;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ManejadorClase extends Application {
	
	private class MiManejador implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Botón pulsado!!!");
		}
		
	}

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			HBox raiz = new HBox();
			raiz.setAlignment(Pos.CENTER);
			
			Button btEjemplo = new Button("Púlsame!!!!");
			btEjemplo.setOnAction(new MiManejador());
			
			raiz.getChildren().add(btEjemplo);
			
			Scene escena = new Scene(raiz, 350, 100);
			escenarioPrincipal.setTitle("Manejador Clase");
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
