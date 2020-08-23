import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

        import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        podcastsButton.click();
        WebElement firstPodcast = driver.findElement(By.className("content"));
        //firstPodcast.click();
        WebElement firstPodcastText = driver.findElement(By.cssSelector(".content > h3:first-child"));
        highLightElement(driver,firstPodcastText);
        String firstPodcastTextValue = firstPodcastText.getText();
        firstPodcastTextValue = firstPodcastTextValue.substring(7);
        firstPodcast.click();
        WebElement podcastTitle = driver.findElement(By.cssSelector(".title > h1:nth-child(2)"));
        highLightElement(driver,podcastTitle);
        String podcastTitleText = podcastTitle.getText();

        assertEquals("script entered wrong podcast",firstPodcastTextValue,podcastTitleText);

        WebElement recordButton = driver.findElement(By.className("record-wrapper"));
        recordButton.click();

        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("status-message"))));

        String classAttributeOfRecordButton = recordButton.getAttribute("class");

        assertTrue("Podcast isn't played",classAttributeOfRecordButton.contains("playing"));
    }
    @Test
    public void goToWeekAndSelectTheFirstBlog(){
        List<WebElement> postsTimeCategoryItems = driver.findElements(By.className("crayons-tabs__item"));
        WebElement weekButton = postsTimeCategoryItems.get(1);
        highLightElement(driver,weekButton);
        weekButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlToBe("https://dev.to/top/week"));

        WebElement firstPostTitle = driver.findElement(By.cssSelector(".crayons-story__title > a:first-child"));
        highLightElement(driver,firstPostTitle);
        String firstPostTitleText = firstPostTitle.getText();
        firstPostTitle.click();
        WebElement postTitle = driver.findElement(By.cssSelector(".crayons-article__header__meta > h1:first-child"));
        highLightElement(driver,postTitle);
        String postTitleText = postTitle.getText();

        assertEquals("post titles mismatch",firstPostTitleText,postTitleText);
    }
}
