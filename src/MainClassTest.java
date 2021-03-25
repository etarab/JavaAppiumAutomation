import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetLocalNumber(){

        if (this.getLocalNumber()==14){
            System.out.println(this.getLocalNumber() + " is expected value");
        } else {
            Assert.assertEquals("getLocalNumber() contains unexpected value",14, this.getLocalNumber());
        }
    }


}
