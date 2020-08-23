package bdd.tests.devto;

import bdd.tests.pageObjects.DevToMainPage;
import bdd.tests.pageObjects.PodcastListPage;
import bdd.tests.pageObjects.SinglePodcastPage;
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

    String firstPodcastTextValue;
    String podcastTitle;

    DevToMainPage devToMainPage;
    PodcastListPage podcastListPage;
    SinglePodcastPage singlePodcastPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(); //otworz nową instancję chrome
        driver.manage().window().maximize(); //maksymalizuj przeglądarkę
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("I am on the main dev.to page")
    public void i_am_on_the_main_dev_to_page() {
        devToMainPage = new DevToMainPage(driver);
    }
    @When("I click the podcasts button")
    public void i_click_the_podcasts_button() {
        podcastListPage = devToMainPage.selectPodcasts();
    }
    @When("I select the first podcast from list")
    public void i_select_the_first_podcast_from_list() {
        podcastTitle = podcastListPage.getPodcastTitleFromList(podcastListPage.firstPodcast);
        singlePodcastPage = podcastListPage.selectPodcast(podcastListPage.firstPodcast);
    }
    @When("I clik on the play button")
    public void i_clik_on_the_play_button() {
        singlePodcastPage.clickThePlayButton();
    }
    @Then("I should be able to listen to the podcast")
    public void i_should_be_able_to_listen_to_the_podcast() {
        boolean isPodcastPlaying = singlePodcastPage.isRecordButtonOn();
        assertTrue("Podcast isn't played",isPodcastPlaying);
    }
}
