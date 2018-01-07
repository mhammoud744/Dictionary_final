package dictionary_master;
public class G implements Comparable<G>{
int q;
String w;
 public String toString() {
return ""; }
@Override
public int compareTo(G otherObj){
if(this.equals(otherObj))return 0;
return toInteger(q<otherObj.q)+w.compareTo(otherObj.w);}
@Override
public boolean equals(Object otherObj){
G other=(G)otherObj; 
if(this==otherObj){
return true;
}
if(otherObj==null){
return false;
}
if(this.getClass()!=otherObj.getClass())
 return false; 
return q==other.q &&w.equals(other.w);
}
public int toInteger(boolean b){
if(b==true)return 1;
return 0;}
}
