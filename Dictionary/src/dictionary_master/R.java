package dictionary_master;
public class R implements Comparable<R>{
int q;
int w;
 public String toString() {
return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(R otherObj){
if(this.equals(otherObj))return 0;
return toInteger(q<otherObj.q)+toInteger(w<otherObj.w);}
@Override
public boolean equals(Object otherObj){
R other=(R)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return q==other.q &&w==other.w;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
