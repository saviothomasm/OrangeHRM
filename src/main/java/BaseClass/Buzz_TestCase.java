package BaseClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Buzz_TestCase {


    WebDriver driver;

    String filepath = "C:\\Users\\savio\\Documents\\OrangeHRM\\Data.xlsx";

    @BeforeClass
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void Login() throws IOException {

        String username=ExcelUtility.getCellData(filepath,"Credentials",1,0);
        String password=ExcelUtility.getCellData(filepath,"Credentials",1,1);

        LoginPage lp=new LoginPage(driver);
        lp.setUsername(username);
        lp.setPassword(password);
        lp.clickLogin();
    }

    @Test(priority = 2)
    void Buzz() throws IOException, InterruptedException {

        int rows=ExcelUtility.getRowCount(filepath,"Messages");

        BuzzPage bp=new BuzzPage(driver);
        bp.clickBuzz();

        for(int i=1;i<rows;i++)
        {
            String messages=ExcelUtility.getCellData(filepath,"Messages",i,1);

            System.out.println(messages);

            bp.sendMsg(messages);
            bp.clickPost();
            bp.checkMsg(messages);

        }
    }

    @AfterClass
    void tearDown()
    {
        //       driver.quit();

        /*
        public String captureScreen(String tname) throws IOException
        {

            String timeStamp = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());

            TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
            File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

            try
            {
                FileUtils.copyFile(source, new File(destination));
            }
            catch(Exception e)
            {
                e.getMessage();
            }

            return destination;
        }
*/

    }

}
