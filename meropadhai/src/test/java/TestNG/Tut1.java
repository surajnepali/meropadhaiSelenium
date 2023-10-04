package TestNG;

import org.testng.annotations.Test;

public class Tut1 {
    
    /*
     * If it is @BeforeTest then it will execute at first of that test tagg ie. <test></test>
     * If it is @AfterTest then it will execute at last of that test tagg ie. <test></test>
     */

    @Test
    public void goHome(){
        System.out.println("I'm going home");
    }

    @Test
    public void comeHome(){
        System.out.println("I'm coming home");
    }

    @Test
    public void donotComeHome(){
        System.out.println("Please, don't come home");
    }
}