package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage  extends PageBase{

    @FindBy(xpath="//select[@name='accountId']")
    private WebElement accountOption;

    @FindBy(xpath="//tr/th")
    private List<WebElement> tableHeaders;

    @FindBy(xpath="//input[@id='aa_fromDate']")
    private WebElement dateFrom;

    @FindBy(xpath="//input[@id='aa_toDate']")
    private WebElement dateTo;

    @FindBy (xpath="//button[@class ='btn btn-primary']")
    private  WebElement FindBtn;

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    private List<WebElement> dateList;

    @FindBy (xpath="//input[@id='aa_description']")
    private  WebElement DescriptionInput;

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    private List<WebElement> DescriptionLst;

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]")
    private List<WebElement> withdrawalLst;

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    private List<WebElement> DepositLst;

    @FindBy (xpath  ="//div[contains(text(),'No results.')]")
    private  WebElement NoResult;

    @FindBy(xpath = "//select[@id='aa_type']")
     private  WebElement typeInput;

    @FindBy(xpath = "(//th[text()='Deposit'])[2]")
    private  WebElement deposit;

     public  void selectType(String str){
        wait.until(ExpectedConditions.visibilityOf(typeInput));
        Select select = new Select(typeInput);
        select.selectByVisibleText(str);
    }

      public List<String > getDepositList(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(deposit));
        return  BrowserUtilities.TextFromWebElement(DepositLst);
}

      public List<String > getWithdrawalList(){
        wait.until(ExpectedConditions.visibilityOf(deposit));
        BrowserUtilities.waitForPageToLoad(10);
        return  BrowserUtilities.TextFromWebElement(withdrawalLst);
    }

      public String getNoresultText(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'No results.')]")));
        return  NoResult.getText();
    }

       public void setDescriptionInput(String des){
        wait.until(ExpectedConditions.visibilityOf(DescriptionInput)).sendKeys(des);
    }

      public boolean verifyDescriptionResultContainsGivenWord(String word){
        boolean result=true;
    List<String> descriptionLst=BrowserUtilities.TextFromWebElement(DescriptionLst);
    for(String each: descriptionLst){
        result= each.contains(word);
        if(result==false){
            break;
        }
    }
return result;
}

      public boolean verifyNotContainsTheDate(String date){
        List<String > strDateLst=BrowserUtilities.TextFromWebElement(dateList);
       return   !strDateLst.contains(date);
    }

       public void verifyDatesBetweenGiven(String date1, String date2){
    int date1Int=Integer.parseInt(date1.replace("-",""));
    int date2Int=Integer.parseInt(date2.replace("-",""));

    for(String  each:BrowserUtilities.TextFromWebElement(dateList)){
       int  each2= Integer.parseInt(each.replace("-",""));
        if(each2<=date1Int && each2>=date2Int){
            System.out.println("date passed ");
            Assert.assertTrue(true);
        }else{
        //  String each3=Integer.
            System.out.println(each2 +"date didn't passed");
            Assert.assertFalse("date didn't pass the condition",false);
        }
    }
}

      public void verifyDatesSorted(){
    List<String> strDateLst=BrowserUtilities.TextFromWebElement(dateList);
    List<Integer>listInt=new ArrayList<>();

    for(int i=0; i<strDateLst.size();i++){
   int current=Integer.parseInt(strDateLst.get(i).replace("-",""));
     listInt.add(current);
    }

for(int i=0; i<listInt.size()-1; i++){
    Assert.assertTrue(listInt.get(i)>listInt.get(i+1));
    System.out.println("dates sorted most recent date ");
    }
}

      public void setDate(String date1,String date2){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_fromDate")));
        dateFrom.sendKeys(date1);
        dateTo.sendKeys(date2, Keys.ENTER);
    }

       public void clickOnFind(){
  // wait.until(ExpectedConditions.elementToBeClickable(FindBtn));
        BrowserUtilities.wait(5);
      FindBtn.click();
        System.out.println("clicked on find button");
    }

       public  List<String> getTableHeaders() {
    return BrowserUtilities.TextFromWebElement(tableHeaders);
}

        public  String  getFirstOption(){
            BrowserUtilities.wait(3);
        Select select= new Select(accountOption);
     //   wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("//select[@name='accountId']")));
            System.out.println("get first option");
        return   select.getFirstSelectedOption().getText();

}

        public List<String > getAllOptions(){
        Select select= new Select(accountOption)   ;
        return  BrowserUtilities.TextFromWebElement(select.getOptions()) ;
    }

        public void clickOnTheBtn(){
    accountOption.click();
}


}
