package dictionary_master;

public class Poly implements Comparable<Poly>{

Point a;

Point b;

Point c;

public Poly(Point a,Point b,Point c)

{

this.a=a;

this.b=b;

this.c=c;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Poly otherObj){

if(this.equals(otherObj))return 0;

return a.compareTo(otherObj.a)+b.compareTo(otherObj.b)+c.compareTo(otherObj.c);}

@Override

public boolean equals(Object otherObj){

Poly other=(Poly)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return a.equals(other.a) &&b.equals(other.b) &&c.equals(other.c);

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

@Override
public int hashCode(){
 int hash=0;
hash=hash+this.a.hashCode();
hash=hash+this.a.hashCode();
hash=hash+this.b.hashCode();
hash=hash+this.a.hashCode();
hash=hash+this.a.hashCode();
hash=hash+this.b.hashCode();
hash=hash+this.c.hashCode();
return hash;
}

}

