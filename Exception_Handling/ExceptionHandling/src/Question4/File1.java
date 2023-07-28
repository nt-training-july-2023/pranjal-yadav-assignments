package Question4;

import java.io.*;

public class File1 {
    public static void main(String[] args) {

        try{
            File f= new File("D:\\Training-modules\\Exception_Handling\\ExceptionHandling\\src\\Question4\\file2.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }

        }
        catch (IOException e) {
            System.out.println(e);
            System.out.println("Change file address");
        }
//        }catch (FileNotFoundException e){
//            System.out.println(e);
//            System.out.println("Change file address");
//        }
            //fileNotFoundException is a subclass of IOException
        catch (SecurityException e){
            System.out.println(e);
        }
    }
}
