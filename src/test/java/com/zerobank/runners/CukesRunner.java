package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        glue="com/zerobank/stepdefinitions",
        features = "src/test/resources/features",
      //  dryRun=true,
        dryRun=false,
        strict =true,
        tags="",
        plugin= {"html:target/default-report",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }

)
public class CukesRunner {

}
