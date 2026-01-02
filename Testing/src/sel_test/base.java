package sel_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //expected ArrayList
        String[] names = {"Cucumber", "Brocolli", "Beetroot"};


        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0; i<products.size(); i++)
        {
            String name = products.get(i).getText();
            if(name.contains("Cucumber"))
            {
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();//clicking on add to cart button
                break;
            }

        }
    }
}
