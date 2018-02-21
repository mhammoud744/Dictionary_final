package dictionary_master;

public class Car implements Comparable<Car>{

String x;

boolean y;

public Car(String x,boolean y)

{

this.x=x;

this.y=y;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Car otherObj){

if(this.equals(otherObj))return 0;

return x.compareTo(otherObj.x);}

@Override

public boolean equals(Object otherObj){

Car other=(Car)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return x.equals(other.x);

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

}

