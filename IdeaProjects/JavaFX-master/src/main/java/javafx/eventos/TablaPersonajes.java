package javafx.eventos;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.eventos.clases.Personaje;
import javafx.eventos.clases.Personaje.Estrategia;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TablaPersonajes extends Application {
	
	private static final ObservableList<Personaje> PERSONAJES = FXCollections.observableArrayList(
			new Personaje("Bob Esponja", 10, false, Estrategia.RISA),
			new Personaje("Mortadelo", 60, true, Estrategia.RISA),
			new Personaje("Goku", 90, true, Estrategia.ATAQUE),
			new Personaje("El Malo", 0, false, Estrategia.MALHUMOR),
			new Personaje("Gro", 100, false, Estrategia.RISA));

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox();
			raiz.setPadding(new Insets(40));
			raiz.setSpacing(10);
			raiz.setAlignment(Pos.CENTER);
			
			Label lbPersonajes = new Label("Personajes");
			lbPersonajes.setFont(Font.font(20));
			TableView<Personaje> tvPersonajes = new TableView<>(PERSONAJES);
			
			TableColumn<Personaje, String> cNombre = new TableColumn<>("Nombre");
			TableColumn<Personaje, Integer> cPoder = new TableColumn<>("Poder");
			TableColumn<Personaje, Boolean> cSuperpoder = new TableColumn<>("Super Poder");
			TableColumn<Personaje, Estrategia> cEstrategia = new TableColumn<>("Estrategia");
			
			tvPersonajes.getColumns().add(cNombre);
			tvPersonajes.getColumns().add(cPoder);
			tvPersonajes.getColumns().add(cSuperpoder);
			tvPersonajes.getColumns().add(cEstrategia);
			
			cNombre.setMinWidth(100);
			cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre")); 
			cPoder.setMinWidth(20);
			cPoder.setCellValueFactory(new PropertyValueFactory<>("poder"));
			cSuperpoder.setMinWidth(40);
			cSuperpoder.setCellValueFactory(new PropertyValueFactory<>("superpoder"));
			cEstrategia.setMinWidth(60);
			cEstrategia.setCellValueFactory(new PropertyValueFactory<>("estrategia"));
			
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
