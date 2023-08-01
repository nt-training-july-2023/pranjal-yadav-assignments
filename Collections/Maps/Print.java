package Maps;

import java.util.HashMap;
import java.util.Map;

public class Print {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 40);
        map.put("C", 900);
        map.put("D", 30);
        map.put("A", 80);
        map.put("B", 10);

        for(Map.Entry<String, Integer> it : map.entrySet()){
            System.out.println(it.getKey() + " : " + map.get(it.getKey()));
        }
    }
}
