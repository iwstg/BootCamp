package boot.start.servlet;

import java.util.Enumeration;
import java.util.Vector;

public class EnumEx {
    public static void main(String[] args) {
        Vector<String> names = new Vector<>();
        names.add("kim");
        names.add("lee");
        names.add("part");

        Enumeration<String> e = names.elements();
        while(e.hasMoreElements()) {
            String name = e.nextElement();
            System.out.println(name);
        }
    }
}
