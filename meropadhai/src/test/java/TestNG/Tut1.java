package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tut1 {
    
    /*
     * If it is @BeforeTest then it will execute at first of that test tagg ie. <test></test>
     * If it is @AfterTest then it will execute at last of that test tagg ie. <test></test>
     * If it is @BeforeSuit then it will execute at first of all the test cases available in that .xml file
     * If it is @BeforeMethod then it will execute before each method executes of that class file
     * If it is @AfterMethod then it will execute after each method executes of that class file
     * If it is @BeforeClass then it will execute before executing methods of a class
     * If it is @AfterClass then it will execute after executing methods of a class
     * 
     */

    @Test
    public void goHome(){
        System.out.println("I'm going home");
    }

    @Parameters({"URL"})
    @Test
    public void comeHome(String url){
        System.out.println("I'm coming home");
        System.out.println(url);
    }

    @Test (dataProvider = "getData")
    public void donotComeHome(String username, String password){
        System.out.println("Please, don't come home");
        System.out.println(username);
        System.out.println(password);
        System.out.println("---------******---------");
    }

    @DataProvider
    public Object[][] getData(){

        // 1st combination: firstUserName and firstPassword
        // 2nd combination: secondUserName and secondPassword
        // 3rd combination: thirdUserName and thirdPassword
        Object[][] obj = new Object[3][2];

        obj[0][0] = "firstUserName";
        obj[0][1] = "firstUserName";

        obj[1][0] = "secondUserName";
        obj[1][1] = "secondPassword";

        obj[2][0] = "thirdUserName";
        obj[2][1] = "thirdPassword";
        return obj;
    }
}