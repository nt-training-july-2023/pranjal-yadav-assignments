package Tasks;

import java.util.LinkedHashSet;

public class Task2 {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("A");
        lhs.add("B");
        lhs.add("C");
        lhs.add("A");
        lhs.add("D");
        lhs.add("D");
        System.out.println(lhs);

        System.out.println(lhs.size());

    }
}
