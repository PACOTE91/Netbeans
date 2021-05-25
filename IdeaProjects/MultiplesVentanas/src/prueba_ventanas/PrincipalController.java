/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_ventanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class PrincipalController implements Initializable, ScreenControlable {
    @FXML
    private Button btn_abrir;
    private Prueba_ventanas mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setMainApp(Prueba_ventanas mainApp){
        this.mainApp=mainApp;
    }
    
    @FXML
    private void abrirVentana(ActionEvent event) {
        mainApp.cargarVentana(Prueba_ventanas.ventana2);
    }
    
}
