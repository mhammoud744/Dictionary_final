package dictionary_master;

public class A implements Comparable<A> {

    int s;
    String d;

    public String toString() {
        return "HelloWorld - Java Dynamic Class Creation was written by Rob Austin";
    }

    @Override
    public int compareTo(A object) {
        return d.compareTo(object.d);
    }

    public boolean equals(A object) {
        return d.equals(object.d);
    }
}
