package Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Threshold {

    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 40);
        map.put("C", 900);
        map.put("D", 30);
        map.put("A", 80);
        map.put("B", 10);

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter threshold value ");
        int t= sc.nextInt();

        if(map.size() >= t){
            //delete
            map = null;
            System.out.println("The map is now cleared");
        }else{
            for(Map.Entry<String, Integer> it : map.entrySet()){
                System.out.println(it.getKey() + " : " + map.get(it.getKey()));
            }
        }
    }
}
