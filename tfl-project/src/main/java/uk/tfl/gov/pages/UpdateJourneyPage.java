package uk.tfl.gov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.tfl.gov.utility.Utility;

public class UpdateJourneyPage extends Utility {

    public UpdateJourneyPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[normalize-space()='Clear To location']")
    WebElement clearToLocation;

    @FindBy (xpath = "//input[@id='InputTo']")
    WebElement toLocationTextBox;

    @FindBy (xpath = "//select[@id='Date']")
    WebElement selectDateDropDown;

    @FindBy (xpath = "//input[@id='plan-journey-button']")
    WebElement updateJourneyButton;



    public void enterUpdatedToDestination(String updatedToDestination){
        clickOnElement(clearToLocation);
        sendTextToElement(toLocationTextBox,updatedToDestination);
    }

    public void selectDateFromDropDown(String journeyDate){
        selectByVisibleTextFromDropDown(selectDateDropDown,journeyDate);
    }

    public void clickOnUpdateJourneyButton (){
        clickOnElement(updateJourneyButton);
    }
}
