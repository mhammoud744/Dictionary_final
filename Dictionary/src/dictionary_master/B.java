package dictionary_master;
public class B implements Comparable<B>{
int a;
int v;
 public String toString() {
return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(B otherObj){
if(this.equals(otherObj))return 0;
return toInteger(a<otherObj.a)+toInteger(v<otherObj.v);}
@Override
public boolean equals(Object otherObj){
B other=(B)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return a==other.a &&v==other.v;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
