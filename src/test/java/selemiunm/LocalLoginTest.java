
package selemiunm;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LocalLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void loginTest() {

        // Open login.html file
        File file = new File("login.html");
        driver.get(file.toURI().toString());

        // Enter username
        driver.findElement(By.id("username"))
              .sendKeys("admin");

        // Enter password
        driver.findElement(By.id("password"))
              .sendKeys("admin123");

        // Click login button
        driver.findElement(By.id("loginBtn"))
              .click();

        // Get login message
        String actualMessage =
                driver.findElement(By.id("message")).getText();

        // Verify result
        assertEquals(actualMessage, "Login Successful");

        System.out.println("Login Test Passed Successfully!");

    }

    @AfterMethod
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }

    }
}
