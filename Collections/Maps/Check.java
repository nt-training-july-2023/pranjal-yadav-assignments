package Maps;

import java.util.HashMap;

public class Check {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 40);
        map.put("C", 900);
        map.put("D", 30);
        map.put("A", 80);
        map.put("B", 10);

        if(map.containsKey("B")){
            System.out.println("Key present");
        }else System.out.println("Key not present");
        if(map.containsValue(80)){
            System.out.println("Value is present");
        }else System.out.println("Value is not present");
    }
}
