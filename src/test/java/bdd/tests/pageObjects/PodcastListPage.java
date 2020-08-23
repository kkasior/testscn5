package bdd.tests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PodcastListPage {

    @FindBy(css = ".content > h3:first-child")
    public WebElement firstPodcast;

    WebDriver driver;

    public PodcastListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getPodcastTitleFromList(WebElement podcastFromList){
        String podcastTitle = podcastFromList.getText();
        podcastTitle = podcastTitle.substring(7);
        return podcastTitle;
    }
    public SinglePodcastPage selectPodcast(WebElement podcast){
        podcast.click();
        return new SinglePodcastPage(driver);
    }

}
