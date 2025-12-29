package sel_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        //int i = 1;
        // while (i<5) 
        // {
        //     driver.findElement(By.id("hrefIncAdt")).click();//4 times 
        //     i++;
        // }

        for (int i=1; i<5; i++) 
        {
            driver.findElement(By.id("hrefIncAdt")).click(); //4 times
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
    
}
