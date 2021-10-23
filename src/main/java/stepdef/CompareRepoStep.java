package stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BaseClass;
import pages.RepositoryPage;

public class CompareRepoStep extends RepositoryPage {

    @Given("^I am on the landing page of Django github repo$")
    public void i_am_on_the_landing_page_of_Django_github_repo() throws Throwable {
        openHomeURL();
    }

    @And("^I click on repositories option$")
    public void i_click_on_repositories_option() throws Throwable {
        clickRepoTab();
    }

    @Then("^I should be able to see and capture all the listed repositories and their description$")
    public void i_should_be_able_to_see_and_capture_all_the_listed_repositories_and_their_description() throws Throwable {
        fetchRepoName();
        fetchRepoDesc();
    }

    @Then("^I compare the values against the values received through API response$")
    public void i_compare_the_values_against_the_values_received_through_API_response() throws Throwable {
        getRepoNamesApi();
        getRepoDescriptionApi();
        compareDescription();
        compareName();

    }
}
