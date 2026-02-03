package sel_test.Actions;

import java.security.Key;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. Give me the count of links on the page
        //with the help of "a" tagname
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");//open url
        System.out.println(driver.findElements(By.tagName("a")).size());//count of links on the page

        //2. Give me the count of links on footer
        //with the help of "a" tagname
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());//count of links in footer section

        //3. Give me the count of links on first column of footer
        //with the help of "a" tagname
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());//count of links in first column of footer section

        //4. Click on each link in the column and check if the pages are opening
        for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++)
        {
            String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
            //open all the links in new tab
            Thread.sleep(5000L);
        }  
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> It = abc.iterator();

        while(It.hasNext())
        {
            driver.switchTo().window(It.next());
            System.out.println(driver.getTitle());
        }

    }
}
