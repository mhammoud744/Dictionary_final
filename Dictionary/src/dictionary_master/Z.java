package dictionary_master;
public class Z implements Comparable<Z>{
int a;
double b;
 public String toString() {
return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(Z otherObj){
if(this.equals(otherObj))return 0;
return toInteger(a<otherObj.a)+toInteger(b<otherObj.b);}
@Override
public boolean equals(Object otherObj){
Z other=(Z)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return a==other.a &&b==other.b;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
