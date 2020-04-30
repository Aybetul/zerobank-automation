package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayBillsPage extends  PageBase {

@FindBy(id="sp_amount")
    private WebElement amount;

    @FindBy(id="sp_date")
    private WebElement date;

    @FindBy(id="alert_content")
    private WebElement message;

    @FindBy (xpath = "//input[@class='btn btn-primary']")
    private  WebElement payBtn;

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
