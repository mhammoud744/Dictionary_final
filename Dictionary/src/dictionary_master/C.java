package dictionary_master;

public class C extends B implements Comparable<dictionary_master.A> {

    String u;

    int i;

    public C(int n, int a, int b, String u, int i) {

        super(n, a, b);
        this.u = u;

        this.i = i;

    }

    public String toString() {

        return "";
    }

    @Override

    public int compareTo(dictionary_master.A otherObj) {

        C other = (C) otherObj;

        if (this.equals(other)) {
            return 0;
        }

        return u.compareTo(other.u) + toInteger(i < other.i);
    }

    @Override

    public boolean equals(Object otherObj) {

        C other = (C) otherObj;

        if (this == otherObj) {

            return true;

        }

        if (otherObj == null) {

            return false;

        }

        if (this.getClass() != otherObj.getClass()) {
            return false;
        }

        return u.equals(other.u) && i == other.i;

    }

    public int toInteger(boolean b) {

        if (b == true) {
            return 1;
        }

        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash = hash + this.u.hashCode();
        hash = hash + this.u.hashCode();
        hash = hash + this.i;
        return hash;
    }

}
