package dictionary_master;

public class B extends A implements Comparable<dictionary_master.A>{

int n;

public B(int a,int b,int n)

{

super(a,b);this.n=n;

}



 public String toString() {

return ""; }

@Override

public int compareTo(dictionary_master.A otherObj){

B other = (B) otherObj;

if(this.equals(other))return 0;

return toInteger(n<other.n);}

@Override

public boolean equals(Object otherObj){

B other=(B)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return n==other.n;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;
hash=hash+this.n;
return hash;
}

}

