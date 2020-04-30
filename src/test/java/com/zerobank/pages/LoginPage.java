package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {


    @FindBy(xpath = "//button[@id='signin_button']")
    private WebElement signinBtn;

    @FindBy(id = "user_login")
    private WebElement username;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement errorMess;



    @FindBy(xpath = "(//b[@class='caret'])[2]")
    private  WebElement logout;

    public void clickOnLogout (){
        logout.click();
        driver.findElement(By.id("logout_link")).click();
    }



public void clickOnthesigninBtn(){
    BrowserUtilities.waitForPageToLoad(10);
   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signin_button']")));
   wait.until(ExpectedConditions.elementToBeClickable(signinBtn)).click();
}

public void login(String name, String pass){

    wait.until(ExpectedConditions.visibilityOf(username));
    username.sendKeys(name);
    password.sendKeys(pass, Keys.ENTER);

}

public String getErrorMess(){
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert alert-error")));
  return   errorMess.getText().trim();
}

    public String currentTab(String tabName){
        String str= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+tabName+"']"))).getText();
        System.out.println("we are on the "+tabName);
        return str;
    }






}
