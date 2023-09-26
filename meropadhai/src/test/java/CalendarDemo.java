import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.path2usa.com/travel-companion/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 850)");

        Thread.sleep(2000);
        driver.findElement(By.id("form-field-travel_comp_date")).click();

        WebElement month = driver.findElement(By.cssSelector("span.cur-month"));
        while (!month.getText().equalsIgnoreCase("January")) {
            driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
            Thread.sleep(500);
            month = driver.findElement(By.cssSelector("span.cur-month")); // Re-find the month element
        }

        List<WebElement> days = driver.findElements(By.cssSelector("span.flatpickr-day"));

        for(int i = 0; i < days.size(); i++){
            String day = days.get(i).getText();
            if(day.equalsIgnoreCase("23")){
                days.get(i).click();
                break;
            }
        }

        driver.close();

    }
}
