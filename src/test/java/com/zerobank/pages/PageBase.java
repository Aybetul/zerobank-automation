package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver driver= Driver.getDriver();
    protected WebDriverWait wait=new WebDriverWait(driver,15);
    public PageBase(){
        PageFactory.initElements(driver,this);
    }

    public void NavigateToTab(String tab){
        BrowserUtilities.waitForPageToLoad(10);
        driver.findElement(By.xpath("//a[text()='"+tab+"']")).click();
    }


}
