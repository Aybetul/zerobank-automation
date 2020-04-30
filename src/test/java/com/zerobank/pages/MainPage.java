package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageBase {

    public String getTitle(){
     //   wait.until(ExpectedConditions.presenceOfElementLocated(By.className("board-header")));
        return    driver.getTitle();
    }
public void navigateTo(String module){
      BrowserUtilities.waitForPageToLoad(10);
        driver.findElement(By.xpath("//a[text()='"+module+"']")).click();
}




}
