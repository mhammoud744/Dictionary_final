package dictionary_master;

public class Shape implements Comparable<Shape>{

int vertices;

double area;

public Shape(int vertices,double area)

{

this.vertices=vertices;

this.area=area;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Shape otherObj){

if(this.equals(otherObj))return 0;

return toInteger(area<otherObj.area);}

@Override

public boolean equals(Object otherObj){

Shape other=(Shape)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return area==other.area;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

}

