package dictionary_master;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class MyField {
	
	public String name;
	public Object object;
	public String type;
	public boolean isCompared;
        
        private CheckBox checkbox;
        private TextField txt;
        private ChoiceBox choiceBox;
 
 
  public MyField(CheckBox checkBox,TextField txt,ChoiceBox choiceBox){
      this.choiceBox=choiceBox;
      this.checkbox=checkBox;
      this.txt=txt;
  }
	
	public MyField(String name,String type,boolean isCompared){
		this.name=name;
		this.type=type;
		this.isCompared=isCompared;
		
	}
        
          public void setAttributes(){
      name=txt.getText();
      type=choiceBox.getValue().toString();
      isCompared=checkbox.isSelected();
  }

}
