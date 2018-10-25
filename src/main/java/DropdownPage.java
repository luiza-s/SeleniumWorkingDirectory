import base.BasePage;
import org.openqa.selenium.WebDriver;

public class DropdownPage extends BasePage {
    public String getURL() {
        return "";
    }

    public DropdownPage(WebDriver driver){
        super(driver);
        driver.get(getURL());

    }

    public void selectOption(){
        Select select = new Select(find(By.id("dropdown"))) ;
        select.selectByIndex(index);

    }
}
