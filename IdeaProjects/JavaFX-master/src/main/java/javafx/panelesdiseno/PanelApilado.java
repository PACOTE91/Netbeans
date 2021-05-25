package javafx.panelesdiseno;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PanelApilado extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox();
			raiz.setAlignment(Pos.CENTER);
			
			StackPane spEmoji = new StackPane();
			Rectangle rectangulo = new Rectangle(100, 100);
			rectangulo.setFill(Color.web("#dc143c"));
			rectangulo.setStroke(Color.web("#b6e7c9"));
			rectangulo.setStrokeWidth(10);
			rectangulo.setArcHeight(40);
			rectangulo.setArcWidth(40);
			Label lbEmoji = new Label(";)");
			lbEmoji.setFont(new Font(60));
			spEmoji.getChildren().addAll(rectangulo, lbEmoji);
			InnerShadow is = new InnerShadow(10, Color.BLUE);
			DropShadow ds = new DropShadow(40, Color.DARKVIOLET);
			Light.Distant distancia = new Light.Distant();
			distancia.setColor(Color.LIGHTGRAY);
			distancia.setElevation(80);
			Lighting l = new Lighting(distancia);
			is.setInput(l);
			ds.setInput(is);
			spEmoji.setEffect(ds);
			
			raiz.getChildren().addAll(spEmoji);
			
			Scene escena = new Scene(raiz, 250, 250);
			escenarioPrincipal.setTitle("Panel apilado");
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