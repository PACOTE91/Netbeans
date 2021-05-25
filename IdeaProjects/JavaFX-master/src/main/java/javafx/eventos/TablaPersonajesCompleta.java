package javafx.eventos;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.eventos.clases.Personaje;
import javafx.eventos.clases.Personaje.Estrategia;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TablaPersonajesCompleta extends Application {
	
	private static final ObservableList<Personaje> PERSONAJES = FXCollections.observableArrayList(
			new Personaje("Bob Esponja", 10, false, Estrategia.RISA),
			new Personaje("Mortadelo", 60, true, Estrategia.RISA),
			new Personaje("Goku", 90, true, Estrategia.ATAQUE),
			new Personaje("El Malo", 0, false, Estrategia.MALHUMOR),
			new Personaje("Gro", 100, false, Estrategia.RISA));
	
	private class ConvierteEnteroCadena extends IntegerStringConverter  {
		@Override
		public Integer fromString(String value) {
			try {
				int entero = Integer.parseInt(value);
				return (entero < 0 || entero > 100) ? 0 : entero;
			} catch (Exception e) {
				return 0;
			}
		}
    }
	
	private TableView<Personaje> tvPersonajes;
	private ListView<Personaje> lvPersonajes;
	
	private void filaCambiada(Personaje personaje) {
		if (personaje != null) {
			System.out.println("Fila cambiada: " + personaje);
		}
	}
	
	private void filaSeleccionada(Personaje personaje) {
		if (personaje != null) {
			lvPersonajes.getSelectionModel().select(personaje);
			System.out.println("Fila seleccionada: " + personaje);
		}
	}
	
	private void borrarFilaSeleccionada() {
		Personaje personaje = tvPersonajes.getSelectionModel().getSelectedItem();
		if (personaje != null) {
			PERSONAJES.remove(personaje);
			System.out.println("Fila borrada: " + personaje);
		}
	}
	
	private void anadirPersonajeVacio() {
		Personaje personaje = new Personaje("Cámbiame", 0, false, Estrategia.MALHUMOR);
		PERSONAJES.add(personaje);
		System.out.println("Personaje añadido: " + personaje);
	}

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox(10);
			raiz.setPadding(new Insets(20));
			raiz.setAlignment(Pos.CENTER);
			
			Label lbPersonajes = new Label("Personajes");
			lbPersonajes.setFont(Font.font("Arial", 30));
			
			HBox hbPersonajes = new HBox(20);
			hbPersonajes.setPadding(new Insets(10));
			
			tvPersonajes = new TableView<>(PERSONAJES);
			
			TableColumn<Personaje, String> cNombre = new TableColumn<>("Nombre");
			TableColumn<Personaje, Integer> cPoder = new TableColumn<>("Poder");
			TableColumn<Personaje, Boolean> cSuperpoder = new TableColumn<>("Super Poder");
			TableColumn<Personaje, Estrategia> cEstrategia = new TableColumn<>("Estrategia");
			
			tvPersonajes.getColumns().add(cNombre);
			tvPersonajes.getColumns().add(cPoder);
			tvPersonajes.getColumns().add(cSuperpoder);
			tvPersonajes.getColumns().add(cEstrategia);
			tvPersonajes.setEditable(true);
			tvPersonajes.setMinWidth(360);
			
			cNombre.setMinWidth(100);
			cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			cNombre.setCellFactory(TextFieldTableCell.forTableColumn());
			cNombre.setOnEditCommit(e -> {
				int indice = PERSONAJES.indexOf(e.getRowValue());
				e.getRowValue().setNombre(e.getNewValue());
				PERSONAJES.set(indice, e.getRowValue());
				filaCambiada(e.getRowValue());
			});
			cPoder.setMinWidth(20);
			cPoder.setCellValueFactory(new PropertyValueFactory<>("poder"));
			cPoder.setCellFactory(TextFieldTableCell.<Personaje, Integer>forTableColumn(new ConvierteEnteroCadena()));
			cPoder.setOnEditCommit(e -> {
				int indice = PERSONAJES.indexOf(e.getRowValue());
				e.getRowValue().setPoder(e.getNewValue());
				PERSONAJES.set(indice, e.getRowValue());
				filaCambiada(e.getRowValue());
			});
			cSuperpoder.setMinWidth(40);
						cSuperpoder.setCellValueFactory(new PropertyValueFactory<>("superpoder"));
			cSuperpoder.setCellFactory(superPoder -> new CheckBoxTableCell<>());
			cSuperpoder.setCellValueFactory(fila -> {
				BooleanProperty superpoderProperty = new SimpleBooleanProperty(fila.getValue().isSuperpoder());
				superpoderProperty.addListener((observable, oldValue, newValue) -> {
					int indice = PERSONAJES.indexOf(fila.getValue());
					fila.getValue().setSuperpoder(newValue);
					PERSONAJES.set(indice, fila.getValue());
					filaCambiada(fila.getValue());
				});
				return superpoderProperty;
			});
			cEstrategia.setMinWidth(60);
			cEstrategia.setCellValueFactory(new PropertyValueFactory<>("estrategia"));
			cEstrategia.setCellFactory(estrategia -> new ChoiceBoxTableCell<Personaje, Estrategia>(Estrategia.values()));
			cEstrategia.setOnEditCommit(e -> {
				int indice = PERSONAJES.indexOf(e.getRowValue());
				e.getRowValue().setEstrategia(e.getNewValue());
				PERSONAJES.set(indice, e.getRowValue());
				filaCambiada(e.getRowValue());
			});
			tvPersonajes.getSelectionModel().selectedItemProperty().addListener((ob, oldValue, newValue) -> filaSeleccionada(newValue));

			lvPersonajes = new ListView<>(PERSONAJES);
			lvPersonajes.setMinWidth(500);

			hbPersonajes.getChildren().addAll(tvPersonajes, lvPersonajes);
			
			Button btBorrar = new Button("Borrar fila seleccionada");
			btBorrar.setStyle("-fx-font: 20 arial; -fx-base: #dc143c;");
			btBorrar.setOnAction(e -> borrarFilaSeleccionada());
			Button btAnadir = new Button("Añadir Personaje");
			btAnadir.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
			btAnadir.setOnAction(e -> anadirPersonajeVacio());
			
			raiz.getChildren().addAll(lbPersonajes, hbPersonajes, btBorrar, btAnadir);
			
			Scene escena = new Scene(raiz, 950, 450);
			escenarioPrincipal.setTitle("Tabla Personajes completa");
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
