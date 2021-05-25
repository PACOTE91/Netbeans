package javafx.controles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonesActivacion extends Application {
	
	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox();
			raiz.setPadding(new Insets(40));
			raiz.setSpacing(10);
			
			Label lbElige = new Label("Elige los extras:");
			lbElige.setFont(Font.font(20));
			
			ToggleButton tbNavegador = new ToggleButton("Navegador");
			ToggleButton tbManosLibres = new ToggleButton("Manos libres");
			ToggleButton tbLunas = new ToggleButton("Lunas tintadas");
			
			HBox panelBotones = new HBox();
			panelBotones.setSpacing(10);
			panelBotones.getChildren().addAll(tbNavegador, tbManosLibres, tbLunas);
			
			raiz.getChildren().addAll(lbElige, panelBotones);
			
			Scene escena = new Scene(raiz, 420, 150);
			escenarioPrincipal.setTitle("Botones de activación");
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
