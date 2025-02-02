package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class login_withoutPOM {

    public static void main(String args[])
    {
        WebDriver driver = new ChromeDriver();
    //    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get("https://www.cricbuzz.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   //     Assert.assertEquals(driver.getTitle(),"Live Cricket Score, Schedule, Latest News, Stats & Videos | Cricbuzz.com");

   //     driver.quit();

    }
}