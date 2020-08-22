import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FirstTests {

    WebDriver driver;
    String devToUrl = "https://dev.to/";

    public void highLightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(); //otworz nową instancję chrome
        driver.manage().window().maximize(); //maksymalizuj przeglądarkę
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(devToUrl);
    }
    @Test
    public void verifyDevToUrl(){
        String currentUrl = driver.getCurrentUrl();
        assertEquals("urls aren't the same",devToUrl,currentUrl);
    }
    @Test
    public void goToPodcastsAndOpenFirstPodcast(){
        WebElement podcastsButton = driver.findElement(By.xpath("//a[@href='/pod']"));
        //highLightElement(driver,podcastsButton);
        podcastsButton.click();
        WebElement firstPodcast = driver.findElement(By.className("content"));
        highLightElement(driver,firstPodcast);
    }
}
