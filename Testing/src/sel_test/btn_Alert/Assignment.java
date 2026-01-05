package sel_test.btn_Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
    public static void main(String[] args) throws InterruptedException {
        
        String text = "Het";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());//capture alert text
        driver.switchTo().alert().accept();//click ok

        driver.findElement(By.id("confirmbtn")).click();//click confirm button
        System.out.println(driver.switchTo().alert().getText());//capture confirm alert text
        driver.switchTo().alert().dismiss();//click cancel
        
    }
}
