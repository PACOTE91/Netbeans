import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Vista.fxml"));
            primaryStage.setTitle("Concesionario");
            primaryStage.setScene(new Scene(root, 704, 713));
            primaryStage.show();

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }






    public static void main(String[] args) {
        launch(args);
    }
}
