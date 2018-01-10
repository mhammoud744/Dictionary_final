package dictionary_master;
public class Vbb implements Comparable<Vbb>{
int x;
double y;
String name;
String h;
 public String toString() {
return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(Vbb otherObj){
if(this.equals(otherObj))return 0;
return h.compareTo(otherObj.h);}
@Override
public boolean equals(Object otherObj){
Vbb other=(Vbb)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return h.equals(other.h);
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
