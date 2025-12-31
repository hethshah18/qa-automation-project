package sel_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); //return date enable
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1"));
        {
            System.out.println("it's enabled");
            Assert.assertTrue(true);
        }
        
            //.ui-state-default.ui-state-active
            // driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click(); //date picker
            // driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click(); //current date selection

            // driver.findElement(By.id("ctl00_mainContent_view_date2")).click(); //return date picker
            // System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
            // driver.findElement(By.id("div1")).getDomAttribute("style").contains("");

//         driver.findElement(By.id("divpaxinfo")).click();
//         Thread.sleep(2000);

//         //int i = 1;
//         // while (i<5) 
//         // {
//         //     driver.findElement(By.id("hrefIncAdt")).click();//4 times 
//         //     i++;
//         // }

//         for (int i=1; i<5 ; i++) 
//         {
//             driver.findElement(By.id("hrefIncAdt")).click(); //4 times
//         }

//         driver.findElement(By.id("btnclosepaxoption")).click();
//         Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
//         System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

//         Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
// //      Assert.assertFalse(false);System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
//         driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
//         Thread.sleep(2000);
//         System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
//         Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());


        //checkbox count   
        // System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());




    }
    
}
