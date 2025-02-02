package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Time_TestCase {

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
    void Time()
    {
        LoginPage lp=new LoginPage(driver);
        lp.setUsername("Admin");
        lp.setPassword("admin123");
        lp.clickLogin();

        TimePage tp=new TimePage(driver);
        tp.clickTime();
        tp.clickDate();

    }

    @AfterClass
    void tearDown()
    {
      //  driver.quit();
    }

}