package dictionary_master;
public class X implements Comparable<X>{
int a;
 public String toString() {
return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
 public X(){
     System.out.println("X created");    
 }
 
@Override
public int compareTo(X otherObj){
if(this.equals(otherObj))return 0;
return toInteger(a<otherObj.a);}
@Override
public boolean equals(Object otherObj){
X other=(X)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return a==other.a;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
