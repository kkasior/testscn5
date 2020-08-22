import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FirstTests {

    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(); //otworz nową instancję chrome
        driver.manage().window().maximize(); //maksymalizuj przeglądarkę
    }
    @Test
    public void verifyDevToUrl(){
        String devToUrl = "https://dev.to";
        driver.get(devToUrl);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("urls aren't the same",devToUrl,currentUrl);
    }
    
}
