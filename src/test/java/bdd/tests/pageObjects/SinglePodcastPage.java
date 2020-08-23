package bdd.tests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SinglePodcastPage {

    @FindBy(className = "record-wrapper")
            public WebElement recordButton;

    WebDriver driver;
    public SinglePodcastPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickThePlayButton(){
        recordButton.click();
    }

    public boolean isRecordButtonOn(){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("status-message"))));
        String classAttributeOfRecordButton = recordButton.getAttribute("class");
        boolean isPodcastPlaying = classAttributeOfRecordButton.contains("playing");
        return isPodcastPlaying;
    }
}
