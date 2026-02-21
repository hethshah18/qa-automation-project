package sel_test.Office;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class weshare {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dashboard.weshareapp.photos/auth/login");
        driver.findElement(By.id("email")).sendKeys("hethshah2000@gmailcom");
        driver.findElement(By.id("password")).sendKeys("Het@1234");
        driver.findElement(By.className("_button_13mlg_139")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@weshare.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Admin!@#$2025");
        driver.findElement(By.className("_button_13mlg_139")).click();
    }
}
