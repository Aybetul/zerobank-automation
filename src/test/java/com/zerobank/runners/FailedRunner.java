package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue="com/zerobank/stepdefinitions",
        features = "@target/rerun.txt",  // path for failed test
        plugin= {"html:target/failed-default-report",
                "json:target/failed_report.json",

        }

)
public class FailedRunner {
}
