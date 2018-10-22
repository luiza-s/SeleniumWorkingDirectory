import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.* ;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by luiza.suryan on 10/21/2018.
 */
public class UsingSelctors {

    private WebDriver driver;

    @BeforeMethod
            public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    @Test
    public void testSelectors(){
        String URL="https://www.facebook.com";
        driver.get(URL);

        String PageTitle = driver.getTitle();
        System.out.println("Page title is: " + PageTitle);
        String PageURL = driver.getCurrentUrl();
        System.out.println("Page URL is: "+ PageURL);

        //sign up

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("My FirstName");
        WebElement lastName = driver.findElement(By.cssSelector("input#u_0_l"));
        lastName.sendKeys("My LastName");
        WebElement eMailOrPhone = driver.findElement(By.xpath("//*[@id=\"u_0_o\"]"));
        eMailOrPhone.sendKeys("myemail@mail.po");
       // WebElement gender= driver.findElement(By.name("gender_wrapper"));

       // gender.isSelected("");
        WebElement submit = driver.findElement(By.name("websubmit"));
        submit.click();

//        //handle radiobuttons
//        String genderSelected="1";
//        List <WebElement> genderList;
//        genderList = (List<WebElement>) driver.findElement(By.name("sex"));
//        System.out.println(genderList.size());
//        for (int i=0; i<genderList.size(); i++)
//        {
//           String genderValue = genderList.get(i).getAttribute("value");
//           if(genderValue.equalsIgnoreCase(genderSelected)){
//               genderList.get(i).click();
//               break;
//           }
//
//        }

        WebElement genderFemale= driver.findElement(By.xpath("//*[@id=\"u_0_9\"]"));
        WebElement genderMale= driver.findElement(By.xpath("//*[@id=\"u_0_a\"]"));
        String genderToBeSelected = "2";
           if(genderToBeSelected.equalsIgnoreCase("1")) {
                   genderFemale.click();
                System.out.println(genderFemale.getAttribute("value")) ;
           }
           else if(genderToBeSelected.equalsIgnoreCase("2")) {
                   genderMale.click();
                    System.out.println(genderMale.getAttribute("value")) ;
           }
        System.out.println(genderToBeSelected);
   
           WebElement forgot =driver.findElement(By.linkText("Forgotten account?"));
           forgot.click();
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();

    }

}
