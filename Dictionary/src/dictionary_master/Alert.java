/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_master;

/**
 *
 * @author HP
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

class Alert {
 
    public static void display(String titile , String msg){
        final Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        String title = "Attention !!";
        window.setTitle(title);
        window.setMinWidth(250);
        Label lbl1 = new Label();
        lbl1.setText(msg);
        Button closebutton= new Button();
        closebutton.setText("close");
        closebutton.setOnAction
        (new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                window.close();
            }
        });
       
       
        VBox lyt1 = new VBox(20);
        lyt1.getChildren().addAll(lbl1 , closebutton);
        lyt1.setAlignment(Pos.CENTER);
        Scene scene = new Scene(lyt1,500,150,Color.AQUA);
        window.setScene(scene);
        window.showAndWait();
       
    }
}
