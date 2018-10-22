import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by luiza.suryan on 10/19/2018.
 */
public class LoginTest {
    private WebDriver driver;



    @Test

    public void successLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://sis2s074:8101/btc-mis/");

        assertTrue(driver.getCurrentUrl().contentEquals("http://sis2s074:8101/btc-mis/"), "incorrect page");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("index_login_btn")).click();
        assertTrue(driver.getCurrentUrl().contentEquals("http://sis2s074:8101/btc-mis/main/"), "incorrect page1");
        driver.findElement(By.className("usr-section")).click();
        driver.findElement(By.id("user_profile")).click();
        System.out.println("First Name is :"+driver.findElement(By.xpath("//*[@id=\"firstName\"]")).getText());
        System.out.println("First Name is :"+driver.findElement(By.id("firstName")).getText());
        System.out.println("First Name is :"+driver.findElement(By.id("firstName")).getText());
//        assertTrue(driver.findElement(By.id("firstName")).getText().contentEquals("System"), "First Name is incorrect");
//        assertTrue(driver.findElement(By.id("lastName")).getText().contentEquals("System"), "Last Name is incorrect");
//        assertTrue(driver.findElement(By.id("email")).getText().contentEquals("luiza.suryan-1@synisys.com"), "email is incorrect");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
