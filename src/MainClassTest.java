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

    @Test
    public void testGetClassNumber(){
        if (this.getClassNumber() > 45){
            System.out.println(this.getClassNumber() + " over than 45");
        } else {
            Assert.fail(this.getClassNumber() + " less or equals 45");
        }
    }
}
