package javafx.eventos;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.eventos.clases.PersonajePropiedades.Estrategia;
import javafx.eventos.clases.PersonajePropiedades;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TablaPersonajesPropiedades extends Application {
	
	private static final ObservableList<PersonajePropiedades> PERSONAJES = FXCollections.observableArrayList(
			new PersonajePropiedades("Bob Esponja", 10, false, Estrategia.RISA),
			new PersonajePropiedades("Mortadelo", 60, true, Estrategia.RISA),
			new PersonajePropiedades("Goku", 90, true, Estrategia.ATAQUE),
			new PersonajePropiedades("El Malo", 0, false, Estrategia.MALHUMOR),
			new PersonajePropiedades("Gro", 100, false, Estrategia.RISA));

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox();
			raiz.setPadding(new Insets(40));
			raiz.setSpacing(10);
			raiz.setAlignment(Pos.CENTER);
			
			Label lbPersonajes = new Label("Personajes");
			lbPersonajes.setFont(Font.font(20));
			TableView<PersonajePropiedades> tvPersonajes = new TableView<>(PERSONAJES);
			
			TableColumn<PersonajePropiedades, String> cNombre = new TableColumn<>("Nombre");
			TableColumn<PersonajePropiedades, Integer> cPoder = new TableColumn<>("Poder");
			TableColumn<PersonajePropiedades, Boolean> cSuperpoder = new TableColumn<>("Super Poder");
			TableColumn<PersonajePropiedades, Estrategia> cEstrategia = new TableColumn<>("Estrategia");
			
			tvPersonajes.getColumns().add(cNombre);
			tvPersonajes.getColumns().add(cPoder);
			tvPersonajes.getColumns().add(cSuperpoder);
			tvPersonajes.getColumns().add(cEstrategia);
			
			cNombre.setMinWidth(100);
			cNombre.setCellValueFactory(fila -> fila.getValue().nombreProperty());
			cPoder.setMinWidth(20);
			cPoder.setCellValueFactory(fila -> fila.getValue().poderProperty().asObject());
			cSuperpoder.setMinWidth(40);
			cSuperpoder.setCellValueFactory(fila -> fila.getValue().superpoderProperty());
			cEstrategia.setMinWidth(60);
			cEstrategia.setCellValueFactory(fila -> fila.getValue().estrategiaProperty());
			
			raiz.getChildren().addAll(lbPersonajes, tvPersonajes);
			
			Scene escena = new Scene(raiz, 455, 250);
			escenarioPrincipal.setTitle("Tabla personajes");
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
