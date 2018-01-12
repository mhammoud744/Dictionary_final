package dictionary_master;

public class Ad implements Comparable<Ad>{

int c;

public Ad(int c)

{

this.c=c;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Ad otherObj){

if(this.equals(otherObj))return 0;

return toInteger(c<otherObj.c);}

@Override

public boolean equals(Object otherObj){

Ad other=(Ad)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return c==other.c;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

}

