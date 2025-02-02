package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //constructor  - initiate webdriver
    LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //locator

    By txt_username=By.xpath("//input[@name='username']");
    By txt_password=By.xpath("//input[@type='password']");
    By btn_login=By.xpath("//button[@type=\"submit\"]");

    //action methods

    public void setUsername(String username)
    {
        driver.findElement(txt_username).sendKeys(username);
    }

    public void setPassword(String pswd)
    {
        driver.findElement(txt_password).sendKeys(pswd);
    }

    public void clickLogin()
    {
        driver.findElement(btn_login).click();
    }

}