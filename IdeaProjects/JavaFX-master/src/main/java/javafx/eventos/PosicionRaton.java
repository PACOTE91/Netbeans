package javafx.eventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PosicionRaton extends Application {
	
	private Label lbPosX;
	private Label lbPosY;
	
	private static final String POS_X = "Posición X:";
	private static final String POS_Y = "Posición Y:";
	
	private void muestraValor(MouseEvent e) {
		lbPosX.setText(POS_X + e.getX());
		lbPosY.setText(POS_Y + e.getY());
	}
	
	private void limpiaValor() {
		lbPosX.setText(POS_X);
		lbPosY.setText(POS_Y);
	}

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox(30);
			raiz.setPadding(new Insets(20));
			raiz.setAlignment(Pos.CENTER);
			
			Pane panel = new Pane();
			panel.setMinSize(150, 150);
			panel.setMaxSize(150,  150);
			panel.setStyle("-fx-border-color: blue; "
					+ "-fx-border-radius: 5; "
					+ "-fx-background-color: #cce6ff;"
					+ "-fx-background-radius: 5");
			panel.setOnMouseMoved(e -> muestraValor(e));
			panel.setOnMouseExited(e -> limpiaValor());
			
			HBox hbValores = new HBox(10);
			hbValores.setAlignment(Pos.CENTER);
			lbPosX = new Label();
			lbPosX.setText(POS_X);
			lbPosY = new Label();
			lbPosY.setText(POS_Y);
			hbValores.getChildren().addAll(lbPosX, lbPosY);
			
			raiz.getChildren().addAll(panel, hbValores);
			
			Scene escena = new Scene(raiz, 350, 250);
			escenarioPrincipal.setTitle("Posición ratón");
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
