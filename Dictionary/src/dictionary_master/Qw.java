package dictionary_master;

public class Qw implements Comparable<Qw>{

int s;

public Qw(int s)

{

this.s=s;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Qw otherObj){

if(this.equals(otherObj))return 0;

return toInteger(s<otherObj.s);}

@Override

public boolean equals(Object otherObj){

Qw other=(Qw)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return s==other.s;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;
 hash=hash+this.s;
return hash;
}

}

