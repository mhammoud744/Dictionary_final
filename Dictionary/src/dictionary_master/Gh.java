package dictionary_master;
public class Gh implements Comparable<Gh>{
int q;
int u;
 public String toString() {
return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(Gh otherObj){
if(this.equals(otherObj))return 0;
return toInteger(q<otherObj.q)+toInteger(u<otherObj.u);}
@Override
public boolean equals(Object otherObj){
Gh other=(Gh)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return q==other.q &&u==other.u;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
