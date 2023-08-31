import com.test.DisplayMessage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDisplayMessage {

    @Test
    public void testGreet(){
        DisplayMessage message= new DisplayMessage();

        String res= message.greet("Pranjal");

        assertEquals(res, "Hello Pranjal");
    }
}
