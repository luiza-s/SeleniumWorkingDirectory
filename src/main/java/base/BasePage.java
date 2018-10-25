package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class BasePage {

    public abstract String getURL();

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void type(By location, String text) {
        type(find(location), text);
    }

    public WebElement find(By location) {
        return driver.findElement(location);
    }

    public void type(String cssSelector, String text) {
        type(By.cssSelector(cssSelector), text);
    }

    public List<WebElement> findElements(By location) {
        return driver.findElements(location);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(By location) {
        click(find(location));
    }

    public boolean isDisplayed( WebElement element) {
        try {
            return element.isDisplayed();
        }
        catch(NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean isDisplayed(By location) {
         try {
            return find(location).isDisplayed();
           }
        catch(NoSuchElementException e)
        {
            return false;
        }
    }
}