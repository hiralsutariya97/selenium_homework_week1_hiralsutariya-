package nop_commerce;
/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url. “https://demo.nopcommerce.com/login?returnUrl=%2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Test {
    static String baseUrl = "https://demo.nopcommerce.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {
        // Step 1: Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }

        WebDriver driver = new ChromeDriver();
        //Open the URL into browser
        driver.get(baseUrl);

        //Maximize the browser
        driver.manage().window().maximize();
        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get the title of the page.
        String title = driver.getTitle();
        System.out.println(title);

        //Get Current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());

        //Get Page Source
        System.out.println(driver.getPageSource());
        driver.navigate().back();
        System.out.println(" Get Current Url " + driver.getCurrentUrl());

        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);


        //Navigate back to the home pge
        driver.navigate().back();

        //Navigate to the login page
        driver.navigate().forward();

        //Current Url
        System.out.println(" Get Current Url " + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();

        //Find Login link element and click on it.
        WebElement loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();

        //Find Email field Element ant Type the Email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Ram99@gmail.com");

        //Find Password field Element ant Type the Email
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Ram123");

        //Closing browser
        driver.quit();

    }
}
