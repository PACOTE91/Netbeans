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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TablaPersonajesPersonalizada extends Application {
	
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
			tvPersonajes.setEditable(true);
			
			cNombre.setMinWidth(100);
			cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			cNombre.setCellFactory(TextFieldTableCell.forTableColumn());
			cNombre.setOnEditCommit(e -> System.out.println(e.getNewValue()));
			cPoder.setMinWidth(20);
			cPoder.setCellValueFactory(new PropertyValueFactory<>("poder"));
			cPoder.setCellFactory(fila -> new TextFieldTableCell<>(new ConvierteEnteroCadena()));
			cPoder.setOnEditCommit(e -> System.out.println(e.getNewValue()));
			cSuperpoder.setMinWidth(40);
			cSuperpoder.setCellValueFactory(fila -> {
				BooleanProperty superpoderProperty = new SimpleBooleanProperty(fila.getValue().isSuperpoder());
				superpoderProperty.addListener((observable, oldValue, newValue) -> {
					fila.getValue().setSuperpoder(newValue);
					System.out.println(newValue);
				});
				return superpoderProperty;
			});
			cSuperpoder.setCellFactory(fila -> new CheckBoxTableCell<>());
			cEstrategia.setMinWidth(60);
			cEstrategia.setCellValueFactory(new PropertyValueFactory<>("estrategia"));
			cEstrategia.setCellFactory(fila -> new ChoiceBoxTableCell<Personaje, Estrategia>(Estrategia.values()));
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
