package sel_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestiv {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(5000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        //for search category can use this selector

        for(WebElement option : options)
        {
            option.getText();
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }

        System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }

}
