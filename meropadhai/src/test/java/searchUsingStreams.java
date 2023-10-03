import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class searchUsingStreams {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.meropadhai.com/");
        
        // Find the saearch button and click the button
        driver.findElement(By.xpath("//button[@aria-label='Search Button']")).click();
        
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search courses...']"))).click().sendKeys("test").keyDown(Keys.ENTER).build().perform();

        // Workflow to implement the code to match the text using stream()
        //
        //
        //
        //

        driver.findElement(By.cssSelector("button.chakra-button.css-1cvkl7w")).click();

        // Relative Locator (using above()): is applicable only for tagname
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(emailField)).getText());
    }
}
