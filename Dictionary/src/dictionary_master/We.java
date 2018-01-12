package dictionary_master;

public class We extends Ad implements Comparable<Ad>{

int e;

public We(int e)
{

super(e);
this.e=e;

}



 public String toString() {

return ""; }

@Override

public int compareTo(Ad otherObj){

We other = (We) otherObj;

if(this.equals(other))return 0;

return toInteger(e<other.e);}

@Override

public boolean equals(Object otherObj){

We other=(We)otherObj; 

if(this==otherObj){

return true;

}

if(otherObj==null){

return false;

}

if(this.getClass()!=otherObj.getClass())

 return false; 

return e==other.e;

}

public int toInteger(boolean b){

if(b==true)return 1;

return 0;}

}

