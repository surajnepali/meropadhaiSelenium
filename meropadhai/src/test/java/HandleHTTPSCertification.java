import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleHTTPSCertification {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        // Proxy Information
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipAddress:portNumber");
        options.setCapability("proxy", proxy);

        // Handling Insecure Certiication
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        
        // To Delete all the cookies
        driver.manage().deleteAllCookies();

        // To delete a specific cookie
        driver.manage().deleteCookieNamed("cookieName could be sessionKey");
        driver.get("https://expired.badssl.com");
        System.out.println(driver.getTitle());;
    }
}
