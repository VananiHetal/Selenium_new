import okio.Timeout;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//User should be able to registered on nopcommerce.com

import java.util.concurrent.TimeUnit;


import static javax.print.attribute.standard.MediaSizeName.C;

public class Nopcommerce {

    protected static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\Browserdriver\\chromedriver.exe");
        driver = new ChromeDriver();
//implicit wait applied to driver instance-
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // asking driver to get the url

        driver.get("https://demo.nopcommerce.com");
               //register for a new user
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//Input[@name='FirstName']")).sendKeys("Peter");
        driver.findElement(By.xpath("//Input[@name='LastName']")).sendKeys("Fordman");
        String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
        String emailID = "User"+userName+"@example.com";
        driver.findElement(By.xpath("//Input[@name=\"Email\"]")).sendKeys( emailID);
        driver .findElement(By.xpath("//Input[@name=\"Company\"]")).sendKeys("Peter and Peter Ltd.");
        driver.findElement(By.xpath("//Input[@name=\"Password\"]")).sendKeys("1234ram");
        driver.findElement(By.xpath("//Input[@name=\"ConfirmPassword\"]")).sendKeys("1234ram");
        driver.findElement(By.xpath("//Input[@name=\"register-button\"]")).click();
       String actualRegistrationSuccessMessage = driver.findElement(By.xpath( "//div[@class=\"result\"]")).getText();


       Assert.assertEquals("User should be ",actualRegistrationSuccessMessage);

        //quit driver instance
        driver.quit();

    }
}
