package javafx.eventos;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.eventos.clases.PersonajePropiedades;
import javafx.eventos.clases.PersonajePropiedades.Estrategia;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TablaPersonajesPropiedadesPersonalizada extends Application {
	
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
			tvPersonajes.setEditable(true);
			
			cNombre.setMinWidth(100);
			cNombre.setCellValueFactory(fila -> fila.getValue().nombreProperty());
			cNombre.setCellFactory(TextFieldTableCell.forTableColumn());
			cNombre.setOnEditCommit(e -> System.out.println(e.getNewValue()));
			cPoder.setMinWidth(20);
			cPoder.setCellValueFactory(fila -> fila.getValue().poderProperty().asObject());
			cPoder.setCellFactory(fila -> new TextFieldTableCell<>(new ConvierteEnteroCadena()));
			cPoder.setOnEditCommit(e -> System.out.println(e.getNewValue()));
			cSuperpoder.setMinWidth(40);
			cSuperpoder.setCellValueFactory(fila -> {
				fila.getValue().superpoderProperty().addListener((observable, oldValue, newValue) -> {
					fila.getValue().setSuperpoder(newValue);
					System.out.println(newValue);
				});
				return fila.getValue().superpoderProperty();
			});
			cSuperpoder.setCellFactory(fila -> new CheckBoxTableCell<>());
			cEstrategia.setMinWidth(60);
			cEstrategia.setCellValueFactory(fila -> fila.getValue().estrategiaProperty());
			cEstrategia.setCellFactory(fila -> new ChoiceBoxTableCell<PersonajePropiedades, Estrategia>(Estrategia.values()));
			cEstrategia.setOnEditCommit(e -> System.out.println(e.getNewValue()));
			
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
