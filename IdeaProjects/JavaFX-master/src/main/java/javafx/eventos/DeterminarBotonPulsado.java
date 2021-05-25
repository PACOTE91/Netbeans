package javafx.eventos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DeterminarBotonPulsado extends Application {
	
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Label etiqueta;
	
	private void botonPulsado(ActionEvent e) {
		if (e.getSource() == bt1)
			etiqueta.setText("Se ha pulsado el botón 1");
		else if (e.getSource() == bt2)
			etiqueta.setText("Se ha pulsado el botón 2");
		else if (e.getSource() == bt3)
			etiqueta.setText("Se ha pulsado el botón 3");
	}
	
	private void ponerSombra(MouseEvent e) {
		Button boton = (Button)e.getSource();
		boton.setEffect(new DropShadow());
	}
	
	private void quitarSombra(MouseEvent e) {
		Button boton = (Button)e.getSource();
		boton.setEffect(null);
	}

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox(20);
			raiz.setPadding(new Insets(10));
			raiz.setAlignment(Pos.CENTER);
			
			HBox hbBotones =new HBox(30);
			hbBotones.setPadding(new Insets(10));
			hbBotones.setAlignment(Pos.CENTER);
			
			Font tipoLetra = Font.font("Arial", 16);
			bt1 = new Button("Botón 1");
			bt1.setFont(tipoLetra);
			bt1.setOnAction(this::botonPulsado);
			bt1.setOnMouseEntered(this::ponerSombra);
			bt1.setOnMouseExited(this::quitarSombra);
			bt2 = new Button("Botón 2");
			bt2.setFont(tipoLetra);
			bt2.setOnAction(this::botonPulsado);
			bt2.setOnMouseEntered(this::ponerSombra);
			bt2.setOnMouseExited(this::quitarSombra);
			bt3 = new Button("Botón 3");
			bt3.setFont(tipoLetra);
			bt3.setOnAction(this::botonPulsado);
			bt3.setOnMouseEntered(this::ponerSombra);
			bt3.setOnMouseExited(this::quitarSombra);
			hbBotones.getChildren().addAll(bt1, bt2, bt3);
			
			etiqueta = new Label();
			etiqueta.setFont(Font.font("Arial", 24));
			
			raiz.getChildren().addAll(hbBotones, etiqueta);
			
			Scene escena = new Scene(raiz, 450, 150);
			escenarioPrincipal.setTitle("¿Qué botón se ha pulsado?");
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
