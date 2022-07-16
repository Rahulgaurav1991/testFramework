package Util;

import Hooks.BaseHooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UISteps {


    public WebElement webAction(final By locator) {     //this is fluent wait

        Wait<WebDriver> wait = new FluentWait<WebDriver>(BaseHooks.getDriver())
                .withTimeout(Duration.ofSeconds(50)) // max time
                .pollingEvery(Duration.ofSeconds(5)) // every 5 seconds
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(Throwable.class)
                .withMessage(
                        "Webdriver waited for 50 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    // this method is use for display the title
    public String waitForTitleDisplay(String title) {
        new WebDriverWait(BaseHooks.getDriver(), 20).until(ExpectedConditions.titleIs(title));
        return title;
    }
//

    public WebElement waitForElementToDisplay(By locator) {
        try {
            return new WebDriverWait(BaseHooks.getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Boolean waitForElementNotDisplay(By locator) {
        try {
            return new WebDriverWait(BaseHooks.getDriver(), 20).until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void doClick(By locator) {
        waitForElementToDisplay(locator).click();
    }

    // to get single text
    public String getTextFromElement(By locator) {
        return waitForElementToDisplay(locator).getText();
    }


    // to Get Element from list
    public List<String> getElementFromList(By locator) {

        List<String> list = new ArrayList<String>();
        try {
            List<WebElement> elements = waitForElementToDisplay(locator).findElements(locator);
            for (WebElement name : elements) {
                list.add(name.getText());
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public String getTextFromMultipleElements(By locator) {
        String text = null;
        try {
            List<WebElement> elements = waitForElementToDisplay(locator).findElements(locator);
            for (WebElement name : elements) {
                text = name.getText();
            }
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    public void javascriptScroll(By locator, WebElement element) {
        try {
            waitForElementToDisplay(locator);
            JavascriptExecutor js = (JavascriptExecutor) BaseHooks.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveToElement(WebElement element) {
        try {
            new Actions(BaseHooks.getDriver()).moveToElement(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public List<Integer> getTextFromNumber(By locator) {
        try {
            List<Integer> list = new ArrayList<>();
            List<String> value = getElementFromList(locator);
            for (String name : value) {
                list.add(Integer.parseInt(name.replaceAll("[^0-9]", "")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean verifyDisplay(WebElement element) {
        return element.isDisplayed();

    }

    public void enterValues(By locator, String value) {
        try {
            waitForElementToDisplay(locator).sendKeys(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getTextFromAttribute(By locator, String value) {
        return waitForElementToDisplay(locator).getAttribute(value);
    }

    public void selectValueFromDropdown(By locator, String selectType, String value) {
        Select select = new Select(waitForElementToDisplay(locator).findElement(locator));
        switch (selectType) {
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "visibleText":
                select.selectByVisibleText(value);
                break;
            default:
                System.out.println(selectType + ":" + "is not found" + ":" + value);

        }
    }





}
