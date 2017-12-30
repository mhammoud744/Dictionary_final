package dictionary_master;
public class C implements Comparable<C>{
int e;
String t;
 public String toString() {
     return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin"; }
@Override
public int compareTo(C object){
return e.compareTo(object.e);
}
public boolean equals(C object){
return e.equals(object.e);
}
}
