package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.recursos.LocalizadorRecursos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = FXMLLoader.load(LocalizadorRecursos.class.getResource("vistas/EjecutarEjemplo.fxml"));
			Scene escena = new Scene(raiz);
			escenarioPrincipal.setTitle("Ejemplos JavaFX");
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
