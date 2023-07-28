package Question8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the file: ");
        FileReader fr = null;
        try{
            String fileName = sc.nextLine();
            fr= new FileReader("D:\\Training-modules\\Exception_Handling\\ExceptionHandling\\src\\Question8\\"+ fileName+".txt");
            String str= "";
            int i;
            while ((i = fr.read()) != -1){
                str+= (char) i;
            }
            System.out.println(str);
        }catch (IOException e){
            System.out.println(e);
        }catch (NullPointerException e){
            System.out.println(e);
            System.out.println("Give correct file name");
        }
        catch (Exception e){
            System.out.println(e);
        }finally {
            fr.close();
        }
    }
}
