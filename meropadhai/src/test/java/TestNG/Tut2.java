package TestNG;

import org.testng.annotations.Test;

public class Tut2 {
    
    @Test
    public void isPass(){
        System.out.println("The user is pass");
    }

    @Test
    public void isFail(){
        System.out.println("The user is fail");
    }

}
