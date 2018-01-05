
package dictionary_master;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MyField {
  String attName;
  String attType;
  boolean isCompared;
  
  private CheckBox checkbox;
  private TextField txt;
  private ChoiceBox choiceBox;
  private Label L1,L2;
  
  public MyField(CheckBox checkBox,TextField txt,ChoiceBox choiceBox){
      this.choiceBox=choiceBox;
      this.checkbox=checkBox;
      this.txt=txt;
  }
  public MyField(Label L1,Label L2,TextField txt){
      this.L1=L1;
      this.L2=L2;
      this.txt=txt;
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
