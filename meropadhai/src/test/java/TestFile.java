import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFile {
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.meropadhai.com/course/test-videos-padhai-636df0fbdbfcb25708fa5172");
    }

}
