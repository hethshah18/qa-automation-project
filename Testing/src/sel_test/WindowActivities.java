package sel_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

     public static void main(String[] args) throws InterruptedException{
       
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        driver.navigate().to("http://rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();
    }
}
