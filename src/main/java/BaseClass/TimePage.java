package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimePage {

    WebDriver driver;

    //constructor
    TimePage(WebDriver driver)
    {
        this.driver=driver;
    }

    //locator
    By btn_time=By.xpath("//button[@class='oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action']");
    By btn_date=By.xpath("//input[@placeholder='yyyy-dd-mm']");



    //action methods

    void clickTime()
    {
        driver.findElement(btn_time).click();
    }

    void clickDate()
    {
        driver.findElement(btn_date).click();
    }
}