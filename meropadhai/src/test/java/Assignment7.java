import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        // Get total number of rows of Web Table Example
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));

        int totalRows = 0;
        for(int i = 0; i < rows.size(); i++){
            totalRows++;        
            if(i == 2){
                List<WebElement> values = rows.get(i).findElements(By.cssSelector("td"));
                
                // Get total number of columns of Web Table Example
                System.out.println("Total number of columns of Web Table Example is: " + values.size());
                for(int j = 0; j < values.size(); j++){
                    System.out.println("Value of row number " + (i+1) + ", column number " + (j+1) + " is: " + values.get(j).getText());
                }
            }
        }
        System.out.println("Total number of rows: " + totalRows);
        
    }
}
