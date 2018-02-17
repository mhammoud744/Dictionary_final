
package dictionary_master;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class AddFrndEnemyController implements Initializable {
    
    
    ObservableList<String> objectsList = FXCollections.observableArrayList();
    ObservableList<String> objectsListNew = FXCollections.observableArrayList();

    
    @FXML
    RadioButton frnd;        
    @FXML
    RadioButton enemy;
    @FXML
    ToggleGroup  choice;
    @FXML
    ChoiceBox ObjChoiceBox1;
     @FXML
    ChoiceBox ObjChoiceBox2;
     ////////////////////////////////////////////////////////e5od mn lfile li b2albo objects
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileOperations.readFromFile(objectsList);
    // fill ObjChoiceBox
                objectsListNew.addAll(objectsList);
                objectsListNew.remove("None");
                System.out.println(objectsListNew);
                ObjChoiceBox1.setItems(objectsListNew);
                ObjChoiceBox1.getSelectionModel().selectFirst();
                ObjChoiceBox2.setItems(objectsListNew);
                ObjChoiceBox2.getSelectionModel().selectFirst();
       
    } 
    public void doneFunc(){
        if(choice.getSelectedToggle().equals(frnd))
            
             System.out.println(ObjChoiceBox1.getValue().toString()+" and "+ObjChoiceBox2.getValue().toString()+" are now friends");
        else
            System.out.println(ObjChoiceBox1.getValue().toString()+" and "+ObjChoiceBox2.getValue().toString()+" are now enemies");
        
        
            
    }
    
}
