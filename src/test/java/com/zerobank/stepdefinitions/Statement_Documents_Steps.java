package com.zerobank.stepdefinitions;

import com.zerobank.pages.Statement_DocumentsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Statement_Documents_Steps {

Statement_DocumentsPage page=new Statement_DocumentsPage();

    @When("user select the Resent statement {string}")
    public void user_select_the_Resent_statement(String string) {
       page.selectYear(string);
    }



    @Then("verify {string} statements should be displayed for that {string}")
    public void verify_statements_should_be_displayed_for_that(String string, String string2) {
        List<String> actual=page.getDataList(string2);
        String a=Integer.toString(actual.size());
        Assert.assertEquals(string,a);

    }



}
