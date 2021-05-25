package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Plantilla extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			Pane raiz = new Pane();
			
			Scene escena = new Scene(raiz, 400, 400);
			escenarioPrincipal.setTitle("Plantilla");
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
