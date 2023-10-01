import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamExample {

    public static String getStateId(WebElement s){
        String stateId = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return stateId;
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://1system-testadminfront.vercel.app/login");
        driver.findElement(By.id("email")).sendKeys("admin@1system.us");
        driver.findElement(By.id("password")).sendKeys("@Admin!123");
        driver.findElement(By.cssSelector("button.mt-8.primary-btn")).click();

        driver.findElement(By.xpath("//button[@type='button']")).click();
        String css1 = "div.p-2.flex.gap-2.items-center.text-small.font-medium.rounded-xl.text-neutral-800";
        List<WebElement> elements = driver.findElements(By.cssSelector(css1));
        for(WebElement element: elements){
            String elemName = element.getText();
            if(elemName.equalsIgnoreCase("Driver")){
                element.click();
            }
        }

        String css2 = "//div[@class='flex gap-6 border-b']/a";
        List<WebElement> tabs = driver.findElements(By.xpath(css2));
        for(WebElement tab: tabs){
            String tabName = tab.getText();
            if(tabName.equalsIgnoreCase("Unverified")){
                tab.click();
            }
        }
        
        // Click on column
        driver.findElement(By.xpath("//tr/th[2]/img")).click();

        // Capture all web elements into the list
        String css3 = "//td[@class='flex items-center space-x-4']";
        List<WebElement> names = driver.findElements(By.xpath(css3));
        
        // Capture all webElements in the original list
        List<String> nameArray = names.stream().map(s->s.getText()).collect(Collectors.toList());
        
        // Sort the array and collect into another List
        List<String> sortedList = nameArray.stream().sorted().collect(Collectors.toList());
        
        // Compare original arrayList vs list
        for(int i = 0; i < sortedList.size(); i++){
            Assert.assertTrue(sortedList.get(i) == nameArray.get(i));
        }

        List<String> stateIds = names.stream().filter(s->s.getText().contains(nameArray.get(1))).map(s->getStateId(s)).collect(Collectors.toList());
        stateIds.forEach(s->System.out.println(s));

        // It would be best to use do while loop to automate pagination
    }

}