package Static;

public class Student {
    int rollNo;
    String name;
    static int numberOfStudents=0;
    Student(String name, int rollNo){
        this.name= name;
        this.rollNo= rollNo;
        numberOfStudents++;
    }

    void show(){
        System.out.println("Name: " + name);
        System.out.println("Roll number: " + rollNo);
    }
}

class StudentDriver{
    public static void main(String[] args) {
        Student s1 = new Student("Pranjal Yadav", 001);
        s1.show();
        Student s2= new Student("Anany", 002);
        s2.show();

        System.out.println(Student.numberOfStudents);
    }
}