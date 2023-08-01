import java.io.File;

public class List {
    public static void main(String[] args) {
        File file = new File("D:\\Training-modules\\IO_Lambda");
        String[] list = file.list();
        for(String name : list) {
            System.out.println(name);
        }
    }
}
