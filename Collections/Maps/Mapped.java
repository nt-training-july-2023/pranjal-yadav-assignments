package Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapped {
    public static void main(String[] args) {
        HashMap<String, Integer> map= new HashMap<>();
        map.put("A", 10);
        map.put("B", 40);
        map.put("C", 900);
        map.put("D", 30);
        map.put("A", 80);
        map.put("B", 10);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key ");
        String key= sc.nextLine();
        if(map.containsKey(key)){
            System.out.println("The corresponding value is " + map.get(key));
            map.remove(key);
            System.out.println("Key value removed");
            System.out.println("Remaining entries ");
            for(Map.Entry<String, Integer> it : map.entrySet()){
                System.out.println(it.getKey() + " : " + map.get(it.getKey()));
            }
        }else{
            System.out.println("The key does not exists.");
        }
    }
}
