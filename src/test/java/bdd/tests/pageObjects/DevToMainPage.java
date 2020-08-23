package bdd.tests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevToMainPage {

    //@FindBy(name="uid")
    //
    //    WebElement user99GuruName;
    @FindBy(xpath = "//a[@href='/pod']")
    WebElement podcastsButton;

    WebDriver driver;
    String url = "https://dev.to/";

    public DevToMainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(this.url);
        PageFactory.initElements(driver,this);
    }
    public PodcastListPage selectPodcasts(){
        podcastsButton.click();
        return new PodcastListPage(driver);
    }

}
