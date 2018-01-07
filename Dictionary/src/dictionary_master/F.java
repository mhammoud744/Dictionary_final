package dictionary_master;
public class F implements Comparable<F>{
int a;
int x;
 public String toString() {
return ""; }
@Override
public int compareTo(F otherObj){
if(this.equals(otherObj))return 0;
return toInteger(a<otherObj.a)+toInteger(x<otherObj.x);}
@Override
public boolean equals(Object otherObj){
F other=(F)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return a==other.a &&x==other.x;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
