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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class frameController implements Initializable,ScreenControlable {
    private Prueba_ventanas mainApp;
    
    @FXML
    private Label label;
    @FXML private javafx.scene.control.Button button;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setMainApp(Prueba_ventanas mainApp){
        this.mainApp=mainApp;
    }
}
