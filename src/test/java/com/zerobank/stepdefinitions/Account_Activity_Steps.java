package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Account_Activity_Steps {
MainPage main= new MainPage();
AccountActivityPage page= new AccountActivityPage();

    @Then("user navigates to {string}")
    public void user_navigates_to(String string) {
    main.navigateTo(string);
    }

    @Then("user verify default option should be {string}")
    public void user_verify_default_option_should_be(String string) {
    String actual=page.getFirstOption();
        Assert.assertEquals(string ,actual);
    }

    @Then("User clicks on the drop down")
    public void user_clicks_on_the_drop_down() {
    page.clickOnTheBtn();
    }

    @Then("user verifies following drop down options")
    public void user_verifies_following_drop_down_options(List<String > dataTable ) {
        List<String > actual= page.getAllOptions();
        Assert.assertNotEquals(dataTable, actual);
        //  Actual=>([Savings, Checking, Savings, Loan, Credit Card, Brokerage])
        // Given=>([Savings, Checking, Loan, Credit Card, Brokerage])
    }

    @Then("user verifies transactions table have following names")
    public void user_verifies_transactions_table_have_following_names(List<String > dataTable) {
     List<String> actual=page.getTableHeaders();
     Assert.assertEquals(dataTable,actual);
    }

    @When("user access navigates to {string}")
    public void user_access_navigates_to(String string) {
     page.NavigateToTab(string);
    }

    @Then("user enter the date range {string} and {string}")
    public void user_enter_the_date_range_and(String string, String string2) {
      page.setDate(string,string2);
    }

    @When("click on find")
    public void click_on_find() {
      page.clickOnFind();
    }
    @When("result table should display only date range {string} and {string}")
    public void result_table_should_display_only_date_range_and(String string, String string2) {
       page.verifyDatesBetweenGiven(string, string2);
    }


    @When("verify result sorted by most recent date")
    public void verify_result_sorted_by_most_recent_date() {
     page.verifyDatesSorted();
    }

    @Then("verify the the date list not contains {string}")
    public void verify_the_the_date_list_not_contains(String string) {
   Assert.assertTrue( page.verifyNotContainsTheDate(string));
    }

    @Then("user enters description {string}")
    public void user_enters_description(String string) {
      page.setDescriptionInput(string);
    }

    @Then("verify result table should show only containing {string}")
    public void verify_result_table_should_show_only_containing(String string) {
  Assert.assertTrue( page.verifyDescriptionResultContainsGivenWord(string));

    }


    @Then("verify system display {string}")
    public void verify_system_display(String string) {
   String actual=  page.getNoresultText().trim();
   Assert.assertEquals(string,actual);
    }

    @Then("verify result table should show at lest one result under Deposit")
    public void verify_result_table_should_show_at_lest_one_result_under_Deposit() {
       Assert.assertTrue("Verify deposit list result ",page.getDepositList().size()>=1);
    }

    @Then("verify result table should show at lest one result under Withdrawal")
    public void verify_result_table_should_show_at_lest_one_result_under_Withdrawal() {
        Assert.assertTrue(page.getWithdrawalList().size()>=1);
    }

    @When("user select type {string}")
    public void user_select_type(String string) {
       page.selectType(string);
    }

    @Then("verify result table should show no result under Withdrawal")
    public void verify_result_table_should_show_no_result_under_Withdrawal() {
        Assert.assertTrue(page.getWithdrawalList().size()==0);
    }

    @Then("verify result table should show no result under Deposit")
    public void verify_result_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue(page.getDepositList().size()==0);
    }
}
