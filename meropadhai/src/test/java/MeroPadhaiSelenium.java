import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MeroPadhaiSelenium {

    public static void visitLink(WebDriver driver){
        driver.get("https://demo.meropadhai.com");
        System.out.println(driver.getCurrentUrl());
    }

    public static void setLoginCredentials(WebDriver driver){
        driver.findElement(By.cssSelector("button.chakra-button.css-1cvkl7w")).click();
        driver.findElement(By.name("email")).sendKeys("surajclinchtech@gmail.com");
        driver.findElement(By.id("field-3")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public static void homeValidation(WebDriver driver){
        driver.findElement(By.cssSelector("button.chakra-button.css-zdihdj")).click();
        WebElement titleText = driver.findElement(By.xpath("//h1/span[1]"));
        String actualText = titleText.getText();
        Assert.assertEquals(actualText, "Get set");
        System.out.println("URL after the user is logged in: " + driver.getCurrentUrl());
        WebElement exploreCourseButton = driver.findElement(By.xpath("//button[text()='Explore Courses']"));
        exploreCourseButton.click();
    }

    public static void chooseFaculty(WebDriver driver){
        String cssSelector = "p.chakra-text.css-88sgbq";
        WebElement facultyText = driver.findElement(By.cssSelector(cssSelector));
        Assert.assertEquals(facultyText.getText(), "Faculty of Engineering");
        driver.findElement(By.xpath("//button[@class='chakra-button chakra-menu__menu-button css-8lj3oi']")).click();
        driver.findElement(By.xpath("//button[text()='All']")).click();
    }

    public static void chooseCourse(WebDriver driver){
        List<WebElement> options = driver.findElements(By.xpath("//article[@class='css-bc2ghm']/h2[@class='css-28pdcr']"));
        System.out.println("URL after the user is on the explore courses page in: " + driver.getCurrentUrl());
        System.out.println("Total number of course cards are: " + options.size());

        String courseName;
        for(int i = 0; i < options.size(); i++){
            courseName = options.get(i).getText();
            if(courseName.equalsIgnoreCase("Test-Videos")){
                options.get(i).click();
                break;
            }
        }
    }

    public static void visitCourse(WebDriver driver){

        driver.findElement(By.xpath("//button[@class='chakra-button chakra-menu__menu-button css-8lj3oi']")).click();
        List<WebElement> faculties = driver.findElements(By.xpath("//button[@class=\"chakra-menu__menuitem css-1fffbro\"]"));
        // String[] facultyNames = {"Engineering", "facultyName"};
        // List<String> names = Arrays.asList(facultyNames);
        for(int i = 0; i < faculties.size(); i++){
            String faculty = faculties.get(i).getText();
            // String[] broken = faculty.split(" ");
            // System.out.println(broken[2]);
            // String newName = broken[2];
            if(faculty.equals("Faculty of Engineering")){
                faculties.get(i).click();
                break;
            }
        }
    }

    public static void enrollInCourse(WebDriver driver){
        WebElement enrollButton = driver.findElement(By.xpath("//button[@class='chakra-button css-1yrfiy8']"));
        Assert.assertEquals(enrollButton.getText(), "ENROLL NOW");
        enrollButton.click();
        
        WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='chakra-select css-1e6c7l7']"));

        Select dropdown = new Select(staticDropdown);
        String option = "12";
        dropdown.selectByVisibleText(option);
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='chakra-text css-g2788h']"));
        if(prices.isEmpty()){
            WebElement resetPrice = driver.findElement((By.xpath("//span[@class='chakra-text css-10l964u']")));
            String[] price = resetPrice.getText().split("\\.");

            WebElement continueButton = driver.findElement(By.xpath("//button[@class='chakra-button css-1yxzgw8']"));
            String priceText = continueButton.getText().split("\\.")[1];
            Assert.assertEquals(priceText, price[1].trim());
            continueButton.click();
        }else{
            driver.findElement(By.xpath("//button[@class='chakra-button css-1yxzgw8']")).click();
        }
    }
    
    public static void courseInCart(WebDriver driver) throws InterruptedException, MalformedURLException, IOException{
        Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='chakra-heading css-1lthznb']")).getText(), "Price Summary");
        System.out.println("URL after the user is on the Cart page: " + driver.getCurrentUrl());

        // driver.findElement(By.xpath("//button[@class='chakra-button css-1tpkmit']")).click();
        // driver.findElement(By.xpath("//button[@class='chakra-button css-18392ov']")).click();

        System.out.println("Total Link Counts available in this page: " + driver.findElements(By.tagName("a")).size());  // Prints total count of links available in this page

        // To get the count of links of a footer
        WebElement footerDriver = driver.findElement(By.cssSelector("footer.css-plecv")); // this is called limiting webdriver scope 
        System.out.println("Total count of links available in Footer of this page: " + footerDriver.findElements(By.tagName("a")).size());

        List<WebElement> links = footerDriver.findElements(By.xpath("//div[@class='css-t45qev'][1]/ul/li/a"));
        System.out.println(links.size());
        for(int i = 0; i < links.size(); i++){
            String useKeyboard = Keys.chord(Keys.COMMAND, Keys.ENTER);
            links.get(i).sendKeys(useKeyboard);
            Thread.sleep(5000);
        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterate = windows.iterator();

        while(iterate.hasNext()){
            driver.switchTo().window(iterate.next());
            System.out.println("Title of current page: " + driver.getTitle());
            System.out.println("Url of current page: " + driver.getCurrentUrl());
        }

        List<WebElement> hrefLinks = driver.findElements(By.cssSelector("ul[class='css-bbefzs'] li[class='css-fnhbel'] a"));
        for(int i = 0; i < hrefLinks.size(); i++){
            String url = hrefLinks.get(i).getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode >= 400){
                System.out.println(hrefLinks.get(i).getText() + "'s link is broken because its status code is: " + responseCode);
            }else{
                System.out.println("Status code of Link " + (i+1) + " is: " + responseCode);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        visitLink(driver);
        setLoginCredentials(driver);
        homeValidation(driver);
            
        // for(WebElement option: options){
        //     if(option.getText().equalsIgnoreCase("Test-videos")){
        //         option.click();
        //         break;
        //     }
        // }

        visitCourse(driver);
        chooseFaculty(driver);
        chooseCourse(driver);
        enrollInCourse(driver);
        courseInCart(driver);
        driver.close();

        // Parent Child Relationship
        //div[@id='element_id'] //a[@value='MAA']

        // Handle Alert boxes: Message Alert and Confirm Alert

        // Message Alert
        // System.out.println(driver.switchTo().alert().getText());
        // driver.switchTo().alert().accept();

        // Confirm Alert
        // driver.switchTo().alert().accept(); // to click OK button of Alert box
        // driver.switchTo().alert().dismiss(); // to click Cancel button of Alert box
    
        // Types of Wait
        // Implicit Wait:
        //      - is a Global initialization
        //      - tells Selenium to wait n number of seconds before you throw error message
        //      - example: implicit wait is initialized as 5 seconds. 
                //      -If the system displays the elements in 3 seconds then the Selenium does not wait to complete the initialized 5 seconds
                //      -If the system does not display the elements in 5 seconds then the Selenium throws error message 

        // Fluent Wait:
        // Syntax Code:
        // Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        //     .withTimeout(Duration.ofSeconds(30))
        //     .pollingEvery(Duration.ofSeconds(5))
        //     .ignoring(NoSuchElementException.class);

        // WebElement foo = wait.until(new Function<WebDriver,WebElement>() {
        //      public WebElement apply(WebDriver driver){
        //         if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
        //             return driver.findElement(By.cssSelector("[id='finish'] h4"));
        //         }else
        //             return null;
        //      }
        // });
        // System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());

        // Actions a = new Actions(driver);

        //.doubleClick() to double click the text
        //.contextClick() to right click on element by mouse

        //Switching Windows
        // Set<String> windows = driver.getWindowHandles();
        // Interator<String> it = windows.iterator();
        // String parentId = it.next();
        // String childId = it.next();
        // driver.switchTo().window(childId);
    }
}