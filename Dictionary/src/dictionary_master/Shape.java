package dictionary_master;

public class Shape implements Comparable<Shape>{

int length;

int width;

public Shape(int length,int width)

{

this.length=length;

this.width=width;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Shape otherObj){

if(this.equals(otherObj))return 0;

return toInteger(length<otherObj.length)+toInteger(width<otherObj.width);}

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

return length==other.length &&width==other.width;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;
hash=hash+this.length;
hash=hash+this.length;
hash=hash+this.width;
return hash;
}

}

