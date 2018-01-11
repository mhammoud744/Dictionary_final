
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
  private TextField txt;
  private TextField t1;
  private ChoiceBox choiceBox;
  String label1,label2;
  private Label L1,L2;
  
  public MyField(CheckBox checkBox,TextField txt,ChoiceBox choiceBox){
      this.choiceBox=choiceBox;
      this.checkbox=checkBox;
      this.txt=txt;
  }
  public MyField(Label L1,Label L2,TextField t1){
      this.label1=L1.getText().toString();
      this.label2=L2.getText().toString();
      this.attValue=t1.getText().toString();;
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

}
