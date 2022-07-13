package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "@test-output/failed_scenarios.txt",
        glue={"stepDefinitions","Hooks"},
        plugin = {"pretty","rerun:target/failed_run.txt","html:target/cucumber.html","json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        publish = true,
        monochrome = false) // to  print the steps at console

public class FailedTestRunner {


}




