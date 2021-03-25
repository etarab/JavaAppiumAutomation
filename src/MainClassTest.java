import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetLocalNumber(){
        int number = this.getLocalNumber();
        if (number==14){
            System.out.println(number + " is expected value");
        } else {
            System.out.println(number + " is unexpected value");
        }
    }
}
