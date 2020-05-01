package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class PayBillsPage extends  PageBase {

@FindBy(id="sp_amount")
    private WebElement amount;

    @FindBy(id="sp_date")
    private WebElement date;

    @FindBy(id="alert_content")
    private WebElement message;

    @FindBy (xpath = "//input[@class='btn btn-primary']")
    private  WebElement payBtn;

    @FindBy (xpath = "//input[@value='Add']")
    private  WebElement addBtn;

    @FindBy(id="np_new_payee_name")
    private WebElement NameInput;

    @FindBy(id="np_new_payee_address")
    private WebElement addressInput;

    @FindBy(id="np_new_payee_account")
    private WebElement accountInput;

    @FindBy(id="np_new_payee_details")
    private WebElement detailsInput;

    @FindBy(xpath = "//div[@id='alert_content']")
    private WebElement addNewPayeeMessage;

    @FindBy(id="pc_currency")
    private WebElement selectCurrency;

    @FindBy(xpath="//input[@id='pc_amount']")
    private WebElement amount_currencyInput;

    @FindBy(id="pc_inDollars_true")
    private WebElement dollarSelectBtn;

    @FindBy(id="purchase_cash")
    private WebElement purchaseBtn;


    public String  getAlertMessage(){
        Alert alert=driver.switchTo().alert();
     String alertmess= alert.getText();
     alert.accept();
     return alertmess;

    }


    public    List<String>  getCurrencyObtions(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pc_currency")));
        wait.until(ExpectedConditions.visibilityOf(selectCurrency));
        Select select=new Select(selectCurrency);
       List<String> currencyList= BrowserUtilities.TextFromWebElement(select.getOptions());
       return currencyList;
    }

    public void clickOnPurchaseBtn(){
        purchaseBtn.click();
    }
    public void setDollarSelectBtn(){
        dollarSelectBtn.click();
    }

public void selectCurrency(String c){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pc_currency")));
    Select select=new Select(selectCurrency);
    select.selectByVisibleText(c);
}

  public void setAmount_currencyInput(String amount){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='pc_amount']")));
        wait.until(ExpectedConditions.visibilityOf(amount_currencyInput));
    amount_currencyInput.sendKeys(amount);
  }


    public String getAddNewPayeeMessage(){
      return   addNewPayeeMessage.getText();
    }

     public void setName(String name){
    wait.until(ExpectedConditions.visibilityOf(NameInput)).sendKeys(name);
}

    public void setAddress(String  address){
addressInput.sendKeys(address);
    }
    public void setAccount(String account){
      BrowserUtilities.wait(2);
      wait.until(ExpectedConditions.visibilityOf(accountInput));
accountInput.sendKeys(account);
    }
    public void setDetails(String details ){
detailsInput.sendKeys(details);
    }
    public void clickOnAddBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        addBtn.click();
    }
    public void clickOnPayBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(payBtn));
        payBtn.click();
    }

public  void setAmount(String amount1){
    BrowserUtilities.waitForPageToLoad(10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sp_amount")));
    amount.sendKeys(amount1);
}

    public  void setDate(String date1){
        date.sendKeys(date1, Keys.ENTER);
    }

   public String  getMessage(){
    wait.until(ExpectedConditions.visibilityOf(message));
    return message.getText();
}


}
