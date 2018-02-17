/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_master;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CreateClassController implements Initializable {
List array1P3 = new ArrayList();
List array2P3 = new ArrayList();
String inhClass;
ObservableList<String> obList1P3 = FXCollections.observableArrayList();
@FXML
TextField classNameP2;
@FXML
ChoiceBox choiceBoxP2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void nextForm(ActionEvent e) {
     String txt = classNameP2.getText();

                if (txt.matches("^[A-Z].*$") && !txt.contains(" ")) {
                    if (FileOperations.searchFile(txt)) {
                        Alert.display("", "Class name already exists ! choose another one");
                        classNameP2.setText("");
                    } else {
                        try {
                    Parent pr = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    Scene sce3 = new Scene(pr);
                    Stage app_stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                    app_stage.setScene(sce3);
                    app_stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

                        if (!array1P3.contains(classNameP2.getText())) {
                            array1P3.add(classNameP2.getText());
                            FileOperations.writeToFile(classNameP2.getText());
                            inhClass = choiceBoxP2.getValue().toString();
                            System.out.println(inhClass);
                            obList1P3.clear();
                            obList1P3.addAll(array1P3);
                            choiceBoxP2.getSelectionModel().selectFirst();
                            choiceBoxP2.setItems(obList1P3);
                        }

                        array2P3.addAll(array1P3);
                        array2P3.remove("None");
                    }
                } else {
                    Alert.display("", "Class name should start with a CAPITAL letter and can't contain white spaces");
                }
    }
    
}
