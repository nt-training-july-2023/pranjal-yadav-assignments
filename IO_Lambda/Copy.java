import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\Training-modules\\IO_Lambda\\In.txt");
            FileReader fr= new FileReader(file);
            FileWriter fw= new FileWriter("D:\\Training-modules\\IO_Lambda\\Out.txt");

            String str="";
            int i;
            while ((i = fr.read()) != -1){
                str= str+ (char) i;
                //casting ascii into character
            }
            System.out.println(str);

            fw.write(str);
            System.out.println("File content transferred successfully!");

            fr.close();
            fw.close();

        }catch (IOException e){
            System.out.println(e);
            System.out.println("Change name of file");
        }catch (SecurityException e){
            System.out.println(e);
            System.out.println("File is protected");
        }catch ( Exception e){
            System.out.println(e);
            System.out.println("Some exceptions were caught");
        }
    }
}