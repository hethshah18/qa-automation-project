package sel_test.basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class rahulsir_locator2nd {

    public static void main(String[] args) throws InterruptedException{
       
        String name = "het";
        WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String password = getPass(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();
    }

    public static String getPass(WebDriver driver) throws InterruptedException
    {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        String[] passwordArray = passwordText.split("'");
        // String[] passwordArray2 = passwordArray[1].split("'");
        // passwordArray2[0];
        String password = passwordArray[1].split("'")[0];
        return password;

    }
}
