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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainPanel extends Application {
  int flag=0;
    String attName;
    String attType;
    boolean isEqual;
    ArrayList<MyField> field = new ArrayList();
    List array = new ArrayList();
    List array1 = new ArrayList();
    TextField t = new TextField();
    TextField nbOfAttrib = new TextField();
    int getNbOfAtt;
    ChoiceBox c = new ChoiceBox();
    Label nbAttributes = new Label();
    Label type = new Label();
    Label equal = new Label();
    Label attrName = new Label();
    BorderPane attributes = new BorderPane();
    BorderPane objects = new BorderPane();
    HBox h3 = new HBox();
    Label objType = new Label();
    ChoiceBox c2 = new ChoiceBox();
    Stage myStage;
    Scene scene;
    ObservableList<String> l = FXCollections.observableArrayList();
    ObservableList<String> l1 = FXCollections.observableArrayList();
    HBox attrHbox = new HBox();
    HBox h1 = new HBox(); HBox h2 = new HBox(); VBox v3 = new VBox(); Pane p = new Pane(); GridPane g = new GridPane(); 
    File f = new File("C:\\Users\\user\\Documents\\NetBeansProjects\\dictionary_master\\src\\classes");
    Button createClass = new Button();
    Button createObj = new Button();
    
    
    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, IllegalAccessException, InstantiationException, URISyntaxException, NoSuchFieldException {
        new JavaDynamicClassCreation().dynamicClassCreation();
        objType.setText("Object type : ");
        h3.getChildren().add(objType);
        h3.getChildren().add(c2);
        objects.setTop(h3);
        h2.getChildren().add(createClass);
        h2.getChildren().add(createObj);
        h2.getChildren().add(createObj);
        createObj.setText("Create Object");
        objects.setPadding(new Insets(20, 20, 20, 20));
        createObj.setVisible(false);
        myStage = primaryStage;
        array.add("None");
        array1.add("int");
        array1.add("String");
        array1.add("double");
        
        array1.add("boolean");
        l.addAll(array);
        createClass.setText("Create class");
        attrName.setText("Name of attribute");
        equal.setText("Use it for equal method ?");
        Button nxt = new Button();
        Button ok = new Button();
        
        BorderPane root = new BorderPane();
        type.setText("Type of attribute ");
        nbAttributes.setText("Number of attributes : ");
        c.setItems(l);
        c.getSelectionModel().selectFirst();
        VBox v1 = new VBox();
        VBox v2 = new VBox();
        HBox h = new HBox();
        Label name = new Label();
        nxt.setText("Next");
        ok.setText("Ok");
        
        v2.getChildren().add(t);
        v2.getChildren().add(c);
        h.getChildren().add(nbAttributes);
        h.getChildren().add(nbOfAttrib);
        h.getChildren().add(ok);
        attributes.setTop(h);
        attributes.setPadding(new Insets(20, 20, 20, 20));
        attributes.setBottom(h2);
        name.setText("Class name : ");
        
        
        Label inh = new Label();
        inh.setText("Inherits : ");
        v1.getChildren().add(name);
        v1.getChildren().add(inh);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setLeft(v1);
        root.setRight(v2);
        root.setBottom(nxt);
        g.setHgap(20);
        g.setVgap(20);
        g.setPadding(new Insets(10, 10, 10, 10));
        Scene scene1 = new Scene(root, 550, 550);
        primaryStage.setTitle("My dictionary");
        primaryStage.setScene(scene1);

        nxt.setOnAction(new EventHandler<ActionEvent>() {    
            @Override
            public void handle(ActionEvent e) {
                String txt = t.getText();
                if (txt.matches("^[A-Z].*$") && !txt.contains(" ")) {
                    Scene scene2 = new Scene(attributes, 550, 550);
                    myStage.setScene(scene2);

                    if (!array.contains(t.getText())) {
                        array.add(t.getText());
                        l.clear();
                        l.addAll(array);
                        c.getSelectionModel().selectFirst();
                        c.setItems(l);
                    }
                    
                    
                    array1.addAll(array);
                    array1.remove("None");
                } else {

                    Alert.display("", "Class name should start with a CAPITAL letter and can't contain white spaces");
                }
            }
        });
        
        
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                g.getChildren().clear();
                g.add(type, 0, 0);
                g.add(attrName, 1, 0);
                g.add(equal, 2, 0);
                try {
                    getNbOfAtt = Integer.parseInt(nbOfAttrib.getText());
                    if (getNbOfAtt >= 1 && getNbOfAtt <= 10) {
                        l1.clear();
                        l1.addAll(array1);
                        for (int i = 0; i < getNbOfAtt; i++) {
                            ChoiceBox c1 = new ChoiceBox();
                            TextField nAttr = new TextField();
                            CheckBox cAttr = new CheckBox();
                            c1.setItems(l1);
                            c1.getSelectionModel().selectFirst();
                            g.add(c1, 0, i + 1);
                            g.add(nAttr, 1, i + 1);
                            g.add(cAttr, 2, i + 1);
                            field.add(new MyField(cAttr,nAttr,c1));
                        }
                       
                        attributes.setCenter(g);
                        
                              } else {//alert
                        //nbAttributes.setVisible(false);
                        Alert.display("", "Number of attributes should be between 1 & 10");
                    }
                } catch (NumberFormatException e1) {
                    //alert
                    Alert.display("", "Please enter an integer between 1 & 10");

                }

            }
        });
        
        createClass.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               for(MyField f:(ArrayList<MyField>)field){
                   f.setAttributes();
                   if(!f.name.isEmpty()){
                   System.out.println("name "+f.name+" type "+f.type+"checked"+f.isCompared);
                   flag=1;
               }
                   else{
                  Alert.display("", "Please fill the name of attributes");
                  flag=0;
                   }
               }
               if(flag==1){
            new JavaDynamicClassCreation(name.getText(),field);
            createObj.setVisible(true);}
            }
        });
         createObj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
              Scene scene2 = new Scene(objects, 550, 550);
                    myStage.setScene(scene2);
            }
        });
        primaryStage.show();
    }
    
    
        /*  public String readFromFile(File f){
     try (BufferedReader reader = new BufferedReader(new FileReader(".\classes.txt"))) {
     String line;
     if((line = reader.readLine()) != null)
     return line;
     } catch (IOException e) {
     e.printStackTrace();
     }
     
     }
     public void writeToFile(File f, String s){
       
     if(f.exists()){
     try {
     BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
     bw.append("line 5 ");
     bw.flush();
     bw.close();

     } catch (IOException e) {
     e.printStackTrace();
     }
     }
     else{
     System.out.println(f.getAbsolutePath() + " does not exists");
     }
       
     }*/
    public static void main(String[] args) {
        launch(args);
    }

}
                        
                        
                        
                        
                        
                    
                    
                    
        
        
    


