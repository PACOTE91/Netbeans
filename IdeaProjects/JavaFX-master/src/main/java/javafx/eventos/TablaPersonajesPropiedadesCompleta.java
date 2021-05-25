package javafx.eventos;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.eventos.clases.PersonajePropiedades;
import javafx.eventos.clases.PersonajePropiedades.Estrategia;
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

public class TablaPersonajesPropiedadesCompleta extends Application {
	
	private static final ObservableList<PersonajePropiedades> PERSONAJES = FXCollections.observableArrayList(
			new PersonajePropiedades("Bob Esponja", 10, false, Estrategia.RISA),
			new PersonajePropiedades("Mortadelo", 60, true, Estrategia.RISA),
			new PersonajePropiedades("Goku", 90, true, Estrategia.ATAQUE),
			new PersonajePropiedades("El Malo", 0, false, Estrategia.MALHUMOR),
			new PersonajePropiedades("Gro", 100, false, Estrategia.RISA));
	
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
	
	private TableView<PersonajePropiedades> tvPersonajes;
	private ListView<PersonajePropiedades> lvPersonajes;
	
	private void filaCambiada(PersonajePropiedades personaje) {
		if (personaje != null) {
			System.out.println("Fila cambiada: " + personaje);
		}
	}
	
	private void filaSeleccionada(PersonajePropiedades personaje) {
		if (personaje != null) {
			lvPersonajes.getSelectionModel().select(personaje);
			System.out.println("Fila seleccionada: " + personaje);
		}
	}
	
	private void borrarFilaSeleccionada() {
		PersonajePropiedades personaje = tvPersonajes.getSelectionModel().getSelectedItem();
		if (personaje != null) {
			PERSONAJES.remove(personaje);
			System.out.println("Fila borrada: " + personaje);
		}
	}
	
	private void anadirPersonajeVacio() {
		PersonajePropiedades personaje = new PersonajePropiedades("Cámbiame", 0, false, Estrategia.MALHUMOR);
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
			
			TableColumn<PersonajePropiedades, String> cNombre = new TableColumn<>("Nombre");
			TableColumn<PersonajePropiedades, Integer> cPoder = new TableColumn<>("Poder");
			TableColumn<PersonajePropiedades, Boolean> cSuperpoder = new TableColumn<>("Super Poder");
			TableColumn<PersonajePropiedades, Estrategia> cEstrategia = new TableColumn<>("Estrategia");
			
			tvPersonajes.getColumns().add(cNombre);
			tvPersonajes.getColumns().add(cPoder);
			tvPersonajes.getColumns().add(cSuperpoder);
			tvPersonajes.getColumns().add(cEstrategia);
			tvPersonajes.setEditable(true);
			tvPersonajes.setMinWidth(360);
			
			cNombre.setMinWidth(100);
			cNombre.setCellValueFactory(fila -> fila.getValue().nombreProperty());
			cNombre.setCellFactory(TextFieldTableCell.forTableColumn());
			cNombre.setOnEditCommit(e -> {
				int indice = PERSONAJES.indexOf(e.getRowValue());
				e.getRowValue().setNombre(e.getNewValue());
				PERSONAJES.set(indice, e.getRowValue());
				filaCambiada(e.getRowValue());
			});
			cPoder.setMinWidth(20);
			cPoder.setCellValueFactory(fila -> fila.getValue().poderProperty().asObject());
			cPoder.setCellFactory(fila -> new TextFieldTableCell<>(new ConvierteEnteroCadena()));
			cPoder.setOnEditCommit(e -> {
				int indice = PERSONAJES.indexOf(e.getRowValue());
				e.getRowValue().setPoder(e.getNewValue());
				PERSONAJES.set(indice, e.getRowValue());
				filaCambiada(e.getRowValue());
			});
			cSuperpoder.setMinWidth(40);
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
			cEstrategia.setCellValueFactory(new PropertyValueFactory<PersonajePropiedades, Estrategia>("estrategia"));
			cEstrategia.setCellFactory(estrategia -> new ChoiceBoxTableCell<PersonajePropiedades, Estrategia>(Estrategia.values()));
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
