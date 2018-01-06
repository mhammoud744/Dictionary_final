package dictionary_master;


import dictionary_master.MyField;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPanel extends Application {
//Pane=P
    //variables 

    int flag = 0;
    int getNbOfAtt;
    String attName;
    String attType;
    boolean isEqual;
    String path = "C:/Users/Mostafa/Documents/NetBeansProjects/Dictionary_master/Dictionary/src/dictionary_master";
    //TextFields
    TextField classNameP2 = new TextField();
    TextField numOfAttribP3 = new TextField();
    //Labels
    Label attrLabelP3 = new Label();
    Label attrLabelP4 = new Label();
    Label attrtypeP4 = new Label();
    Label attrtypeP3 = new Label();
    Label attrEqualP3 = new Label();
    Label attrNameP3 = new Label();
    Label objTypeP4 = new Label();
    Label classLabelP2 = new Label();
    Label inheritsLabelP2 = new Label();
    //ChoiceBoxes
    ChoiceBox choiceBoxP4 = new ChoiceBox();
    ChoiceBox choiceBoxP2 = new ChoiceBox();
    //Panes gridPane.add(btn,column,row)
    BorderPane P3 = new BorderPane();
    BorderPane P1 = new BorderPane();
    BorderPane P4 = new BorderPane();
    BorderPane P2 = new BorderPane();
    GridPane gridP3 = new GridPane();
    GridPane gridP2 = new GridPane();
    GridPane gridP4 = new GridPane();
    //Stage
    Stage myStage;
    //ObservableLists and Lists
    ArrayList<MyField> field = new ArrayList();
    List array1P3 = new ArrayList();
    List array2P3 = new ArrayList();
    List classArrListP4 = new ArrayList();
    ObservableList<String> obList1P3 = FXCollections.observableArrayList();
    ObservableList<String> obList2P3 = FXCollections.observableArrayList();
    ObservableList<String> classObListP4 = FXCollections.observableArrayList();
    //HBox and Vbox
    HBox attrHbox = new HBox();
    HBox hbox1P3 = new HBox();
    HBox hboxP4 = new HBox();
    HBox hbox2P3 = new HBox();
    HBox hbox1P2 = new HBox();
    HBox hbox2P2 = new HBox();
    HBox hbox3P2 = new HBox();
    VBox vboxP2 = new VBox();
    VBox vboxP1 = new VBox();
    //Buttons
    Button finishBtnP3 = new Button();
    Button nextBtnP2 = new Button();
    Button okBtnP3 = new Button();
    Button createClassBtnP1 = new Button();
    Button createObjectBtnP1 = new Button();
    Button fillObjAttribP1 = new Button();

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, IllegalAccessException, InstantiationException, URISyntaxException, NoSuchFieldException {
        //Labels , TextBoxes , Buttons
        objTypeP4.setText("Object type : ");
        attrNameP3.setText("Name of attribute");
        attrEqualP3.setText("Use it for equal method ?");
        attrtypeP3.setText("Type of attribute ");
        attrLabelP3.setText("Number of attributes : ");
//        attrtypeP4.setText("Type");
//        attrLabelP4.setText("Name");
        classLabelP2.setText("Class name : ");
        inheritsLabelP2.setText("Inherits : ");
        nextBtnP2.setText("Next");
        okBtnP3.setText("Ok");
        finishBtnP3.setText("Finish");
        createClassBtnP1.setText("Create your own class");
        createObjectBtnP1.setText("Create an object");
        fillObjAttribP1.setText("Fill the attributes");
        //Hbox and Vbox
        hbox2P3.getChildren().add(finishBtnP3);
        hboxP4.getChildren().add(objTypeP4);
        hboxP4.getChildren().add(choiceBoxP4);
        hboxP4.getChildren().add(fillObjAttribP1);
        hbox2P3.setId("hid");
        vboxP1.getChildren().add(createClassBtnP1);
        vboxP1.getChildren().add(createObjectBtnP1);
        vboxP2.getChildren().add(hbox1P2);
        vboxP2.getChildren().add(hbox2P2);
        vboxP2.setId("vboxP2");
        hbox1P2.setId("hboxPadding");
        hbox3P2.getChildren().add(nextBtnP2);
        //ObservableLists and Lists
        readFromFile();
        array1P3.add("None");
        array1P3.addAll(classArrListP4);
        array2P3.add("int");
        array2P3.add("String");
        array2P3.add("double");
        array2P3.add("boolean");
        obList1P3.addAll(array1P3);
        //ChoiceBoxes
        choiceBoxP2.setItems(obList1P3);
        choiceBoxP2.getSelectionModel().selectFirst();
        //Panes
        P1.setCenter(vboxP1);
        P1.setPadding(new Insets(20, 20, 20, 20));
        P4.setTop(hboxP4);
        P4.setCenter(gridP4);
        P4.setPadding(new Insets(20, 20, 20, 20));
        P3.setCenter(gridP3);
        P3.setPadding(new Insets(20, 20, 20, 20));
        P3.setBottom(hbox2P3);
        P2.setPadding(new Insets(20, 20, 20, 20));
        P2.setCenter(gridP2);
        P2.setBottom(hbox3P2);
        gridP2.add(classLabelP2, 0, 0);
        gridP2.add(inheritsLabelP2, 0, 1);
        gridP2.add(classNameP2, 1, 0);
        gridP2.add(choiceBoxP2, 1, 1);
        /////////////////////////
        gridP3.add(attrLabelP3, 0, 0);
        gridP3.add(numOfAttribP3, 1, 0);
        gridP3.add(okBtnP3, 2, 0);
        gridP3.setHgap(20);
        gridP3.setVgap(20);
        gridP3.setPadding(new Insets(10, 10, 10, 10));
        gridP2.setHgap(30);
        gridP2.setVgap(30);
        gridP4.setPadding(new Insets(10, 10, 10, 10));
        gridP4.setHgap(30);
        gridP4.setVgap(30);
        gridP2.setPadding(new Insets(20, 20, 20, 20));
        //Stage and Scene
        myStage = primaryStage;
        Scene scene1 = new Scene(P1, 730, 700);
        primaryStage.setTitle("My dictionary");
        primaryStage.setScene(scene1);
        scene1.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());

        //Set Classes and Id's for style sheet design
        //Buttons and textfields
        createClassBtnP1.getStyleClass().add("btnStyle");
        createObjectBtnP1.getStyleClass().add("btnStyle");
        finishBtnP3.getStyleClass().add("btnStyle");
        okBtnP3.getStyleClass().add("btnStyle");
        nextBtnP2.getStyleClass().add("btnStyle");
        choiceBoxP2.getStyleClass().add("choiceBoxStyle");
        choiceBoxP4.getStyleClass().add("btnStyle");
        classNameP2.getStyleClass().add("txtStyle");
        //Panes
        P1.getStyleClass().add("background");
        P2.getStyleClass().add("backgroundnew");
        P3.getStyleClass().add("background");
        P4.getStyleClass().add("background");

        //createClassBtnP1 button on click
        createClassBtnP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Scene scene2 = new Scene(P2, 730, 700);
                scene2.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                myStage.setScene(scene2);
            }
        });

        //createObjectBtnP1 button on click
        createObjectBtnP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Scene scene3 = new Scene(P4, 730, 700);
                scene3.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                myStage.setScene(scene3);
                readFromFile();
                classObListP4.addAll(array1P3);
                choiceBoxP4.getSelectionModel().selectFirst();
                choiceBoxP4.setItems(classObListP4);
                System.out.println("this is all");
            }
        });

        //fillObjAttribP1 button on click
        fillObjAttribP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //   P4.setCenter();

//                getNbOfAtt = Integer.parseInt(numOfAttribP3.getText());
//                gridP4.add(attrtypeP4, 0, 1);
//                gridP4.add(attrNameP4, 1, 1);
//                gridP4.add(attrEqualP3, 2, 1);
                System.out.println("gdg " + choiceBoxP4.getValue());

                Code c = new Code();
                NbFields f = new NbFields();
                Field hold[] = f.getFieldss(c);
                int i = 0;
                for (Field field1 : hold) {
                    TextField nAttr = new TextField();
                    Label type = new Label();
                    Label name = new Label();
                    type.setText(field1.getName());
                    name.setText(field1.getType().getName());
                    gridP4.add(type, 0, i + 2);
                    gridP4.add(name, 1, i + 2);
                    gridP4.add(nAttr, 2, i + 2);
                    field.add(new MyField(type, name, nAttr));
                    i++;
                }
            }
        });

        //Next button on click
        nextBtnP2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String txt = classNameP2.getText();

                if (txt.matches("^[A-Z].*$") && !txt.contains(" ")) {
                    if (searchFile(txt)) {
                        Alert.display("", "Class name already exists ! choose another one");
                        classNameP2.setText("");
                    } else {
                        Scene scene2 = new Scene(P3, 730, 700);
                        scene2.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                        myStage.setScene(scene2);

                        if (!array1P3.contains(classNameP2.getText())) {
                            array1P3.add(classNameP2.getText());
                            writeToFile(classNameP2.getText());
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
        });

        //okBtnP3 button on click
        okBtnP3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    getNbOfAtt = Integer.parseInt(numOfAttribP3.getText());
                    gridP3.add(attrtypeP3, 0, 1);
                    gridP3.add(attrNameP3, 1, 1);
                    gridP3.add(attrEqualP3, 2, 1);
                    if (getNbOfAtt >= 1 && getNbOfAtt <= 10) {
                        obList2P3.clear();
                        obList2P3.addAll(array2P3);
                        for (int i = 0; i < getNbOfAtt; i++) {
                            ChoiceBox choiceBoxP3 = new ChoiceBox();
                            TextField nAttr = new TextField();
                            CheckBox cAttr = new CheckBox();
                            choiceBoxP3.setItems(obList2P3);
                            choiceBoxP3.getSelectionModel().selectFirst();
                            gridP3.add(choiceBoxP3, 0, i + 2);
                            gridP3.add(nAttr, 1, i + 2);
                            gridP3.add(cAttr, 2, i + 2);
                            field.add(new MyField(cAttr, nAttr, choiceBoxP3));
                        }

                        okBtnP3.setDisable(true);

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

        //Create class button on click
        finishBtnP3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (MyField f : (ArrayList<MyField>) field) {
                    f.setAttributes();
                    if (!f.attName.isEmpty()) {
                        System.out.println("name " + f.attName + " type " + f.attType + " checked " + f.isCompared);
                        flag = 1;
                    } else {
                        Alert.display("", "Please fill the name of attributes");
                        flag = 0;
                    }
                }
                if (flag == 1) {

                    try {
                        new JavaDynamicClassCreation(classNameP2.getText(), field).dynamicClassCreation();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchFieldException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

        primaryStage.show();
    }

    public List readFromFile() {
        File file = new File("C:/Users/Mostafa/Documents/NetBeansProjects/Dictionary_master/Dictionary/src/dictionary_master/classes.txt");
        Scanner readfile = null;
        try {
            readfile = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (readfile.hasNext()) {
            String str = readfile.nextLine();
            classArrListP4.add(str);
        }
        readfile.close();
        return classArrListP4;
    }

    public boolean searchFile(String s) {
        List<String> searchList = readFromFile();
        for (String temp : searchList) {
            if (temp.equals(s)) {
                System.out.println("class name exists");
                return true;

            }
        }
        return false;
    }

    public void writeToFile(String s) {
        FileWriter classesFile = null;
        try {
            classesFile = new FileWriter("C:/Users/Mostafa/Documents/NetBeansProjects/Dictionary_master/Dictionary/src/dictionary_master/classes.txt", true);
        } catch (IOException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bf = new BufferedWriter(classesFile);
        PrintWriter pw = new PrintWriter(bf);
        pw.println(s);
        System.out.println("name is added to the file");
        pw.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
