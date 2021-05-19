package homeworknopcommerce1;
/*
Navigate to website "https://demo.nopcommerce.com/"
Click on register link.
Fill the all fields.
Click on register button.
Verify that the user register successfully.

 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegisterNopCommerce {
  WebDriver driver;//global variable/instance variable

    @Before
    public void setUp() {
     //open a Url and Navigate to website "https://demo.nopcommerce.com/"

        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
   //Click on register link.
   //Fill the all fields.
    @Test
    public void verifyUserShouldRegisterSuccessfully() throws InterruptedException {

        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(3000);//webdriver waits for specified time
        driver.findElement(By.xpath("//input[@id='gender-female']")).click();
        Thread.sleep(2000);//wait for specified time
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Shivansh");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patel");
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("6");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("10");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1998");
        //generating the random number using random method
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Shivansh12" + randomInt+ "@yahoo.com");
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("MahkalEnterprise");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Mal123");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Mal123");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        String expectedMessage = "Your registration completed";
        WebElement message= driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage=message.getText();
        Assert.assertEquals("user is not registered successfully",expectedMessage,actualMessage);

    }

    @After
   public void tearDown() {
        driver.quit();
    }
}
