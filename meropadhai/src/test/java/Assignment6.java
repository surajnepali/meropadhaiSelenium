import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
    
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Visit the link
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String text = null;
        WebElement checkBoxExample = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset"));
        List<WebElement> labels = checkBoxExample.findElements(By.xpath("//label/input[@type='checkbox']"));
        System.out.println(labels);
        int labelIndex = 1;
        WebElement labelElement = labels.get(labelIndex);
        System.out.println(labelElement);
        text = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[" + (labelIndex+1) + "]" )).getText().trim();
        System.out.println(text);
        labelElement.click();

        // Using Option2 to select from dropdown
        WebElement dropdownBox = driver.findElement(By.cssSelector("select#dropdown-class-example"));
        Select option = new Select(dropdownBox);
        option.selectByVisibleText(text);

        //  
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        String splitedText = alertText.split(",")[0].split(" ")[1].trim();
        System.out.println(splitedText);
        Assert.assertEquals(splitedText, text);
        if(alertText.contains(text)){
            System.out.println("Alert Text contains one of the options");
        }
        
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.quit();

    }
}
