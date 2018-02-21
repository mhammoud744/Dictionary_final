
package dictionary_master;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MyField {
  String attName;
  String attType;
  String attValue;
  boolean isCompared;
  
  private CheckBox checkbox;
  private TextField txt,atValue;
  private TextField t1;
  private ChoiceBox choiceBox;
  private Label label1,label2;
  private Label L1,L2;
  
  public MyField(CheckBox checkBox,TextField txt,ChoiceBox choiceBox){
      this.choiceBox=choiceBox;
      this.checkbox=checkBox;
      this.txt=txt;
  }
  public MyField(Label Type,Label Name,TextField t1){
      this.label1=Type;
      this.label2=Name;
      this.atValue=t1;
  }
  
  public MyField(String name, String type, boolean isCompared) {
        this.attName = name;
        this.attType = type;
        this.isCompared = isCompared;

    }
  
  public void setAttributes(){
      attName=txt.getText();
      attType=choiceBox.getValue().toString();
      isCompared=checkbox.isSelected();
      
  }
  public void setCreatedObj(){
      attType=label1.getText().toString();
      attName=label2.getText().toString();
      attValue=atValue.getText().toString();
  }
  

}
