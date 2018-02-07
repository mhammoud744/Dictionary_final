package dictionary_master;

public class Name implements Comparable<Name>{

String name;

public Name(String name)

{

this.name=name;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Name otherObj){

if(this.equals(otherObj))return 0;

return name.compareTo(otherObj.name);}

@Override

public boolean equals(Object otherObj){

Name other=(Name)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return name.equals(other.name);

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;
hash=hash+this.name.hashCode();
return hash;
}

}

