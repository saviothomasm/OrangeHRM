package BaseClass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_TestCase {

    WebDriver driver;

    @BeforeClass
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    void testLogin()
    {
        LoginPage lp=new LoginPage(driver);
        lp.setUsername("Admin");
        lp.setPassword("admin123");
        lp.clickLogin();
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @AfterClass
    void tearDown()
    {
  //      driver.quit();
    }

}
