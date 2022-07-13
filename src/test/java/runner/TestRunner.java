package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features",
        glue = {"stepDefinitions", "Hooks"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:test-output/failed_scenarios.txt"},
        dryRun = false,
        publish = true,
        tags = "@Demo",
        monochrome = false)

public class TestRunner {


}




