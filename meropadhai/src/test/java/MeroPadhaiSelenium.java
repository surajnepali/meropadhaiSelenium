import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MeroPadhaiSelenium {
    
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.meropadhai.com");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("button.chakra-button.css-1cvkl7w")).click();
        driver.findElement(By.name("email")).sendKeys("surajclinchtech@gmail.com");
        driver.findElement(By.id("field-3")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        System.out.println("URL after the user is logged in: " + driver.getCurrentUrl());
        driver.findElement(By.cssSelector("button.chakra-button.css-zdihdj")).click();
        WebElement titleText = driver.findElement(By.xpath("//h1/span[1]"));
        String actualText = titleText.getText();
        Assert.assertEquals(actualText, "Get set");
        WebElement exploreCourseButton = driver.findElement(By.xpath("//button[text()='Explore Courses']"));
        exploreCourseButton.click();
        Thread.sleep(2000);
        System.out.println("URL after the user is on the explore courses page in: " + driver.getCurrentUrl());
        driver.findElement(By.id("menu-button-27")).click();
        WebElement faculty = driver.findElement(By.xpath("//button[text()='Faculty of Engineering']"));
        String facultyName = faculty.getText();
        System.out.println("First Faculty Name: " + facultyName);
        faculty.click();
        Thread.sleep(2000);
        String cssSelector = "p.chakra-text.css-88sgbq";
        WebElement facultyText = driver.findElement(By.cssSelector(cssSelector));
        System.out.println("Second Faculty Name: " + facultyText.getText());
        Assert.assertEquals(facultyText.getText(), "Faculty of Engineering");
        System.out.println("Checking is done succesfully");
        driver.close();

        // Parent Child Relationship
        //div[@id='element_id'] //a[@value='MAA']
    }
}