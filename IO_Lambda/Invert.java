

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Invert {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\Training-modules\\IO_Lambda\\Invert_in.txt");
            FileReader fr= new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            FileWriter fw= new FileWriter("D:\\Training-modules\\IO_Lambda\\Invert_out.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            ArrayList<String> list = new ArrayList<>();

            String str;
            while ((str = br.readLine()) != null){
                list.add(str);
                //casting ascii into character
            }
            System.out.println(list);

            Collections.reverse(list);
            for(String s: list){
                bw.write(s);
                bw.newLine();
            }

            bw.close();
            br.close();

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
