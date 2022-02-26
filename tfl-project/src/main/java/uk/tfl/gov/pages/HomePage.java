package uk.tfl.gov.pages;

import org.apache.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uk.tfl.gov.utility.Utility;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//strong[normalize-space()='Accept all cookies']")
    WebElement acceptCookies;

    @FindBy(xpath = "//strong[normalize-space()='Done']")
    WebElement cookieMessage;

    @FindBy(xpath = "//input[@id='InputFrom']")
    WebElement fromDestination;

    @FindBy(xpath = "//input[@id='InputTo']")
    WebElement toDestination;

    @FindBy(xpath = "//input[@id='plan-journey-button']")
    WebElement planMyJourneyButton;

    @FindBy(xpath = "//span[@data-valmsg-for='InputFrom']")
    WebElement blankFieldMessage;

    @FindBy(xpath = "//a[normalize-space()='Recents']")
    WebElement recents;

    public void verifyUserIsOnTheTflHomePage(){
        String expected = "https://tfl.gov.uk/";
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));

        clickOnElement(acceptCookies);
        clickOnElement(cookieMessage);
    }

    public void enterFromDestination(String from){
        sendTextToElement(fromDestination, from);
    }

    public void enterToDestination(String to){
        sendTextToElement(toDestination, to);
    }

    public void clickOnPlanMyJourneyButton(){
        clickOnElement(planMyJourneyButton);
    }

    public void userIsGettingNoResults(){
        verifyActualAndExpectedText(blankFieldMessage.getText(), "The From field is required.", "No message");
    }
}
