import java.util.Properties;
import java.util.*;

public class Property {
    public static void main(String[] args) {
        Properties statesAndCapitals = new Properties();

        statesAndCapitals.put("Chhattisgarh", "Raipur");
        statesAndCapitals.put("Madhya Pradesh", "Bhopal");
        statesAndCapitals.put("Maharashtra", "Mumbai");
        statesAndCapitals.put("Rajasthan", "Jaipur");
        statesAndCapitals.put("West bengal", "Kolkata");
        statesAndCapitals.put("Andhra Pradesh", "Amravati");

        Set states= statesAndCapitals.keySet();

        Iterator itr= states.iterator();

        while (itr.hasNext()){
            String  str = (String) itr.next();
            System.out.println("The capital of " + str + " is " + statesAndCapitals.getProperty(str));
        }
    }
}
