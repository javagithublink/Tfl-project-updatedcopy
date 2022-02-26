package uk.tfl.gov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uk.tfl.gov.utility.Utility;

public class JourneyResultsPage extends Utility {

    public JourneyResultsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='jp-results-headline']")
    WebElement journeyResults;

    @FindBy(xpath = "//li[@class='field-validation-error']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Edit journey']")
    WebElement editJourneyLabel;

    @FindBy (xpath = "//span[text()='To:']//parent::div//child::span[2]//strong[1]")
    WebElement toDestinationText;


    public void verifyUserIsOnJourneyResultsPage() {
        verifyActualAndExpectedText(journeyResults.getText(), "Journey results", "Incorrect page");
    }

    public void verifyUserIsGettingAnErrorMessage() {
        verifyActualAndExpectedText(errorMessage.getText(), "Sorry, we can't find a journey matching your criteria", "Incorrect destination");
    }

    public void clickOnEditJourneyLabel(){

        clickOnElement(editJourneyLabel);
    }

    public void verifyToDestinationHasChanged (String updatedToDestination){
        String actual = toDestinationText.getText();
        Assert.assertTrue(actual.contains(updatedToDestination));
    }

}

