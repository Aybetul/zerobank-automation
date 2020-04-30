package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


  @Before
  public void setup(){
      System.out.println("Welcome to Zero Bank");
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot= (TakesScreenshot)Driver.getDriver();
            byte[] image=takesScreenshot.getScreenshotAs(OutputType.BYTES);
            // attach the screenshots to the report
            scenario.embed(image,"image/png",scenario.getName());
        }
        System.out.println("test clean up");
        Driver.closeDriver();
    }
}
