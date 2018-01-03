package dictionary_master;
public class V implements Comparable<V>{
String g;
int v;
 public String toString() {
     return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(V otherObj){
if(this.equals(otherObj))return 0;
return g.compareTo(otherObj.g)+toInteger(v<otherObj.v);
        }



@Override
public boolean equals(Object otherObj){
V other=(V)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return g.equals(other.g) &&v==other.v;
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
