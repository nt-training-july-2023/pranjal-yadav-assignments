package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=10; i<30; i++){
            list.add((i*3));
        }
        System.out.println(list);

        //REVERSING
        Collections.reverse(list);
        System.out.println(list);

        //UPDATE
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > 50){
                list.set(i, list.get(i)+5);
            }
        }
        System.out.println(list);

        //ELEMENTS LESS THAN 60
        for (int num: list){
            if(num < 60){
                System.out.println(num);
            }
        }

    }
}