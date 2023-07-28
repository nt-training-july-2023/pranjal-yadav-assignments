package Question10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        try {
            String valid = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$";
            Pattern p= Pattern.compile(valid);
            Matcher m= p.matcher(s);
            if(m.matches()){
                System.out.println("Valid password");
            }
            else {
                throw new InvalidPasswordException("Password should have at least eight characters, " +
                        "contain both letters and numbers.");
            }
        }catch (InvalidPasswordException e){
            System.out.println(e);
        }
    }
}
