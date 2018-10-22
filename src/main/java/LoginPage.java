import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    By username = By.name("login");
    By password = By.id("password");
    By signIn=By.name("commit");
    By validationMessage=By.cssSelector("#js-flash-container .flash-error");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        driver.get("https//github.com/login");
    }

    public void loginWith(String login, String pass){
        driver.findElement(username).sendKeys(login);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(validationMessage).click();
    }

    public boolean isErrorMessageDisplayed(){
        return driver.findElement(validationMessage).isDisplayed();
    }
}
