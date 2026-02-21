package sel_test.Office;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Warehouse {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://weshareapp.photos/auth/login");
        driver.get("https://dashboard.weshareapp.photos/auth/login");
        // driver.findElement(By.xpath("//button[.='Sign Up']")).click();
        // driver.findElement(By.id("username")).sendKeys("King");
        // driver.findElement(By.id("email")).sendKeys("hethshah2000+1@gmail.com");
        // driver.findElement(By.id("password")).sendKeys("Het@1234");
        // driver.findElement(By.id("confirm_password")).sendKeys("Het@1234");
        // driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Thread.sleep(3000);
        driver.findElement(By.xpath("//button[.='Sign In']")).click();
        driver.findElement(By.id("email")).sendKeys("hethshah2000+1@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Het@1234");
        driver.findElement(By.className("_button_2wonc_168")).click();
        Thread.sleep(3000);

        driver.findElement(By.className("_create_event_ma4vv_128")).click();
        driver.findElement(By.xpath("//input[@placeholder='Event Name']")).sendKeys("Automation Testing");
        // driver.findElement(By.id("eventType")).click();
        // driver.findElement(By.xpath("//option[text()='Live']")).click();
        driver.findElement(By.cssSelector("div[class='_start_date_10jaw_514'] img[alt='date']")).click();
        driver.findElement(By.className("._filled_10jaw_294")).sendKeys("2026-02-27");
        // driver.findElement(By.xpath(" _clickable_icon_10jaw_914")).sendKeys("2024-07-01");
        // driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}