package Hooks;

import Util.Config_Reader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseHooks {

    public static WebDriver driver = null;
    private final Config_Reader config_reader = new Config_Reader();

    @Before
    public void openBrowser() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config_reader.getURL());
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @AfterStep
    public void addScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] srcFile = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcFile, "image/png", " Screenshot" + "/" + scenario.getName());
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }


    public static WebDriver getDriver() {
        return driver;
    }
}
