package sel_test.E_comm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //Thread.sleep(3000);

        String[] itemsNeeded = {"Brocolli", "Cucumber", "Beetroot", "Carrot"};

        addItems(driver,itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        driver.findElement(By.cssSelector("button.promoBtn")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        Thread.sleep(10000);
        //explicit wait can be used here
        
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

    }

    public static void addItems(WebDriver driver,String[] itemsNeeded)
    {
        //expected ArrayList
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0; i<products.size(); i++)
        {
            int j=0;
            String[] name = products.get(i).getText().split("-");
            //extracting only name from the string
            String formattedName = name[0].trim();;

            //check whether name you extracted is present in array or not
            //conver array into array list for easy search
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName))
            {
                j++;
                //click on add to cart button for dynamic text
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                //4 times
                if(j==itemsNeeded.length)
                {
                    break;
                }

        }
    }
    }

}
