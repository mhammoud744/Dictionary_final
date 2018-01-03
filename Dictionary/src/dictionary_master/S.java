package dictionary_master;
public class S implements Comparable<S>{
int e;
String d;
 public String toString() {
     return ""; 
 }
@Override
public int compareTo(S otherObj){
if(this.equals(otherObj))return 0;
return toInteger(e<otherObj.e)+d.compareTo(otherObj.d);}
@Override
public boolean equals(Object otherObj){
S other=(S)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return e==other.e &&d.equals(other.d);
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
