import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment4 {
    
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Multiple Windows')]"))).click().build().perform();
        List<WebElement> elements = driver.findElements(By.xpath("//a"));

        for(int i = 0; i < elements.size(); i++){
            String elementName = elements.get(i).getText().trim();
            System.out.println(elementName);
            if(elementName.equalsIgnoreCase("Click Here")){
                elements.get(i).click();
                break;
            }
        }
        
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        driver.quit();
    }
}