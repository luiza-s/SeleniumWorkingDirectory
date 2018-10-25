import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {

    private WebDriver driver;
    By username = By.name("login");
    By password = By.id("password");
    By signIn=By.name("commit");
    By validationMessage=By.cssSelector("#js-flash-container .flash-error");

    public LoginPage(WebDriver driver){
        super (driver);
        driver.get(getURL());
    }

//    @Override
//    public List<WebElement> findElements() {
//        return super.findElements();
 //   }

    public void loginWith(String login, String pass){
        type(username, login );
        type(password, login );
        click(signIn);
    }

    @Override
    public boolean isDisplayed(By location) {
        return super.isDisplayed(location);
    }

    public String getURL() {
        return "https://github.com/login";
    }
}
