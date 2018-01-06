package MainPanle;
public class Er implements Comparable<Er>{
int r;
int q;
 public String toString() {
return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(Er otherObj){
if(this.equals(otherObj))return 0;
return toInteger(r<otherObj.r)+toInteger(q<otherObj.q);}



@Override
public boolean equals(Object otherObj){
Er other=(Er)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return r==other.r &&r==other.r;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
