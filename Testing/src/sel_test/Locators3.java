package sel_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
    public static void main(String[] args) throws InterruptedException{
       
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Sibling - Child to parent traversing
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElement(By.xpath("/html/body/header/div/button[1]")).getText());
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//button[2]")).getText ());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).click();
        Thread.sleep(5000);
        driver.close();

    }

}
