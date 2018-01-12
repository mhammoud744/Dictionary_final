package dictionary_master;

public class Fbi implements Comparable<Fbi>{

A n;

int m;

public Fbi(A n,int m)

{

this.n=n;

this.m=m;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Fbi otherObj){

if(this.equals(otherObj))return 0;

return n.compareTo(otherObj.n)+toInteger(m<otherObj.m);}

@Override

public boolean equals(Object otherObj){

Fbi other=(Fbi)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return n.equals(other.n) &&m==other.m;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;
hash=hash+this.n.hashCode();
hash=hash+this.n.hashCode();
hash=hash+this.m;
return hash;
}

}

