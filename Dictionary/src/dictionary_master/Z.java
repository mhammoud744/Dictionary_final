package dictionary_master;

public class Z extends Point implements Comparable<dictionary_master.Point> {

    int nh;

    int yt;

    public Z(int x, int y, int nh, int yt) {
        super(x, y);
        this.nh = nh;
        this.yt = yt;

    }

    public String toString() {

        return "";
    }

    @Override

    public int compareTo(dictionary_master.Point otherObj) {

        Z other = (Z) otherObj;

        if (this.equals(other)) {
            return 0;
        }

        return toInteger(nh < other.nh) + toInteger(yt < other.yt);
    }

    @Override

    public boolean equals(Object otherObj) {

        Z other = (Z) otherObj;

        if (this == otherObj) {

            return true;

        }

        if (otherObj == null) {

            return false;

        }

        if (this.getClass() != otherObj.getClass()) {
            return false;
        }

        return nh == other.nh && yt == other.yt;

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
        hash = hash + this.nh;
        hash = hash + this.nh;
        hash = hash + this.yt;
        return hash;
    }

}
