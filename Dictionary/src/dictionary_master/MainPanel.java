package dictionary_master;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
    String choiceBoxClassName;
    String attType;
    boolean isEqual;
    String inhClass;
    //TextFields
    TextField classNameP2 = new TextField();
    TextField numOfAttribP3 = new TextField();
    //Labels
    Label compareResultP5 = new Label();
    Label compareLabelP5 = new Label();
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
    ChoiceBox choiceBox1P5 = new ChoiceBox();
    ChoiceBox choiceBox2P5 = new ChoiceBox();
    //Panes gridPane.add(btn,column,row)
    BorderPane P3 = new BorderPane();
    BorderPane P1 = new BorderPane();
    BorderPane P4 = new BorderPane();
    BorderPane P2 = new BorderPane();
    BorderPane P5 = new BorderPane();
    GridPane gridP1 = new GridPane();
    GridPane gridP3 = new GridPane();
    GridPane gridP2 = new GridPane();
    GridPane gridP4 = new GridPane();
    GridPane gridP5 = new GridPane();
    //Stage
    Stage myStage;
    public static Stage myStage1;
    public static Scene scene34;
    //ObservableLists and Lists
    ArrayList<MyField> field = new ArrayList();
    List array1P3 = new ArrayList();
    List array2P3 = new ArrayList();
    List classArrListP4 = new ArrayList();
    List createObjArrListP4 = new ArrayList();
    ObservableList<String> obList1P3 = FXCollections.observableArrayList();
    ObservableList<String> obList2P3 = FXCollections.observableArrayList();
    ObservableList<String> classObListP4 = FXCollections.observableArrayList();
    ObservableList<String> compareObListP5 = FXCollections.observableArrayList();
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
    Button finishBtnP4 = new Button();
    Button nextBtnP2 = new Button();
    Button okBtnP3 = new Button();
    Button createClassBtnP1 = new Button();
    Button createObjectBtnP1 = new Button();
    Button compareObjectsBtnP1 = new Button();
    Button fillObjAttribP4 = new Button();
    Button compareBtnP5 = new Button();
    Button createObjP3 = new Button();
    Button compareObjP3 = new Button();
Button addFrndEnemyP1 = new Button();

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, IllegalAccessException, InstantiationException, URISyntaxException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //Labels , TextBoxes , Buttons
        createObjP3.setText("Create Object");
        compareObjP3.setText("Compare Objects");
        compareResultP5.setText("");
        compareLabelP5.setText("Choose 2 objects to compare them :");
        compareBtnP5.setText("Compare now");
        objTypeP4.setText("Object type : ");
        attrNameP3.setText("Attribute name");
        attrEqualP3.setText("Check for equal method");
        attrtypeP3.setText("Attribute type");
        attrLabelP3.setText("                ");
        finishBtnP4.setDisable(true);
        addFrndEnemyP1.setText("Add frnd/enemy");/////////
        numOfAttribP3.setFocusTraversable(false);
        numOfAttribP3.setPromptText("Number of attributes");
        classLabelP2.setText("Class name : ");
        inheritsLabelP2.setText("Inherits : ");
        nextBtnP2.setText("Next");
        okBtnP3.setText("Ok");
        finishBtnP3.setText("Finish");
        finishBtnP4.setText("Finish");
        createClassBtnP1.setText("Create your own class");
        createObjectBtnP1.setText("   Create an object  ");
        compareObjectsBtnP1.setText("  Compare 2 objects  ");
        fillObjAttribP4.setText("Fill the attributes");
        //Hbox and Vbox
        hbox2P3.getChildren().add(finishBtnP3);
        hbox2P3.getChildren().add(createObjP3);
        hbox2P3.getChildren().add(compareObjP3);
        hboxP4.getChildren().add(objTypeP4);
        hboxP4.getChildren().add(choiceBoxP4);
        hboxP4.getChildren().add(fillObjAttribP4);
        hbox2P3.setId("hid");
        vboxP1.getChildren().add(createClassBtnP1);
        vboxP1.getChildren().add(createObjectBtnP1);
        vboxP2.getChildren().add(hbox1P2);
        vboxP2.getChildren().add(hbox2P2);
        vboxP2.setId("vboxP2");
        hbox1P2.setId("hboxPadding");
        hbox3P2.getChildren().add(nextBtnP2);
        hboxP4.setPadding(new Insets(20, 20, 20, 20));
        //ObservableLists and Lists
        FileOperations.readFromFile(classArrListP4);
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
        P1.setCenter(gridP1);
        P1.setPadding(new Insets(20, 20, 20, 20));
        P4.setTop(hboxP4);
        P4.setCenter(gridP4);
        P4.setBottom(finishBtnP4);
        P4.setPadding(new Insets(20, 20, 20, 20));
        P3.setCenter(gridP3);
        P3.setPadding(new Insets(20, 20, 20, 20));
        P3.setBottom(hbox2P3);
        P2.setPadding(new Insets(20, 20, 20, 20));
        P2.setCenter(gridP2);
        P2.setBottom(hbox3P2);
        P5.setCenter(gridP5);
        P5.setPadding(new Insets(20, 20, 20, 125));
        gridP2.add(classLabelP2, 4, 4);
        gridP2.add(classNameP2, 5, 4);
        gridP2.add(inheritsLabelP2, 4, 6);
        gridP2.add(choiceBoxP2, 5, 6);
        /////////////////////////
        gridP1.add(createClassBtnP1, 7, 3);
        gridP1.add(createObjectBtnP1, 7, 5);
        gridP1.add(compareObjectsBtnP1, 7, 4);
        gridP1.add(addFrndEnemyP1, 7, 6);
        gridP3.add(attrLabelP3, 0, 0);
        gridP3.add(numOfAttribP3, 1, 0);
        gridP3.add(okBtnP3, 2, 0);
        gridP3.setHgap(10);
        gridP3.setVgap(10);
        gridP1.setPadding(new Insets(30, 30, 30, 30));
        gridP3.setPadding(new Insets(10, 10, 10, 10));
        gridP2.setHgap(30);
        gridP2.setVgap(30);
        gridP4.setPadding(new Insets(10, 10, 10, 10));
        gridP4.setHgap(30);
        gridP4.setVgap(30);
        gridP1.setHgap(30);
        gridP1.setVgap(30);
        gridP2.setPadding(new Insets(20, 20, 20, 20));
        gridP5.add(compareLabelP5, 0, 0);
        gridP5.add(choiceBox1P5, 0, 3);
        gridP5.add(choiceBox2P5, 1, 3);
        gridP5.add(compareBtnP5, 0, 30);
        gridP5.add(compareResultP5, 1, 30);
        gridP5.setHgap(10);
        gridP5.setVgap(10);
        gridP5.setPadding(new Insets(20, 20, 20, 20));
        //Stage and Scene
        myStage = primaryStage;
        Scene scene1 = new Scene(P1, 740, 500);
        scene34 = scene1;
        primaryStage.setTitle("Netbeans");
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
        choiceBoxP4.getStyleClass().add("choiceBoxStyle");
        choiceBox1P5.getStyleClass().add("choiceBoxStyle");
        choiceBox2P5.getStyleClass().add("choiceBoxStyle");
        finishBtnP4.getStyleClass().add("btnStyle");
        fillObjAttribP4.getStyleClass().add("btnStyle");
        compareObjectsBtnP1.getStyleClass().add("btnStyle");
        compareBtnP5.getStyleClass().add("btnStyle");
        createObjP3.getStyleClass().add("btnStyle");
        compareObjP3.getStyleClass().add("btnStyle");
        classNameP2.setPrefWidth(100);
        //Panes
        P1.getStyleClass().add("background");
        P2.getStyleClass().add("background");
        P3.getStyleClass().add("background");
        P4.getStyleClass().add("background");
        P5.getStyleClass().add("background");

        //createClassBtnP1 button on click
        createClassBtnP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                  try {
                    Parent pr = FXMLLoader.load(getClass().getResource("createClass.fxml"));
                    Scene sce3 = new Scene(pr);
                    Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    app_stage.setScene(sce3);
                    app_stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

               /* Scene scene2 = new Scene(P2, 740, 500);
                scene2.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                myStage.setScene(scene2);*/
            }
        });
        
        //addFrndEnemyP1 Btn
         addFrndEnemyP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                try {
                    Parent pr = FXMLLoader.load(getClass().getResource("addFrndEnemy.fxml"));
                    Scene sce3 = new Scene(pr);
                    Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    app_stage.setScene(sce3);
                    app_stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        //createObjP3 button on click
        createObjP3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Scene scene3 = new Scene(P4, 740, 500);
                scene3.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                myStage.setScene(scene3);
                FileOperations.readFromFile(classArrListP4);
                classObListP4.addAll(array1P3);
                choiceBoxP4.getSelectionModel().selectFirst();
                choiceBoxP4.setItems(classObListP4);
                System.out.println("this is all");
            }
        });

        //compareObjP3 button on click
        compareObjP3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Scene scene2 = new Scene(P5, 740, 500);
                scene2.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                myStage.setScene(scene2);
                compareObListP5.addAll(obList1P3);
                compareObListP5.remove("None");
                System.out.println(compareObListP5);
                choiceBox1P5.setItems(compareObListP5);
                choiceBox1P5.getStyleClass().add("choiceBoxStyle");
                choiceBox2P5.setItems(compareObListP5);
                choiceBox2P5.getStyleClass().add("choiceBoxStyle");
            }
        });

        //createObjectBtnP1 button on click
        createObjectBtnP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Scene scene3 = new Scene(P4, 740, 500);
                scene3.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                myStage.setScene(scene3);
                FileOperations.readFromFile(classArrListP4);
                classObListP4.addAll(array1P3);
                choiceBoxP4.getSelectionModel().selectFirst();
                choiceBoxP4.setItems(classObListP4);
                System.out.println("this is all");
            }
        });

        //compareObjectsBtnP1 button on click
        compareObjectsBtnP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Scene scene2 = new Scene(P5, 740, 500);
                scene2.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                myStage.setScene(scene2);
                compareObListP5.addAll(obList1P3);
                compareObListP5.remove("None");
                System.out.println(compareObListP5);
                choiceBox1P5.setItems(compareObListP5);
                choiceBox1P5.getStyleClass().add("choiceBoxStyle");
                choiceBox2P5.setItems(compareObListP5);
                choiceBox2P5.getStyleClass().add("choiceBoxStyle");
            }

        });

        //compareBtnP5 button on click
        compareBtnP5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    System.out.println(choiceBox1P5.getValue().toString());
                    System.out.println(choiceBox2P5.getValue().toString());

                    if (choiceBox1P5.getValue().toString().compareTo(choiceBox2P5.getValue().toString()) != 0) {
                        compareResultP5.setText("Not equal and not compatible");
                    } else {
                        ClassLoader loader1 = new ClassLoader(choiceBox1P5.getValue().toString());
                        ClassLoader loader2 = new ClassLoader(choiceBox2P5.getValue().toString());
                        //c1=choiceBox1P5.getValue().toString();
                        //c2=choiceBox2P5.getValue().toString();
                        //if c1 not super of c2 and c2 not super of c1 --> alert
                        //else c1.compare(c2);

                        Object o1 = new ClassLoader(choiceBox1P5.getValue().toString()).createInstance(1, 2);
                        Object o2 = new ClassLoader(choiceBox2P5.getValue().toString()).createInstance(1, 2);

                        Method method = new ClassLoader(choiceBox1P5.getValue().toString()).getCompareToMethod();
                        int result = (int) method.invoke(o1, o2);

                        if (result == 0) {
                            compareResultP5.setText("They are equal");
                        } else {
                            compareResultP5.setText("They are not equal");
                        }
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        //finishBtnP4 button on click
        finishBtnP4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for (MyField f : (ArrayList<MyField>) field) {
                    f.setCreatedObj();
                    if (f.attValue.isEmpty()) {
                        Alert.display("", "Please fill the Value of attributes");
                    } else {
                        System.out.println("zabateeeeeeet" + f.attValue);//ma 3m ye5od l value l hon
                        choiceBoxClassName = choiceBoxP4.getValue().toString();
                        Class c = null;
                        try {
                            c = Class.forName("dictionary_master." + choiceBoxClassName);//package.esemlclass
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ArrayList<Class<?>> objAttributesp4 = new ArrayList<>();
                        Field[] f2 = c.getFields();//get fields of class
                        for (Field element : f2) {
                            System.out.println(element.getType());
                            objAttributesp4.add(element.getType());
                        }
                        Constructor<?> cons;

                        try {
                            ArrayList<Object> objValues = new ArrayList<>();
                            cons = c.getConstructor((Class[]) objAttributesp4.toArray());
                            for (MyField ff : field) {
                                String fieldType = ff.attType;
                                Object o = null;

                                if (fieldType == "int") {
                                    o = Integer.parseInt(ff.attValue);
                                }
                                if (fieldType == "double") {
                                    o = Double.parseDouble(ff.attValue);
                                }
                                if (fieldType == "boolean") {
                                    o = Boolean.parseBoolean(ff.attValue);
                                }

                                objValues.add(o);
                            }
                            Object oNew = cons.newInstance(objValues.toArray());
                            System.out.println(oNew.toString());
                            //  cons.newInstance();
                        } catch (NoSuchMethodException ex) {
                            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SecurityException ex) {
                            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalArgumentException ex) {
                            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvocationTargetException ex) {
                            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //constructor bdo bs l values ka Array of objects
                        //y3ni eza int 55  bdo ykon Object o=new Ineteger(55);
                    }
                }
                System.out.println("attributes are saved");

            }
        });

        //fillObjAttribP4 button on click
        fillObjAttribP4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("gdg " + choiceBoxP4.getValue());
                FileOperations.readCreatedFile(choiceBoxP4.getValue().toString(), createObjArrListP4);
                for (int i = 0, j = 0; i < createObjArrListP4.size(); i++, j++) {
                    TextField nAttr = new TextField();
                    Label type = new Label();
                    Label name = new Label();
                    System.out.println(createObjArrListP4);
                    type.setText(createObjArrListP4.get(i).toString());
                    System.out.println(createObjArrListP4.get(i).toString());
                    //name.setText(createObjArrListP4.get(i + 1).toString());
                    gridP4.add(type, 0, j + 2);
                    gridP4.add(name, 1, j + 2);
                    gridP4.add(nAttr, 2, j + 2);
                    field.add(new MyField(type, name, nAttr));
                }
                finishBtnP4.setDisable(false);
            }
        });

        //Next button on click
        nextBtnP2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String txt = classNameP2.getText();

                if (txt.matches("^[A-Z].*$") && !txt.contains(" ")) {
                    if (FileOperations.searchFile(txt)) {
                        Alert.display("", "Class name already exists ! choose another one");
                        classNameP2.setText("");
                    } else {
                        Scene scene2 = new Scene(P3, 740, 500);
                        scene2.getStylesheets().add(MainPanel.class.getResource("myStyle1.css").toExternalForm());
                        myStage.setScene(scene2);

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
                    if (getNbOfAtt >= 1 && getNbOfAtt <= 5) {
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
                            choiceBoxP3.getStyleClass().add("choiceBoxStyle");
                        }
                        okBtnP3.setDisable(true);

                    } else {//alert
                        //nbAttributes.setVisible(false);
                        Alert.display("", "Number of attributes should be between 1 & 5");
                    }

                } catch (NumberFormatException e1) {
                    //alert
                    Alert.display("", "Please enter an integer between 1 & 5");
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
                    //  System.out.println("flag = " + flag + " " + inhClass);
                    try {
                        new JavaDynamicClassCreation(classNameP2.getText(), field, inhClass).dynamicClassCreation();
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
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                try {
                    FileOperations.createFile(field, classNameP2.getText());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
