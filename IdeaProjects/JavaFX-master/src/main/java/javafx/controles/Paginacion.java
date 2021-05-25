package javafx.controles;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.recursos.LocalizadorRecursos;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Paginacion extends Application {
		
	private VBox creaPagina(int indice) {
		VBox raizPagina = new VBox(10);
		raizPagina.setPadding(new Insets(0, 0, 10, 0));
		if (indice == 0) {
			Image logo = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/logo-ies.png"), 200, 200, true, true);
			raizPagina.getChildren().add(new ImageView(logo));
		} else if (indice == 1) {
			Image logo = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/logo-ies2.png"), 200, 200, true, true);
			raizPagina.getChildren().add(new ImageView(logo));
		} else {
			raizPagina = null;
		}
		return raizPagina;
	}
	
	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox(10);
			raiz.setPadding(new Insets(20, 20, 20, 20));
			Pagination paginacion = new Pagination(2, 1);
			paginacion.setPageFactory(indicePagina -> creaPagina(indicePagina));
			
			raiz.getChildren().addAll(paginacion);
			
			Scene escena = new Scene(raiz, 240, 290);
			escenarioPrincipal.setTitle("Paginación");
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
