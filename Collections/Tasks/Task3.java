package Tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
    String name;
    int rollNo;

    Student(String name, int rollNo){
        this.name = name;
        this.rollNo= rollNo;
    }

    @Override
    public int compareTo(Student that) {
        if(this.rollNo > that.rollNo){
            return -1;
        }else return 1;
    }
}

public class Task3{
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(10);
        list.add(300);
        list.add(1);
        list.add(78);
        list.add(50);
        list.add(707);

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else{
                    return 1;
                }
            }
        };

        Collections.sort(list, comp);
        System.out.println(list);


        Student s1= new Student("Pranjal", 10);
        Student s2= new Student("Rashmi", 40);
        Student s3 = new Student("Vansika", 1);
        Student s4 = new Student("Ishita", 20);
        List<Student> studs = new ArrayList<>();
        studs.add(s1);
        studs.add(s2);
        studs.add(s3);
        studs.add(s4);
        for(Student s : studs){
            System.out.println(s.rollNo);
        }

        Collections.sort(studs);
        for(Student s : studs){
            System.out.println(s.rollNo);
        }
    }


}
