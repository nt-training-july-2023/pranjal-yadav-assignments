import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunSuite {
    public static void main(String[] args) {
        Result res= JUnitCore.runClasses(TestSuite.class);

        for(Failure failure: res.getFailures){

        }
    }
}
