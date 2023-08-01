package Maps;

import java.util.*;

public class Types {

    //classic hashmap
    void hash(){
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

    //insertion order is preserved
    void linked(){
        LinkedHashMap<String, Integer> lhs = new LinkedHashMap<>();
        lhs.put("D", 30);
        lhs.put("A", 10);
        lhs.put("B", 40);
        lhs.put("C", 900);
        lhs.put("A", 80);
        lhs.put("B", 10);

        for(Map.Entry<String, Integer> it : lhs.entrySet()){
            System.out.println(it.getKey() + " : " + lhs.get(it.getKey()));
        }
    }

    //natural order is preserved (of keys)
    void tree(){
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("A", 10);
        tm.put("B", 40);
        tm.put("C", 900);
        tm.put("D", 30);
        tm.put("A", 80);
        tm.put("B", 10);

        for(Map.Entry<String, Integer> it : tm.entrySet()){
            System.out.println(it.getKey() + " : " + tm.get(it.getKey()));
        }
    }
    public static void main(String[] args) {
        Types t= new Types();
        t.hash();

        System.out.println("----------------------------------------------");

        t.linked();

        System.out.println("----------------------------------------------");

        t.tree();
    }
}

