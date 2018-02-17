
package dictionary_master;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class FXMLController implements Initializable {
    @FXML
    RadioButton frnd;        
    @FXML
    RadioButton enemy;
    @FXML
    ToggleGroup  choice;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    } 
    public void doneFunc(){
        if(choice.getSelectedToggle().equals(frnd))
             System.out.println("add frnd"); //add frnd
        else if(choice.getSelectedToggle().equals(enemy))
            System.out.println("add enemy"); //add enemy
        else
             System.out.println("Choose one of the above"); //no choice
        
            
    }
    
}
