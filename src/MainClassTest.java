import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetLocalNumber(){

        if (this.getLocalNumber()==14){
            System.out.println(getLocalNumber() + " is expected value");
        } else {
            Assert.assertEquals("getLocalNumber() contains unexpected value",14, getLocalNumber());
        }
    }

    @Test
    public void testGetClassNumber(){
        if (getClassNumber() > 45){
            System.out.println(getClassNumber() + " over than 45");
        } else {
            Assert.fail(getClassNumber() + " less or equals 45");
        }
    }

    @Test
    public void testGetClassString(){
        if (getClassString().contains("Hello") || getClassString().contains("hello")){
            System.out.println("\""+getClassString()+"\"" + " contains expected substring");
        } else {
            Assert.fail("\""+getClassString()+"\""  + " not contains expected substring");
        }
    }
}
