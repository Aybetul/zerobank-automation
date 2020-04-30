package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Account_Summary_steps {
AccountSummaryPage page=new AccountSummaryPage();
MainPage main= new MainPage();

    @Then("user verify following account types")
    public void user_verify_following_account_types(List<String> dataTable) {
     List<String > actual=page.getTabNames();
        Assert.assertEquals(actual,dataTable);
    }

    @Then("user should verify following options")
    public void user_should_verify_following_options(List<String> dataTable) {
   List<String>actual= page.getcolumns();
        Assert.assertEquals(actual,dataTable);

    }

    @Then("User should verify the title is {string}")
    public void user_should_verify_the_title_is(String string) {
     String actual= main.getTitle();
     Assert.assertEquals(string,actual);
    }

    @When("user clicks on the {string}")
    public void user_clicks_on_the(String string) {
        page.clickOnTheLink(string);
    }


}
