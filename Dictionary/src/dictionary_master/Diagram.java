package dictionary_master;

public class Diagram implements Comparable<Diagram>{

int a;

public Diagram(int a)

{

this.a=a;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Diagram otherObj){

if(this.equals(otherObj))return 0;

return toInteger(a<otherObj.a);}

@Override

public boolean equals(Object otherObj){

Diagram other=(Diagram)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return a==other.a;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

}

