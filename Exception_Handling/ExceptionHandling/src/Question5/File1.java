package Question5;

import java.io.*;

public class File1 {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\Training-modules\\Exception_Handling\\ExceptionHandling\\src\\Question5\\Input.txt");
            FileReader fr= new FileReader(file);
            FileWriter fw= new FileWriter("D:\\Training-modules\\Exception_Handling\\ExceptionHandling\\src\\Question5\\Output.txt");

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
