package Maps;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    public static void main(String[] args) {
        HashMap<Integer, String > map = new HashMap<>();
        map.put(1, "Pranjal");
        map.put(2, "Rashmi");
        map.put(3, "Vanshika");
        map.put(4, "Ishita");
        map.put(5, "Nachiketa");

        System.out.println("All employees are ");
        for(Map.Entry<Integer, String> employee : map.entrySet()){
            System.out.println("Employee id: "+ employee.getKey() + "  Employee name: " + employee.getValue() );
        }

    }
}
