package bdd.tests.devto;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class DevToStepsDefinitions {

    WebDriver driver;
    String devToUrl = "https://dev.to/";
    String firstPodcastTextValue;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(); //otworz nową instancję chrome
        driver.manage().window().maximize(); //maksymalizuj przeglądarkę
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("I am on the main dev.to page")
    public void i_am_on_the_main_dev_to_page() {
        driver.get(devToUrl);
    }
    @When("I click the podcasts button")
    public void i_click_the_podcasts_button() {
        WebElement podcastsButton = driver.findElement(By.xpath("//a[@href='/pod']"));
        podcastsButton.click();
    }
    @When("I select the first podcast from list")
    public void i_select_the_first_podcast_from_list() {
        WebElement firstPodcast = driver.findElement(By.cssSelector(".content > h3:first-child"));
        firstPodcastTextValue = firstPodcast.getText();
        firstPodcastTextValue = firstPodcastTextValue.substring(7);
        firstPodcast.click();
    }
    @When("I clik on the play button")
    public void i_clik_on_the_play_button() {
        WebElement recordButton = driver.findElement(By.className("record-wrapper"));
        recordButton.click();
    }
    @Then("I should be able to listen to the podcast")
    public void i_should_be_able_to_listen_to_the_podcast() {
        WebElement recordButton = driver.findElement(By.className("record-wrapper"));
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("status-message"))));
        String classAttributeOfRecordButton = recordButton.getAttribute("class");
        assertTrue("Podcast isn't played",classAttributeOfRecordButton.contains("playing"));

    }
}
