import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("ne");

        List<WebElement> options = driver.findElements(By.cssSelector("div.ui-menu-item-wrapper"));

        Actions actions = new Actions(driver);
        for(int i = 0; i < options.size(); i++){
            String option = options.get(i).getText();
            if(option.equalsIgnoreCase("Nepal")){
                actions.moveToElement(options.get(i)).click().build().perform();
                System.out.println(option + " is selected.");
                break;
            }
        }
    }
}