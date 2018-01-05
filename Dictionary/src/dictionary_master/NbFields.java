package dictionary_master;


import java.lang.reflect.Field;

public class NbFields {

    Field f[];

    public NbFields() {
    }

    public int getColumnCount(Object o) {
        return o.getClass().getDeclaredFields().length;
    }

    public Field[] getFieldss(Object o) {
        f = o.getClass().getDeclaredFields();
        return f;
    }

    public static void main(String args[]) {
        Code c = new Code();
        NbFields f = new NbFields();
        System.out.println(f.getColumnCount(c));
        Field hold[] = f.getFieldss(c);
        for (Field field : hold) {
            System.out.println("Field name = " + field.getName());
            System.out.println("Field type = " + field.getType().getName());
        }
    }
}
