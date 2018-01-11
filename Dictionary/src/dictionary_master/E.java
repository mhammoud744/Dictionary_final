package dictionary_master;

public class E implements Comparable<E>{

int bn;

public E(int bn)

{

this.bn=bn;

}



 public String toString() {

return ""; }

@Override

public int compareTo(E otherObj){

if(this.equals(otherObj))return 0;

return toInteger(bn<otherObj.bn);}

@Override

public boolean equals(Object otherObj){

E other=(E)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return bn==other.bn;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;hash=hash+this.bn;
return hash;
}

}

