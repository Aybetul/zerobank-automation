package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage extends PageBase {
   @FindBy(className = "board-header")
    private List<WebElement> tabs;

   @FindBy(xpath ="//h2[text()='Credit Accounts']/following-sibling::div[1]/div/table/thead/tr/th" )
   private List<WebElement> columns_CreditAccount;




public List<String> getTabNames(){
   return    BrowserUtilities.TextFromWebElement(tabs);
   }

public List<String> getcolumns(){
 return   BrowserUtilities.TextFromWebElement(columns_CreditAccount);
   }

public void clickOnTheLink(String linkName){
    driver.findElement(By.xpath("//a[text()='"+linkName+"']")).click();
}

}
