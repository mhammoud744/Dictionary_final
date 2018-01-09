

package dictionary_master;


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
        lyt1.setId("alert");
        Scene scene = new Scene(lyt1,700,150);
        scene.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm()); 
        window.setScene(scene);
        window.showAndWait();
        
    }
}
