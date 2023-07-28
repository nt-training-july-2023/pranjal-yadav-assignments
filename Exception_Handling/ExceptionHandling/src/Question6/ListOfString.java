package Question6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("Pranjal");
//        list.add("Hello");
//        list.add("World");
//        list.add("Programming");
//        list.add("Java");
//        list.add("Backend");
//        list.add("Frontend");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter index you want to access");
        int index= sc.nextInt();

        try{
//            if(list==null){
//                throw new NullPointerException();
//            } else if (index<0 || index> list.size()) {
//                throw new NullPointerException();
//            }else {
                System.out.println("The string at index " +index+ " is "+ list.get(index));
//            }

        }catch (NullPointerException ne){
            System.out.println(ne + ": list is empty");

        }catch (IndexOutOfBoundsException e){
            System.out.println(e + ": The index is less than 0 or greater than the size of list");
        }

    }

}
