package BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import BaseClass.ExtendReportManager;

public class BuzzPage {


    WebDriver driver;

    BuzzPage(WebDriver driver)
    {
        this.driver=driver;
    }

    By lnk_buzz = By.xpath("//a[@href='/web/index.php/buzz/viewBuzz']");
    By txt_box = By.xpath("//textarea[@class='oxd-buzz-post-input']");
    By btn_post = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main']");
    By check_msg = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']");

    public void clickBuzz()
    {
        driver.findElement(lnk_buzz).click();
    }

    public void sendMsg(String msg)
    {
        driver.findElement(txt_box).sendKeys(msg);
    }

    public void clickPost()
    {
        driver.findElement(btn_post).click();
    }

    public void checkMsg(String expected_msg) throws InterruptedException
    {
        Thread.sleep(2000);
       WebElement message= driver.findElement(check_msg);
       String actual_message= message.getText();
       Assert.assertEquals(actual_message,expected_msg);


       /*
        SoftAssert sa=new SoftAssert();
       if(actual_message.equals(expected_msg)) {
           sa.assertTrue(true);
           test.pass("Actual Message: "+actual_message+" Expected Message: "+expected_msg);
       }
       else
       {
           sa.assertTrue(false);
           test.fail("Actual Message: "+actual_message+" Expected Message: "+expected_msg);
       }
        */
    }

}