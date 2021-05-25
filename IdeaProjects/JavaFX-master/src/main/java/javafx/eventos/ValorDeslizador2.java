package javafx.eventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValorDeslizador2 extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox(30);
			raiz.setPadding(new Insets(20));
			raiz.setAlignment(Pos.CENTER);
			
			Slider deslizador = new Slider(0, 100, 50);
			deslizador.setShowTickLabels(true);
			deslizador.setShowTickMarks(true);
			deslizador.setMajorTickUnit(50);
			deslizador.setMinorTickCount(4);
			
			HBox hbValores = new HBox(10);
			hbValores.setAlignment(Pos.CENTER);
			Label lbValor = new Label();
			lbValor.setText(50 + "");
			lbValor.textProperty().bind(deslizador.valueProperty().asString("%.2f"));
			ProgressBar pbValor = new ProgressBar(0.5);
			pbValor.progressProperty().bind(deslizador.valueProperty().divide(100));
			ProgressIndicator piValor = new ProgressIndicator(0.5);
			piValor.progressProperty().bind(deslizador.valueProperty().divide(100));
			hbValores.getChildren().addAll(lbValor, pbValor, piValor);
			
			raiz.getChildren().addAll(deslizador, hbValores);
			
			Scene escena = new Scene(raiz, 450, 150);
			escenarioPrincipal.setTitle("Valor deslizador");
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
