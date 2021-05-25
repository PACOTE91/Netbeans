package javafx.panelesdiseno;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelBorde extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			BorderPane raiz = new BorderPane();
			VBox vbIzquierda = new VBox();
			VBox vbDerecha = new VBox();
			HBox hbArriba = new HBox();
			HBox hbAbajo = new HBox();
			
			Button btIzquierda = new Button("Izquierda (LEFT)");
			Button btDerecha = new Button("Derecha (RIGHT)");
			Button btArriba = new Button("Arriba (TOP)");
			Button btAbajo = new Button("Abajo (BOTTOM)");
			Button btCentro = new Button("Centro (CENTER)");
			
			vbIzquierda.getChildren().add(btIzquierda);
			vbIzquierda.setAlignment(Pos.CENTER);
			vbIzquierda.setStyle("-fx-background-color: #dc143c");
			vbDerecha.getChildren().add(btDerecha);
			vbDerecha.setAlignment(Pos.CENTER);
			vbDerecha.setStyle("-fx-background-color: #dc143c");
			hbArriba.getChildren().add(btArriba);
			hbArriba.setAlignment(Pos.CENTER);
			hbArriba.setStyle("-fx-background-color: #b6e7c9");
			hbAbajo.getChildren().add(btAbajo);
			hbAbajo.setAlignment(Pos.CENTER);
			hbAbajo.setStyle("-fx-background-color: #b6e7c9");
			
			raiz.setLeft(vbIzquierda);
			raiz.setRight(vbDerecha);
			raiz.setTop(hbArriba);
			raiz.setBottom(hbAbajo);
			raiz.setCenter(btCentro);
			
			Scene escena = new Scene(raiz, 500, 300);
			escenarioPrincipal.setTitle("Panel de borde");
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