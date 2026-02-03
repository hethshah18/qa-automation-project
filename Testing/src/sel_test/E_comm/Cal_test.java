package sel_test.E_comm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Cal_test {
    public static void main(String[] args) {

        String year = "2028";
        String month = "11";
        String date = "18";
        String[] explist = {month,date,year};
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

        List<WebElement> actuaList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i=0; i<actuaList.size(); i++)
        {
           System.out.println(actuaList.get(i).getAttribute("value"));
           Assert.assertEquals(actuaList.get(i).getAttribute("value"), explist[i]);
        }


    }
}
