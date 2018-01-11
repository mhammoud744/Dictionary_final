package dictionary_master;

public class Af implements Comparable<Af>{

int g;

public Af(int g)

{

this.g=g;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Af otherObj){

if(this.equals(otherObj))return 0;

return toInteger(g<otherObj.g);}

@Override

public boolean equals(Object otherObj){

Af other=(Af)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return g==other.g;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

}

