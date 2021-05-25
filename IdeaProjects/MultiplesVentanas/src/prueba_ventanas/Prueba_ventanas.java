/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_ventanas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class Prueba_ventanas extends Application {
    private Stage mainStage;
    private Group mainScene;
    
    public static String marco ="frame.fxml";
    public static String ventana1 = "principal.fxml";
    public static String ventana2 = "secundaria.fxml";
    
    @Override
    public void start(Stage stage) throws Exception {
        Group root= new Group();
        this.mainStage=stage;
        this.mainScene=root;
        this.cargarVentana(ventana1);
        this.cargarVentana(marco);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    public Stage getMainStage(){
        return mainStage;
    }
  
    public boolean cargarVentana(String archivoFXML){
            try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(archivoFXML));
            AnchorPane screen = (AnchorPane) myLoader.load();
                if (marco.equals(archivoFXML) || mainScene.getChildren().isEmpty()) {
                    mainScene.getChildren().add(screen);
                }
                else{
                    mainScene.getChildren().remove(0);
                    mainScene.getChildren().add(0,screen);
                } 
            ScreenControlable myScreenControler = ((ScreenControlable) myLoader.getController());
            myScreenControler.setMainApp(this);
            //myScreenControler.setScreenParent(this);
            //addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}