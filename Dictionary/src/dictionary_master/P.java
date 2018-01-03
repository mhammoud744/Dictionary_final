package dictionary_master;
public class P implements Comparable<P>{
String x;
int y;
 public String toString() {
   return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; 
 }
 
 
@Override
public int compareTo(P otherObj){
if(this.equals(otherObj))return 0;
return 1;
}


@Override
public boolean equals(Object otherObj){
P other=(P)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return x.equals(other.x) &&y==other.y;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
