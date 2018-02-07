package dictionary_master;

public class Point implements Comparable<Point>{

int x;

int y;

public Point(int x,int y)

{

this.x=x;

this.y=y;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Point otherObj){

if(this.equals(otherObj))return 0;

return toInteger(x<otherObj.x)+toInteger(y<otherObj.y);}

@Override

public boolean equals(Object otherObj){

Point other=(Point)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return x==other.x &&y==other.y;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;
hash=hash+this.x;
hash=hash+this.x;
hash=hash+this.y;
return hash;
}

}

