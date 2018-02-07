package dictionary_master;

public class A implements Comparable<A>{

int a;

int b;

public A(int a,int b)

{

this.a=a;

this.b=b;

}



 public String toString() {

return ""; }

@Override

public int compareTo(A otherObj){

if(this.equals(otherObj))return 0;

return toInteger(a<otherObj.a)+toInteger(b<otherObj.b);}

@Override

public boolean equals(Object otherObj){

A other=(A)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return a==other.a &&b==other.b;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;
hash=hash+this.a;
hash=hash+this.a;
hash=hash+this.b;
return hash;
}

}

