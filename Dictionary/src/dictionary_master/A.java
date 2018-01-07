package dictionary_master;
public class A implements Comparable<A>{
int d;
int s;
 public String toString() {
return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(A otherObj){
if(this.equals(otherObj))return 0;
return toInteger(d<otherObj.d)+toInteger(s<otherObj.s);}
@Override
public boolean equals(Object otherObj){
A other=(A)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return d==other.d &&s==other.s;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
