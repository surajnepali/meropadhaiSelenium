import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {
    
    public static void visitSite(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    public static void login(WebDriver driver){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@value='user']")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("consult");
        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.cssSelector("input.btn.btn-info.btn-md")).click();
    }

    public static void addItemsToCart(WebDriver driver){
        List<WebElement> addButtons = driver.findElements(By.xpath("//button[@class='btn btn-info']"));

        for(int i = 0; i < addButtons.size(); i++){
            addButtons.get(i).click();
        }
    }

    public static void main(String[] args) {
    
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        visitSite(driver);
        login(driver);
        addItemsToCart(driver);
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
        System.out.println("Current url path is: " + driver.getCurrentUrl());
        driver.close();

    }

}
