package uk.tfl.gov.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.tfl.gov.pages.HomePage;
import uk.tfl.gov.pages.JourneyResultsPage;
import uk.tfl.gov.pages.UpdateJourneyPage;

public class MyStepdefs {
    @Given("^User is on the TFL website homepage$")
    public void userIsOnTheTFLWebsiteHomepage() {
        new HomePage().verifyUserIsOnTheTflHomePage();
    }

    @When("^User enters \"([^\"]*)\" from destination$")
    public void userEntersFromDestination(String from)  {
    new HomePage().enterFromDestination(from);
    }

    @And("^User enters \"([^\"]*)\" to destination$")
    public void userEntersToDestination(String to)  {
        new HomePage().enterToDestination(to);
    }

    @And("^User clicks on 'Plan my journey' button$")
    public void userClicksOnPlanMyJourneyButton() {
        new HomePage().clickOnPlanMyJourneyButton();
    }

    @Then("^User is on Journey results page$")
    public void userIsOnJourneyResultsPage() {
        new JourneyResultsPage().verifyUserIsOnJourneyResultsPage();
    }

    @When("^User enters invalid \"([^\"]*)\" from destination$")
    public void userEntersInvalidFromDestination(String from1) {
        new HomePage().enterFromDestination(from1);
    }

    @And("^User enters invalid \"([^\"]*)\" to destination$")
    public void userEntersInvalidToDestination(String to1) {
        new HomePage().enterToDestination(to1);
    }

    @And("^User clicks on 'Plan my journey' button to find the route$")
    public void userClicksOnPlanMyJourneyButtonToFindTheRoute() {
        new HomePage().clickOnPlanMyJourneyButton();
    }

    @Then("^User is getting an \"([^\"]*)\" error message$")
    public void userIsGettingAnErrorMessage() {
        new JourneyResultsPage().verifyUserIsGettingAnErrorMessage();
    }

    @When("^User does not put \"([^\"]*)\" from destination$")
    public void userDoesNotPutFromDestination(String noFrom) {
        new HomePage().enterFromDestination(noFrom);
    }

    @And("^User does not enter \"([^\"]*)\" to destination$")
    public void userDoesNotEnterToDestination(String noTo) {
    }

    @And("^User clicks 'Plan my journey' option$")
    public void userClicksPlanMyJourneyOption() {
        new HomePage().clickOnPlanMyJourneyButton();
    }

    @Then("^User is not getting any Journey results$")
    public void userIsNotGettingAnyJourneyResults() {
        new HomePage().userIsGettingNoResults();
    }

    @And("^User clicks on 'Edit Journey' label$")
    public void userClicksOnEditJourneyLabel() {
        new JourneyResultsPage().clickOnEditJourneyLabel();
    }

    @And("^User change \"([^\"]*)\" to destination$")
    public void userChangeToDestination(String updatedToDestination) {
        new UpdateJourneyPage().enterUpdatedToDestination(updatedToDestination);
            }

    @And("^User select 'tomorrow' date from dropdown$")
    public void userSelectTomorrowDateFromDropdown() {
        new UpdateJourneyPage().selectDateFromDropDown("Tomorrow");
    }

    @And("^User clicks on 'Update Journey' button$")
    public void userClicksOnUpdateJourneyButton() {
        new UpdateJourneyPage().clickOnUpdateJourneyButton();
    }

    @Then("^User is on Journey results page with new \"([^\"]*)\" to destination$")
    public void userIsOnJourneyResultsPageWithNewToDestination(String updatedToDestination) {
        new JourneyResultsPage().verifyUserIsOnJourneyResultsPage();
        new JourneyResultsPage().verifyToDestinationHasChanged(updatedToDestination);
    }
}
