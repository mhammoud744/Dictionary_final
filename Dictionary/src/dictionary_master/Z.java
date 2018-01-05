package MainPanle;
public class Z implements Comparable<Z>{
String ewvf;
int vwe;
 public String toString() {
     return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(Z otherObj){
if(this.equals(otherObj))return 0;
return ewvf.compareTo(otherObj.ewvf);}
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
return ewvf.equals(other.ewvf);
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
