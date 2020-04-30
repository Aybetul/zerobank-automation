package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_Step_Definitions {
LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {

        String URL= ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(URL);
        System.out.println("user on the landing page");
    }
    @Given("user clicks on the Singin button")
    public void user_clicks_on_the_Singin_button() {
     loginPage.clickOnthesigninBtn();
        System.out.println("user clicked on the sing in button");

    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String string, String string2) {
       loginPage.login(string,string2);
        System.out.println("entered credentials");
    }

    @Then("user should verify the page is {string}")
    public void user_should_verify_the_page_is(String string) {
        String actual= loginPage.currentTab(string);
        Assert.assertEquals(actual,string);
        System.out.println("verify tab ");
    }
    @Then("user logs out")
    public void user_logs_out() {
      loginPage.clickOnLogout();
    }


    @Then("user should verify the {string} is displayed")
    public void user_should_verify_the_is_displayed(String string) {
    String actual=loginPage.getErrorMess();
    Assert.assertEquals(actual,string);
        System.out.println("verify error message");
    }







}
