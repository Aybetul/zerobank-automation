package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
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


    @When("user creates new payee using following information")
    public void user_creates_new_payee_using_following_information(Map<String, String> dataTable) {
page.setName(dataTable.get("Payee Name"));
page.setAddress(dataTable.get("Payee Address"));
page.setAccount(dataTable.get("Account"));
page.setDetails(dataTable.get("Payee Details"));

    }


    @Then("user click on the add button")
    public void user_click_on_the_add_button() {
       page.clickOnAddBtn();
    }

    @Then("user verify   {string}  displayed")
    public void user_verify_displayed(String string) {
     String actual=page.getAddNewPayeeMessage();
     Assert.assertEquals(string,actual);
    }

    @Then("user verifies following currencies should be available")
    public void user_verifies_following_currencies_should_be_available(List<String > dataTable) {
        List<String> actual=page.getCurrencyObtions();
        Assert.assertTrue(actual.containsAll(dataTable));
    }

    @When("user enters currency {string}")
    public void user_enters_currency(String string) {
      page.selectCurrency(string);
    }

    @When("user enters amount {string}")
    public void user_enters_amount(String string) {
       page.setAmount_currencyInput(string);
    }

    @Then("user select radioButton")
    public void user_select_radioButton() {
       page.setDollarSelectBtn();
    }

    @Then("user click on Purchase")
    public void user_click_on_Purchase() {
       page.clickOnPurchaseBtn();
    }
    @Then("user verifies error message is displayed {string}")
    public void user_verifies_error_message_is_displayed(String string) {
        String actual=  page.getAlertMessage();
        Assert.assertEquals(string,actual);
    }





}