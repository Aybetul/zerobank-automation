package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class Pay_Bills_Steps {
PayBillsPage page= new PayBillsPage();



    @When("user enter date and amount")
    public void user_enter_date_and_amount(Map<String, String> data ) {
        page.setAmount(data.get("amount"));
        page.setDate(data.get("date"));
    }


    @Then("user should verify the {string} message is displayed")
    public void user_should_verify_the_message_is_displayed(String string) {
String actual= page.getMessage();
        Assert.assertEquals(string,actual);

        //Expected :Please fill out this field message!
        //   Actual   :The payment was successfully submitted.
    }
    @Then("user click on the pay button")
    public void user_click_on_the_pay_button() {
      page.clickOnPayBtn();
    }

}
