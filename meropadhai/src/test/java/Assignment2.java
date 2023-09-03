import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
 
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Suraj Nepali");
        driver.findElement(By.name("email")).sendKeys("surajnepali7896@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        WebElement dropdownBox = driver.findElement(By.cssSelector("select[id='exampleFormControlSelect1']"));
        Select oneValue = new Select(dropdownBox);
        oneValue.selectByVisibleText("Female");
        driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
        driver.findElement(By.cssSelector("input[type='date']")).sendKeys("25091998");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div/strong")).getText());
        System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());
    }
    
}