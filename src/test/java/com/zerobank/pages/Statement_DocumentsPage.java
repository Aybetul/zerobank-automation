package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;

public class Statement_DocumentsPage extends  PageBase {



public List<WebElement> getDataList(String year){
    BrowserUtilities.wait(10);
    List<WebElement> dataList= driver.findElements(By.xpath("//div[@id='os_"+year+"']/table/tbody/tr/td[1]/a"));

return dataList;
}

    public void selectYear(String year){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong")));
        driver.findElement(By.xpath("//a[text()='"+year+"']")).click();
    }






}
